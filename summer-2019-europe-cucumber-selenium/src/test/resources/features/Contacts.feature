Feature: Contacts Page


  Scenario: Default page number
    Given the user is on the login page
    And the user enters the sales manager credentials
    When the user navigates to the "Customers" "Contacts" page
    Then the user verifies that the default page number is 1

  Scenario: Menu options
    Given the user logged in as a "driver"
    Then the user should see the following menu options
      | Fleet | Customers | Activities | System |

  @wip
  Scenario: Login as a given user
    Given the user is on the login page
    When the user logs  in using the following credentials
      | username  | user1       |
      | password  | UserUser123 |
      | firstname | John        |
      | lastname  | Doe         |
    Then the user should be able to login


