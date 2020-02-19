package com.automation.test.Day1;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculator {

    AndroidDriver<WebElement> driver;

    @Test
    public void test1() throws Exception {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION,"7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel_2");
        desiredCapabilities.setCapability("appActivity","com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("appPackage","com.android.calculator2");
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,0);
        driver=new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);

        WebElement digit1=driver.findElement(By.id("com.android.calculator2:id/digit_1"));
        WebElement digit2=getDigit(2);
        WebElement plus=driver.findElement(MobileBy.AccessibilityId("plus"));
        WebElement equals=driver.findElementByAccessibilityId("equals");
        WebElement result=driver.findElement(By.id("com.android.calculator2:id/result"));
        WebElement minus = driver.findElement(MobileBy.AccessibilityId("minus"));
        WebElement multiply = driver.findElement(MobileBy.AccessibilityId("multiply"));
        WebElement divide = driver.findElement(MobileBy.AccessibilityId("divide"));
//        WebElement delete = driver.findElement(MobileBy.AccessibilityId("delete"));
        WebElement delete = driver.findElementByAccessibilityId("delete");
        WebElement formula=driver.findElement(By.id("com.android.calculator2:id/formula"));

        digit1.click();
        digit2.click();
        plus.click();
        digit2.click();
        digit2.click();
        equals.click();

        //2 * 2 = 4
        getDigit(2).click();//click on 2
        multiply.click();
        getDigit(2).click();//click on 2
        equals.click();
        Assert.assertEquals("4", result.getText());

        //10 - 5 + 6 = 11

        getDigit(1).click();
        getDigit(0).click();
        minus.click();
        getDigit(5).click();
        plus.click();
        getDigit(6).click();
        equals.click();

        Assert.assertEquals("11", result.getText());

        String actualResult=result.getText();
        System.out.println("actualResult = " + actualResult);

        Assert.assertTrue(result.isDisplayed());
        Assert.assertFalse(formula.isDisplayed());

        driver.closeApp();
    }

    public WebElement getDigit(int digit){
        return driver.findElement(By.id("com.android.calculator2:id/digit_"+digit));
    }
}
