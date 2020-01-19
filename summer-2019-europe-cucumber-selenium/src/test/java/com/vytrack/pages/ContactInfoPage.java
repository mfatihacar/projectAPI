package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInfoPage extends BasePage {

    @FindBy(xpath = "//*[@class='user-name']")
    public WebElement fullName;

    @FindBy (xpath = "//*[@class='email']")
    public WebElement emailAddressInfo;

    @FindBy (xpath = "//*[@class='phone']")
    public WebElement phoneNumber;
}
