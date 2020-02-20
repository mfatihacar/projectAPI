package com.cucumber.step_definitions;

import com.cucumber.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {

    @Given("the user clicks on get started")
    public void the_user_clicks_on_get_started() {
        new LoginPage().clickOnGetStarted();
    }

    @When("the user logs in with etsy credentials")
    public void the_user_logs_in_with_etsy_credentials() {
        new LoginPage().login();
    }

    @Then("the user verifies that etsy logo is displayed")
    public void the_user_verifies_that_etsy_logo_is_displayed() {

    }
}
