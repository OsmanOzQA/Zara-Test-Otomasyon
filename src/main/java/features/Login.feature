Feature: Login Features

  Scenario: Successful login to Zara website
    Given user is on the Zara homepage
    When user clicks the login button
    And user enters valid username and password
    Then user should be redirected to the products page
