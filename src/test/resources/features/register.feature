@screen
  Feature: Register

  Scenario: Register Successful
    Given I open url"https://dev2.farmec.ro/cont-nou.html"
    And I register with valid dates
    And I wait 2 seconds
    And I select gender from the drop-down
    And I wait 40 seconds

