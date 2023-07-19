Feature: Find the specified item

  @wip
  Scenario Outline: Find the "<Product Identifier>" item
    Given the user is on the etsy homepage
    When the user searches for "apple watch band"
    And the user chooses deliver to "United States"
    And the user clicks on the "<Product Identifier>" item
    Then the seller title should be "<Seller Title>"
    Examples:
      | Product Identifier | Seller Title    |
      | Brown Stitching    | TexansWatchbands |
      | Personalized       | TexansWatchbands |