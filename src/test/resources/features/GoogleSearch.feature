Feature: feature to test google search page
  Scenario: validate google search page is working
    Given browser is open
    And user is on google search page
    When user enter a text in search box
    And user click submit
    Then user is navigating to search page
