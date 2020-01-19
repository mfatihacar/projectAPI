Feature: Login with parameters


  Scenario: Login as a driver
    Given the user is on the login page
    When the user logs in using "user11" and "UserUser123"
    Then the user should be able to login
    And the title should contain "Dashboard"

