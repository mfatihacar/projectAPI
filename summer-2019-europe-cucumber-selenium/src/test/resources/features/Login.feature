@login
Feature: Users should be able to login

  Background:
    Given the user is on the login page

  @driver @VYT-123 @smoke
  Scenario: Login as a driver

    When the user enters the driver credentials
    Then the user should be able to login

  @sales_manager @VYT-123 @smoke
  Scenario: Login as a sales manager

    When the user enters the sales manager credentials
    Then the user should be able to login

  @store_manager
  Scenario: Login as a store manager

    When the user enters store manager credentials
    Then the user should be able to login

