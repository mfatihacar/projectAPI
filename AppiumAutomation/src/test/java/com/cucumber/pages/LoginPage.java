package com.cucumber.pages;

import com.cucumber.utilities.ConfigurationReader;
import com.cucumber.utilities.Driver;
import com.cucumber.utilities.MobileUtilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.get()),this);
    }

    @AndroidFindBy(id = "com.etsy.android:id/edit_username")
    private MobileElement emailInputBox;

    @AndroidFindBy(id = "com.etsy.android:id/edit_password")
    private MobileElement passwordInputBox;

    @AndroidFindBy(id = "com.etsy.android:id/button_signin")
    private MobileElement signInButton;

    public void login() {
        String email = ConfigurationReader.get("email");
        String password = ConfigurationReader.get("password");
        MobileUtilities.waitForPresence(By.id("com.etsy.android:id/edit_username"));
        emailInputBox.sendKeys(email);
        passwordInputBox.sendKeys(password);
        signInButton.click();
    }


}
