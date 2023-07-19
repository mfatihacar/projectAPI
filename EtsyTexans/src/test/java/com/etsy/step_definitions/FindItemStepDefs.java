package com.etsy.step_definitions;

import com.etsy.pages.HomePage;
import com.etsy.pages.ItemPage;
import com.etsy.utilities.BrowserUtils;
import com.etsy.utilities.ConfigurationReader;
import com.etsy.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class FindItemStepDefs {

    String currentWindowHandle="";

    @Given("the user is on the etsy homepage")
    public void the_user_is_on_the_etsy_homepage() {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().maximize();
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String searchKeyword) {
        BrowserUtils.waitForPageToLoad(10);
        HomePage homePage=new HomePage();
        homePage.privacyAcceptButton.click();
        BrowserUtils.waitFor(2);
        homePage.searchInputBox.sendKeys(searchKeyword, Keys.ENTER);
    }

    @When("the user chooses deliver to {string}")
    public void the_user_chooses_deliver_to(String country) {
        BrowserUtils.waitForPageToLoad(20);
        ItemListPage obj1=new ItemListPage();
        BrowserUtils.waitFor(3);
        obj1.deliverToSelect.selectByVisibleText(country);
        //BrowserUtils.waitFor(3);
    }

    @When("the user clicks on the {string} item")
    public void the_user_clicks_on_the_item(String productIdentifier) {
        BrowserUtils.waitForPageToLoad(10);
        currentWindowHandle=Driver.get().getWindowHandle();
        String xpathAdPart="/parent::*/parent::*/parent::*/preceding-sibling::*/div/div/div/div/div/span";
        String xpathItemNamePart="/parent::*/preceding-sibling::h2";
        ItemListPage itemListPage=new ItemListPage();
        outerloop:for(int j=1;j<=5;j++){
            if(itemListPage.texansItemsList.size()>0){
                innerloop: for (int i = 0; i < itemListPage.texansItemsList.size(); i++) {
                    String xpathOfAd="";
                    String xpathOfItem="";
                    String xpathOfItemName="";
                    xpathOfItem=itemListPage.getXPath(i);
                    xpathOfAd=xpathOfItem+xpathAdPart;
                    xpathOfItemName=xpathOfItem+xpathItemNamePart;
                    List<WebElement> adSignList=Driver.get().findElements(By.xpath(xpathOfAd));
                    List<WebElement> itemTitle=Driver.get().findElements(By.xpath(xpathOfItemName));
                    System.out.println("i="+i);
                    System.out.println(itemTitle.get(0).getText());
                    System.out.println(productIdentifier);
                    System.out.println("number of ads="+adSignList.size());
                    if(adSignList.size()==0 && itemTitle.get(0).getText().contains(productIdentifier)){
                        itemTitle.get(0).click();
                        //BrowserUtils.waitFor(3);
                        break outerloop;
                    }
                }
                itemListPage.pageNumbers.get(j+3).click();
                BrowserUtils.waitForPageToLoad(5);
            }else{
                itemListPage.pageNumbers.get(j+3).click();
                BrowserUtils.waitForPageToLoad(5);
            }
        }
    }

    @Then("the seller title should be {string}")
    public void the_seller_title_should_be(String expectedSellerName) {
        BrowserUtils.waitForPageToLoad(10);
        Set<String> windowHandles=Driver.get().getWindowHandles();
        for (String windowHandle : windowHandles) {
            if(!currentWindowHandle.equals(windowHandle)){
                Driver.get().switchTo().window(windowHandle);
            }
        }
        ItemPage itemPage=new ItemPage();
        Assert.assertEquals(expectedSellerName,itemPage.sellerName.getText());
    }
}
