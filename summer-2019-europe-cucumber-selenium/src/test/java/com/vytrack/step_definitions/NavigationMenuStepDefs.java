package com.vytrack.step_definitions;

import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NavigationMenuStepDefs {


    @When("the user navigates to Fleet, Vehicles")
    public void the_user_navigates_to_Fleet_Vehicles() {
        System.out.println("Navigate to Fleet Vehicles");
    }



    @When("the user navigates Marketing Campaigns")
    public void the_user_navigates_Marketing_Campaigns() {
        System.out.println("Navigate to Marketing Campaigns");

    }



    @When("the user navigates Activities - Calendar events")
    public void the_user_navigates_Activities_Calendar_events() {
        System.out.println("Navigate to Activities Calendar events");

    }


    @Then("the url should be expected Fleet url")
    public void the_url_should_be_expected_Fleet_url() {
        System.out.println("Expected ==Actual PASS");
    }

    @Then("the url should be expected Campaigns url")
    public void the_url_should_be_expected_Campaigns_url() {
        System.out.println("Expected ==Actual PASS");

    }

    @Then("the url should be expected Activities url")
    public void the_url_should_be_expected_Activities_url() {
        System.out.println("Expected ==Actual PASS");

    }

    @When("the user navigates {string} {string}")
    public void the_user_navigates(String tab, String module) {
        new DashboardPage().navigateToModule(tab,module);

    }

    @Then("default page number should be {int}")
    public void default_page_number_should_be(Integer ePageNumber) {
        ContactsPage contactsPage = new ContactsPage();

        Integer actualNumber = Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));

        Assert.assertEquals(actualNumber,ePageNumber);
    }



}
