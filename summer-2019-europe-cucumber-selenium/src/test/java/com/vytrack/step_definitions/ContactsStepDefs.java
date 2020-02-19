package com.vytrack.step_definitions;

import com.vytrack.pages.*;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.DBUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ContactsStepDefs {

    @Then("the user should see following menu options")
    public void the_user_should_see_following_menu_options(List<String> menuOptions) {
        System.out.println("menuOptions.size = " + menuOptions.size());
        System.out.println("Menu options: " +menuOptions);
        //get value from website
        BrowserUtils.waitFor(2);
        DashboardPage dashboardPage = new DashboardPage();
        List<String> actualMenuOptions = BrowserUtils.getElementsText(dashboardPage.menuOptions);
        System.out.println(actualMenuOptions);

        //compare actual list from website and expected list from scenario
        assertEquals(menuOptions,actualMenuOptions);

    }

    @When("the use logs in using following credentials")
    public void the_use_logs_in_using_following_credentials(Map<String,String> userData) {
        new LoginPage().login(userData.get("username"),userData.get("password"));
        //verify fullname on the top right corner from website with firstname,lastname from map

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        String actualFullname = dashboardPage.getUserName();
        String expectedFullname= userData.get("firstname")+" "+userData.get("lastname");

        assertEquals(expectedFullname,actualFullname);

    }

    @When("the user clicks on {string} from contacts")
    public void the_user_clicks_on_from_contacts(String email) {
        ContactsPage contactsPage=new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail(email).click();
    }

    @Then("the information should be the same as database")
    public void the_information_should_be_the_same_as_database() {
        ContactInfoPage contactInfoPage=new ContactInfoPage();
        String actualEmail=contactInfoPage.email.getText();
        String actualFullName=contactInfoPage.contactFullName.getText();
        String actualPhone=contactInfoPage.phone.getText();
        String query="select concat(oc.name_prefix, ' ', oc.first_name, ' ', oc.last_name) as \"full_name\", oce.email, phone \n" +
                "from orocrm_contact oc left outer join orocrm_contact_phone ocm on oc.id=ocm.owner_id\n" +
                "join orocrm_contact_email oce on ocm.owner_id=oce.owner_id\n" +
                "where oce.email='mbrackstone9@example.com'";
        Map<String, Object> rowMap = DBUtils.getRowMap(query);
        String expectedFullName=(String) rowMap.get("full_name");
        Object expectedPhone=(String) rowMap.get("phone");
        Object expectedEmail=(String) rowMap.get("email");

        assertEquals(expectedFullName,actualFullName);
        assertEquals(expectedEmail,actualEmail);
        assertEquals(expectedPhone,actualPhone);
    }

    @Then("the information for {string} should be the same as database")
    public void the_information_for_should_be_the_same_as_database(String email) {
        ContactInfoPage contactInfoPage=new ContactInfoPage();
        String actualEmail=contactInfoPage.email.getText();
        String actualFullName=contactInfoPage.contactFullName.getText();
        String actualPhone=contactInfoPage.phone.getText();
        String query="select concat(oc.name_prefix, ' ', oc.first_name, ' ', oc.last_name) as \"full_name\", oce.email, phone \n" +
                "from orocrm_contact oc left outer join orocrm_contact_phone ocm on oc.id=ocm.owner_id\n" +
                "join orocrm_contact_email oce on ocm.owner_id=oce.owner_id\n" +
                "where oce.email='"+email+"'";
        Map<String, Object> rowMap = DBUtils.getRowMap(query);
        String expectedFullName=(String) rowMap.get("full_name");
        Object expectedPhone=(String) rowMap.get("phone");
        Object expectedEmail=(String) rowMap.get("email");

        assertEquals(expectedFullName,actualFullName);
        assertEquals(expectedEmail,actualEmail);
        assertEquals(expectedPhone,actualPhone);
    }


}