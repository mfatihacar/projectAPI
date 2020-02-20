package com.automation.test.Day3;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


import java.net.MalformedURLException;
import java.net.URL;

public class MobileWebTestAutomation {

    RemoteWebDriver driver;
    //RemoteWebDriver is the super class of WebDriver interface

    @BeforeTest
    public void setupMethod() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", Platform.ANDROID);
        desiredCapabilities.setCapability("platformVersion","7.0");
        desiredCapabilities.setCapability("deviceName","Pixel_2");
        desiredCapabilities.setCapability("automationName","UiAutomator2");
        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
        desiredCapabilities.setCapability("w3c",true);
        //to specify ChromeDriver within the code (and not in Appium server):
//        WebDriverManager.chromedriver().setup();
//        desiredCapabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,WebDriverManager.chromedriver().getBinaryPath());
        driver=new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
    }

    @AfterTest
    public void tearDownMethod(){
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("http://zero.webappsecurity.com/login.html");
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password",Keys.ENTER);
        String str="checking";
        driver.findElement(By.id("searchTerm")).sendKeys(str,Keys.ENTER);
        String actualMessage=driver.findElement(By.className("top_offset")).getText();
        Assert.assertEquals(actualMessage.split(": ")[1],str);
    }
}
