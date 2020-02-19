package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginStepDefs {



    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws InterruptedException {
        System.out.println("Opening the login page");
        //Driver.get()--> this gets the webdriver
        //driver ==Driver.get()
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the user enter the driver information")
    public void the_user_enter_the_driver_information() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        loginPage.login(username,password);

    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() throws InterruptedException {

        BrowserUtils.waitFor(2);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Dashboard",actualTitle);


    }

    @When("the user enter the sales manager information")
    public void the_user_enter_the_sales_manager_information() {
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("sales_manager_username");
        String password = ConfigurationReader.get("sales_manager_password");
        loginPage.login(username,password);


    }

    @When("the user enter the store manager information")
    public void the_user_enter_the_store_manager_information() {
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("store_manager_username");
        String password = ConfigurationReader.get("store_manager_password");
        loginPage.login(username,password);
    }

    @When("user logs in using {string} and {string}")
    public void user_logs_in_using_and(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }

    @Then("the title should contains {string}")
    public void the_title_should_contains(String expectedTitle) {
        BrowserUtils.waitFor(1);
        System.out.println("expectedTitle = " + expectedTitle);
        Assert.assertTrue("Actual title:"+Driver.get().getTitle(),Driver.get().getTitle().contains(expectedTitle));

    }

    @Given("the user logged in as a {string}")
    public void the_user_logged_in_as_a(String user) {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        String username = null;
        String password = null;

        if(user.equals("driver")){
             username = ConfigurationReader.get("driver_username");
             password = ConfigurationReader.get("driver_password");
        }else if(user.equals("sales manager")){
             username = ConfigurationReader.get("sales_manager_username");
             password = ConfigurationReader.get("sales_manager_password");
        }else if(user.equals("store manager")){
             username = ConfigurationReader.get("store_manager_username");
             password = ConfigurationReader.get("store_manager_password");
        }


        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }



}
