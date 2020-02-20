Feature: Login feature

  Scenario: Login
    Given the user clicks on get started
    When the user logs in with etsy credentials
    Then the user verifies that etsy logo is displayed
