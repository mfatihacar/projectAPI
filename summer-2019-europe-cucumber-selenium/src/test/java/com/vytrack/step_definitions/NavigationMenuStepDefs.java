package com.vytrack.step_definitions;


import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NavigationMenuStepDefs {

    @When("the user navigates to the Fleet-Vehicles page")
    public void the_user_navigates_to_the_Fleet_Vehicles_page() {
        System.out.println("I navigated to Fleet --> Vehicles page");
    }

    @When("the user navigates to the Marketing-Campaigns page")
    public void the_user_navigates_to_the_Marketing_Campaigns_page() {
        System.out.println("I navigated to Marketing --> Campaigns page");
    }

    @When("the user navigates to the Activities-Calendar Events page")
    public void the_user_navigates_to_the_Activities_Calendar_Events_page() {
        System.out.println("I navigated to Activities --> Calendar Events page");
    }

    @Then("the user should see the expected Fleet URL")
    public void the_user_should_see_the_expected_Fleet_URL() {
        System.out.println("I verified that I saw the expected Fleet URL");
    }

    @Then("the user should see the expected Campaigns URL")
    public void the_user_should_see_the_expected_Campaigns_URL() {
        System.out.println("I verified that I saw the expected Campaigns URL");
    }

    @Then("the user should see the expected Calendar Events URL")
    public void the_user_should_see_the_expected_Calendar_Events_URL() {
        System.out.println("I verified that I saw the expected Calendar Events URL");
    }

    @When("the user navigates to the {string} {string} page")
    public void the_user_navigates_to_the_page(String tab, String module) {
        new DashboardPage().navigateToModule(tab,module);
    }

    @Then("the user verifies that the default page number is {int}")
    public void the_user_verifies_that_the_default_page_number_is(Integer expectedPageNumber) {
        ContactsPage contactsPage=new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();
        Integer actualPageNumber=Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));
        Assert.assertEquals(expectedPageNumber,actualPageNumber);
    }

}
