Feature: Contacts Page

  @wip
  Scenario: Default page number
    Given the user is on the login page
    And the user enters the sales manager credentials
    When the user navigates to the "Customers" "Contacts" page
    Then the user verifies that the default page number is 1