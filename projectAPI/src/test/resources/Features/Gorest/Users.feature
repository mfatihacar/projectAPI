Feature: Users

  Scenario: Create a user
    Given I get all users
    And I have the total number of users
    When I create a new user
    Then the response code is 201
    And I have the id of the new user
    And the total number of users has increased by 1
    When I get the user
    Then the response code is 200

  Scenario: Attempt creating a new user with an existing e-mail addresses
    Given I get all users
    And I have the total number of users
    And I get a user
    And I have the e-mail address of the user
    When I create a new user using the same e-mail address
    Then the response code is 422
    And the total number of users has not changed

  Scenario: Update a user
    Given I get a user
    And I have the name of the user
    When I update the name of a user
    Then the response code is 200
    And the name of the user has been updated

  Scenario: Attempt updating a user with an existing e-mail addresses
    Given I get a user
    And I have the e-mail address of the user
    And I have the e-mail address of another user
    When I update the e-mail address of the first user with the same e-mail address
    Then the response code is 500
    And the e-mail address of the user has not changed

  Scenario: Delete a user
    Given I get all users
    And I have the total number of users
    When I delete a user
    Then the response code is 204
    And the total number of users has decreased by 1
    When I get the user
    And the response code is 404

  Scenario: Create a user without authorization
    Given I get all users
    And I have the total number of users
    When I create a new user without authorization
    Then the response code is 401
    And the total number of users has not changed