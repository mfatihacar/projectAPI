package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ContactsStepDefs {
    @Then("the user should see the following menu options")
    public void the_user_should_see_the_following_menu_options(List<String> expectedMenuOptions) {
        DashboardPage dashboardPage=new DashboardPage();
        BrowserUtils.waitFor(2);
        List<String> actualMenuOptions= BrowserUtils.getElementsText(dashboardPage.menuOptions);
        Assert.assertEquals(expectedMenuOptions,actualMenuOptions);
    }

    @When("the user logs  in using the following credentials")
    public void the_user_logs_in_using_the_following_credentials(Map<String,String> userData) {
        new LoginPage().login(userData.get("username"),userData.get("password"));
        DashboardPage dashboardPage=new DashboardPage();
        String username=dashboardPage.getUserName();
        BrowserUtils.waitFor(2);
        String expectedFirstName=username.split(" ")[0];
        String expectedLastName=username.split(" ")[1];
        Assert.assertEquals(expectedFirstName,userData.get("firstname"));
        Assert.assertEquals(expectedLastName,userData.get("lastname"));
        Assert.assertEquals("Dashboard", Driver.get().getTitle());
    }
}
