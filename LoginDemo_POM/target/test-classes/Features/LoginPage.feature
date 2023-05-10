Feature: Test login functionality
  Scenario Outline: Check login is successful with valid credentials
    Given browser is opening
    And user is on the login page
    When user enter <username> and <password>
    And user clicks on login
    Then user is navigate

    Examples:
    |username|password|
    |Raghav  |12345   |
    |Ele     |12345   |
