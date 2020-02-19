Feature: Login with parameters

  Scenario: Login as a driver
    Given the user is on the login page
    When user logs in using "User1" and "UserUser123"
    Then the user should be able to login
    And the title should contains "Dashboard"

    #create the scenario for storemanager and sales manager
  Scenario: Login as a sales manager
    Given  the user is on the login page
    When user logs in using "salesmanager123" and "UserUser123"
    Then the user should be able to login

  Scenario: Login as a store manager
    Given  the user is on the login page
    When user logs in using "storemanager85" and "UserUser123"
    Then the user should be able to login