Feature: Articles

  Scenario: Get articles
    When I get articles from the articles service
    Then  the response code is 200
    And multiple articles are returned from the articles service
    And all articles have a unique id

  Scenario Outline: Get a single article
    When I get article "<id>" from the articles service
    Then the response code is 200
    And the article id matches the "<id>"
    And the article details are returned from the articles service
    Examples:
      | id            |
      | 1             |
      | 2             |
      | 3             |
      | 4656364867443 |
      | 5             |

  Scenario: Create a new article
    Given I get articles from the articles service
    And I have the total number of articles
    When I create a new article
    Then the response code for the alternative request is 404
    And the total number of articles has not changed

  Scenario: Delete an article
    Given I get articles from the articles service
    And I have the total number of articles
    When I delete article "5"
    Then the response code for the alternative request is 404
    And the total number of articles has not changed