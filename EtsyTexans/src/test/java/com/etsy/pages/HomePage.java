package com.etsy.pages;

import com.etsy.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//button[@class='width-full btn btn-outline btn-outline-black']")
    public WebElement privacyAcceptButton;


}
