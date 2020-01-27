Feature: Account types

  @wip
  Scenario: Driver user
    Given the user logged in as a "driver"
    When the user navigates to the "Activities" "Calendar Events" page
    Then the title should contain "Calendar Events - Activities"

  @wip
  Scenario: Sales manager user
    Given the user logged in as a "salesmanager"
    When the user navigates to the "Customers" "Accounts" page
    Then the title should contain "Accounts - Customers"
  @wip
  Scenario: Store manager
    Given the user logged in as a "storemanager"
    When the user navigates to the "Marketing" "Campaigns" page
    Then the title should contain "Campaigns - Marketing"

  Scenario Outline: Login with different users <usertypes>
    Given the user logged in as a "<usertypes>"
    When the user navigates to the "<tab>" "<module>" page
    Then the title should contain "<title>"
    Examples:
      | usertypes    | tab        | module          | title                        |
      | driver       | Activities | Calendar Events | Calendar Events - Activities |
      | salesmanager | Customers  | Accounts        | Accounts - Customers         |
      | storemanager | Marketing  | Campaigns       | Campaigns - Marketing        |

  Scenario Outline: Login with different users <usertypes>
    Given the user logged in as a "<usertypes>"
    When the user navigates to the "<tab>" "<module>" page
    Then the title should contain "<title>"

    Examples: drivers
      | usertypes    | tab        | module          | title                                                        |
      | driver       | Fleet      | Vehicles Model  | Vehicles Model - Entities - System - Car - Entities - System |
      | driver       | Customers  | Accounts        | Accounts - Customers                                         |
      | driver       | Customers  | Contacts        | Contacts - Customers                                         |
      | driver       | Activities | Calendar Events | Calendar Events - Activities                                 |
      | driver       | System     | Jobs            | Jobs - System                                                |
      | salesmanager | Fleet      | Vehicles        | Car - Entities - System - Car - Entities - System            |
      | salesmanager | Fleet      | Vehicles Model  | Vehicles Model - Entities - System - Car - Entities - System |
      | salesmanager | Customers  | Accounts        | Accounts - Customers                                         |
      | salesmanager | Customers  | Contacts        | Contacts - Customers                                         |
      | salesmanager | Activities | Calendar Events | Calendar Events - Activities                                 |
      | salesmanager | System     | Jobs            | Jobs - System                                                |
      | storemanager | Fleet      | Vehicles        | Car - Entities - System - Car - Entities - System            |
      | storemanager | Fleet      | Vehicles Model  | Vehicles Model - Entities - System - Car - Entities - System |
      | storemanager | Customers  | Accounts        | Accounts - Customers                                         |
      | storemanager | Customers  | Contacts        | Contacts - Customers                                         |
      | storemanager | Activities | Calendar Events | Calendar Events - Activities                                 |
      | storemanager | System     | Jobs            | Jobs - System                                                |
      | storemanager | System     | Menus           | Menus - System                                               |
