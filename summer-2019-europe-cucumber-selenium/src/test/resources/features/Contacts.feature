Feature: Contacts Page

  @smoke
  Scenario: Default page number
    Given the user is on the login page
    And the user enter the sales manager information
    When the user navigates "Customers" "Contacts"
    Then default page number should be 1

  @smoke
  Scenario: verify Calendar events
    Given the user is on the login page
    And the user enter the sales manager information
    When the user navigates "Fleet" "Vehicles"


  Scenario: Menu options
    Given the user logged in as a "driver"
    Then the user should see following menu options
      | Fleet | Customers | Activities | System |


  Scenario: login as a given user
    Given the user is on the login page
    When the use logs in using following credentials
      | username  | user1       |
      | password  | UserUser123 |
      | firstname | John        |
      | lastname  | Doe         |
    Then the user should be able to login

  Scenario: login as a sales manager user
    Given  the user is on the login page
    When the use logs in using following credentials
      | username  | salesmanager101 |
      | password  | UserUser123     |
      | firstname | Peyton          |
      | lastname  | Harber          |
    Then the user should be able to login

  Scenario: login as a sales manager user
    Given  the user is on the login page
    When the use logs in using following credentials
      | username  | storemanager85 |
      | password  | UserUser123    |
      | firstname | Peyton         |
      | lastname  | Harber         |
    Then the user should be able to login

##########################
  Scenario Outline: login as a given user DDF
    Given the user is on the login page
    When the use logs in using following credentials
      | username  | <username>  |
      | password  | UserUser123 |
      | firstname | <fname>     |
      | lastname  | <lastname>  |
    Then the user should be able to login

    Examples:
      | username        | fname              | lastname |
      | user1           | John               | Doe      |
      | salesmanager101 | Peyton             | Harber   |
      | storemanager85  | Marcella bnmbnmbmn | Huels    |

  @db
  Scenario: Contacts test with email
    Given the user logged in as a "store manager"
    And the user navigates "Customers" "Contacts"
    When the user clicks on "mbrackstone9@example.com" from contacts
    Then the information should be the same as database

  @db
  Scenario: Contacts test with email
    Given the user logged in as a "store manager"
    And the user navigates "Customers" "Contacts"
    When the user clicks on "mbrackstone9@example.com" from contacts
    Then the information for "mbrackstone9@example.com" should be the same as database

  @wip @db
  Scenario Outline: Contacts test with email
    Given the user logged in as a "store manager"
    And the user navigates "Customers" "Contacts"
    When the user clicks on "<email>" from contacts
    Then the information for "<email>" should be the same as database
    Examples:
      | email                    |
      | mbrackstone9@example.com |
      | odugmore5@sakura.ne.jp   |
      | safwansaba@hotmail.com   |
      | poohchi@bark.edu         |
