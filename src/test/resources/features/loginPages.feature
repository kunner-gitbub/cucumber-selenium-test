Feature: Test user login page

  @smoke
  Scenario Outline: Validate user login process
    Given The user is given user login page
    #When The user enters the username and password
    When the user enters username "<username>" and password "<password>"
    Then The user should go to next secure page
    And the user should see the password change alert

    Examples:
      | username | password             |
      | tomsmith | SuperSecretPassword! |
      | invalid  | wrongPassword123     |

