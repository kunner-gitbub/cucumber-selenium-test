Feature: User Login

  Scenario: Successful Login with Valid Credentials
    Given I open the login page
    When I enter valid credentials
    Then I should be logged in successfully
