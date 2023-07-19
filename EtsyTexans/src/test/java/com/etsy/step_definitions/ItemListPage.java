package com.etsy.step_definitions;

import com.etsy.pages.BasePage;
import com.etsy.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ItemListPage extends BasePage {

    public ItemListPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(name = "ship_to")
    public WebElement deliverToDropdown;

    public Select deliverToSelect=new Select(deliverToDropdown);

    @FindBy(xpath = "//*[.='TexansWatchbands']")
    public List<WebElement> texansItemsList;

    @FindBy(xpath = "//li[@class='wt-action-group__item-container']")
    public List<WebElement> pageNumbers;

    @FindBy(xpath = "//*[.='TexansWatchbands']/parent::*/parent::*/parent::*/preceding-sibling::*/div/div/div/div/div/span")
    public WebElement adSign;

    @FindBy(xpath = "//*[.='TexansWatchbands']/parent::*/preceding-sibling::*")
    public WebElement itemTitle;

    public String getXPath (int i){
        String result="(//*[.='TexansWatchbands'])["+(i+1)+"]";
        return result;
    }

    //li/div/a/div/div/div/div/div/div/span


}
