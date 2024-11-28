Feature: Login functionality

  Scenario Outline: User can login with valid credentials
    Given the user navigates to the login page
    When the user enters the username "<username>" and password "<password>"
    Then the user should be successfully logged in

    Examples:
      | username     | password   |
      | testuser1    | password1  |
      | testuser2    | password2  |
      | testuser3    | password3  |
