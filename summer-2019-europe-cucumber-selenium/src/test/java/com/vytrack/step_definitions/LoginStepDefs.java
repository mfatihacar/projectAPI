package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("Opening the login page");
        String url=ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the user enters the driver credentials")
    public void the_user_enters_the_driver_credentials() {
        LoginPage loginPage=new LoginPage();
        String username=ConfigurationReader.get("driver_username");
        String password=ConfigurationReader.get("driver_password");
        loginPage.login(username,password);
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        DashboardPage dashboardPage=new DashboardPage();
        BrowserUtils.waitFor(2);
        String expectedTitle="Dashboard";
        String actualTitle=Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("the user enters the sales manager credentials")
    public void the_user_enters_the_sales_manager_credentials() {
        LoginPage loginPage=new LoginPage();
        String username=ConfigurationReader.get("salesmanager_username");
        String password=ConfigurationReader.get("salesmanager_password");
        loginPage.login(username,password);
    }

    @When("the user enters store manager credentials")
    public void the_user_enters_store_manager_credentials() {
        LoginPage loginPage=new LoginPage();
        String username=ConfigurationReader.get("storemanager_username");
        String password=ConfigurationReader.get("storemanager_password");
        loginPage.login(username,password);
    }

    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String string, String string2) {
        LoginPage loginPage=new LoginPage();
        loginPage.login(string,string2);
    }

    @Then("the title should contain {string}")
    public void the_title_should_contain(String string) {
        DashboardPage dashboardPage=new DashboardPage();
        BrowserUtils.waitFor(2);
        String actualTitle=Driver.get().getTitle();
        Assert.assertEquals(string,actualTitle);
    }

}
