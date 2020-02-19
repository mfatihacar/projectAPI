@navigate
Feature: Navigation Menu

  Scenario: Fleet --> Vehicles
    Given the user is on the login page
    And the user enter the sales manager information
    When the user navigates to Fleet, Vehicles
    Then the url should be expected Fleet url

  Scenario: Sales managers - Marketing—> Campaigns navigation
    Given the user is on the login page
    And the user enter the sales manager information
    When  the user navigates Marketing Campaigns
    Then the url should be expected Campaigns url

  Scenario: Activities—> Calendar Events
    Given the user is on the login page
    And the user enter the sales manager information
    When the user navigates Activities - Calendar events
    Then the url should be expected Activities url

