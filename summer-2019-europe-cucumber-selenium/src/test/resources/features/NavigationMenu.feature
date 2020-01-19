@navigate
Feature: Users should be able to navigate through the menus
  Scenario: navigate to Fleet --> Vehicles
    Given the user enters the sales manager credentials
    When the user navigates to the Fleet-Vehicles page
    Then the user should see the expected Fleet URL

    @db
   Scenario: navigate to Marketing --> Campaigns
     Given the user enters the sales manager credentials
     When the user navigates to the Marketing-Campaigns page
     Then the user should see the expected Campaigns URL


   Scenario: navigate to Activities --> Calendar Events
     Given the user enters the sales manager credentials
     When the user navigates to the Activities-Calendar Events page
     Then the user should see the expected Calendar Events URL