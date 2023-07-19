package com.gorest.step_definitions;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.gorest.URLHelper;
import com.gorest.dto.users.request.UserRequest;
import com.gorest.dto.users.response.UserResponse;
import com.gorest.dto.users.response.UsersResponse;
import com.gorest.utilities.Requests;
import com.gorest.utilities.SharedObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class UserStepDefinitions {

    private final Faker faker = new Faker();

    @Given("I get all users")
    public void iGetAllUsers() {
        SharedObjects.response = Requests.getRequest(URLHelper.USERS_SERVICE);
    }

    @Given("I have the total number of users")
    public void iHaveTheTotalNumberOfUsers() {
        SharedObjects.numberOfUsers =
                this.getAllUsersResponse().getMeta().getPagination().getTotal();
    }

    @When("I create a new user")
    public void iCreateANewUser() {
        String body =
                new Gson()
                        .toJson(
                                UserRequest.newInstance(
                                        faker.name().fullName(),
                                        "Male",
                                        faker.internet().emailAddress(),
                                        "Active"));
        SharedObjects.response = Requests.postRequest(URLHelper.USERS_SERVICE, body, true);
    }

    @Then("the response code is {int}")
    public void theResponseCodeIs(int expectedResponseCode) {
        int actualResponseCode;
        if (SharedObjects.response.statusCode() == 200) {
            if (SharedObjects.response.getBody().jsonPath().get("data") != null) {
                if (SharedObjects.response
                        .getBody()
                        .jsonPath()
                        .get("data")
                        .getClass()
                        .getName()
                        .equals("java.util.ArrayList")) {
                    actualResponseCode = this.getAllUsersResponse().getCode();
                } else {
                    actualResponseCode = this.getSingleUserResponse().getCode();
                }
            } else {
                actualResponseCode = this.getAllUsersResponse().getCode();
            }
        } else {
            actualResponseCode = SharedObjects.response.statusCode();
        }

        if (actualResponseCode != expectedResponseCode) {
            throw new RuntimeException(
                    "Expected response code - "
                            + expectedResponseCode
                            + "\nActual response code - "
                            + actualResponseCode
                            + " : "
                            + SharedObjects.response.getBody().asString());
        }
    }

    @Then("the total number of users has increased by 1")
    public void theTotalNumberOfUsersHasIncreasedBy() {
        int expectedNumberOfUsers = SharedObjects.numberOfUsers;
        this.iGetAllUsers();
        int actualNumberOfUsers = this.getAllUsersResponse().getMeta().getPagination().getTotal();
        assertThat(actualNumberOfUsers).isEqualTo(expectedNumberOfUsers + 1);
    }

    @Given("I get a user")
    public void iGetAUser() {
        int id = faker.number().numberBetween(200, 300);
        SharedObjects.response = Requests.getRequest(URLHelper.USERS_SERVICE + "/" + id);
        SharedObjects.usersId = id;
    }

    @When("I get the user")
    public void iGetTheUser() {
        SharedObjects.response =
                Requests.getRequest(URLHelper.USERS_SERVICE + "/" + SharedObjects.usersId);
    }

    @Given("I have the e-mail address of another user")
    public void iHaveTheEMailAddressOfAnotherUser() {
        SharedObjects.response =
                Requests.getRequest(
                        URLHelper.USERS_SERVICE + "/" + faker.number().numberBetween(400, 500));
        SharedObjects.otherUsersEmailAddress = this.getSingleUserResponse().getData().getEmail();
    }

    @When("I create a new user using the same e-mail address")
    public void iCreateANewUserUsingTheSameEMailAddress() {
        String body =
                new Gson()
                        .toJson(
                                UserRequest.newInstance(
                                        faker.name().fullName(),
                                        "Male",
                                        SharedObjects.otherUsersEmailAddress,
                                        "Active"));
        SharedObjects.response = Requests.postRequest(URLHelper.USERS_SERVICE, body, true);
    }

    @Then("the total number of users has not changed")
    public void theTotalNumberOfUsersHasNotChanged() {
        int expectedNumberOfUsers = SharedObjects.numberOfUsers;
        this.iGetAllUsers();
        int actualNumberOfUsers = this.getAllUsersResponse().getMeta().getPagination().getTotal();
        assertThat(actualNumberOfUsers).isEqualTo(expectedNumberOfUsers);
    }

    @Given("I have the name of the user")
    public void iHaveTheNameOfTheUser() {
        SharedObjects.usersName = this.getSingleUserResponse().getData().getName();
    }

    @When("I update the name of a user")
    public void iUpdateTheNameOfAUser() {
        String body = "{\"name\":\"" + faker.name().fullName() + "\"}";
        SharedObjects.response =
                Requests.patchRequest(
                        URLHelper.USERS_SERVICE + "/" + SharedObjects.usersId, body, true);
    }

    @Then("the name of the user has been updated")
    public void theNameOfTheUserHasBeenUpdated() {
        this.iGetTheUser();
        String expectedName = SharedObjects.usersName;
        String actualName = this.getSingleUserResponse().getData().getName();
        assertThat(actualName).isNotEqualTo(expectedName);

        System.out.println(expectedName);
    }

    @When("I update the e-mail address of the first user with the same e-mail address")
    public void iUpdateTheEMailAddressOfAnotherUserWithTheSameEMailAddress() {
        String body = "{\"email\":\"" + SharedObjects.otherUsersEmailAddress + "\"}";
        SharedObjects.response =
                Requests.patchRequest(
                        URLHelper.USERS_SERVICE + "/" + SharedObjects.usersId, body, true);
    }

    @Then("the e-mail address of the user has not changed")
    public void theEMailAddressOfTheUserHasNotChanged() {
        this.iGetTheUser();
        String expectedEmailAddress = SharedObjects.usersEmailAddress;
        String actualEmailAddress = this.getSingleUserResponse().getData().getEmail();
        assertThat(actualEmailAddress).isEqualTo(expectedEmailAddress);
    }

    @When("I delete a user")
    public void iDeleteAUser() {
        int id = faker.number().numberBetween(100, 200);
        SharedObjects.response = Requests.deleteRequest(URLHelper.USERS_SERVICE + "/" + id, true);
        SharedObjects.usersId = id;
    }

    @Then("the total number of users has decreased by 1")
    public void theTotalNumberOfUsersHasDecreasedBy() {
        int expectedNumberOfUsers = SharedObjects.numberOfUsers;
        this.iGetAllUsers();
        int actualNumberOfUsers = this.getAllUsersResponse().getMeta().getPagination().getTotal();
        assertThat(actualNumberOfUsers).isEqualTo(expectedNumberOfUsers - 1);
    }

    @Then("I have the id of the new user")
    public void iHaveTheIdOfTheNewUser() {
        SharedObjects.usersId = this.getSingleUserResponse().getData().getId();
    }

    @When("I create a new user without authorization")
    public void iCreateANewUserWithoutAuthorization() {
        String body =
                new Gson()
                        .toJson(
                                UserRequest.newInstance(
                                        faker.name().fullName(),
                                        "Male",
                                        faker.internet().emailAddress(),
                                        "Active"));
        SharedObjects.response = Requests.postRequest(URLHelper.USERS_SERVICE, body, false);
    }

    private UserResponse getSingleUserResponse() {
        return new Gson().fromJson(SharedObjects.response.getBody().asString(), UserResponse.class);
    }

    private UsersResponse getAllUsersResponse() {
        return new Gson()
                .fromJson(SharedObjects.response.getBody().asString(), UsersResponse.class);
    }

    @Given("I have the e-mail address of the user")
    public void iHaveTheEMailAddressOfTheUser() {
        SharedObjects.usersEmailAddress = this.getSingleUserResponse().getData().getEmail();
    }
}
