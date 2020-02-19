package com.automation.test.Day2;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CloudTesting {

    public static String userName = "mailmail7";
    public static String accessKey = "9pxkL35Nyxfzjqsrq2Rw";
    public static String URL="https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub";
    private AppiumDriver driver;
    private String email = "everly10@uspeakw.com";
    private String password = "Cybertek2020";

    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("device", "Google Pixel 4");
        caps.setCapability("os_version", "10.0");
        caps.setCapability("project", "Calculator");
        caps.setCapability("build", "My First Build");
        caps.setCapability("name", "Calculator Test");
        caps.setCapability("app", "bs://70b8d9c773cf92dea7d0d52d06d276472918f5d1");
        caps.setCapability("browserstack.video",true);
        driver=new AndroidDriver(new URL(URL),caps);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.etsy.android:id/btn_link")));
        WebElement getStarted = driver.findElement(By.id("com.etsy.android:id/btn_link"));
        getStarted.click();
        WebElement usernameElement = driver.findElementById("com.etsy.android:id/edit_username");
        WebElement passwordElement = driver.findElementById("com.etsy.android:id/edit_password");
        WebElement signinElement = driver.findElementById("com.etsy.android:id/button_signin");
        usernameElement.sendKeys(email);
        passwordElement.sendKeys(password);
        signinElement.click();
        Thread.sleep(5000);
        driver.quit();
    }
}
