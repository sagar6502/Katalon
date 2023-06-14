Feature: Login Feature

  Scenario Outline: Test login with valid credentials
    Given User navigates to login page
    When User enters <username> and <password>
    And Click on Login Button
    Then User is navigated to homepage

    Examples: 
      | username | password |
      | Admin			| hUKwJTbofgPU9eVlw/CnDQ== |