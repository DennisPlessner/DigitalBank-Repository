@Suite
Feature: Creating a new checking account

  Scenario: Login
    Given The user on Digital Bank login page

    When the user is logged in as "denis@gmail.com" "Denis@1985"

    Then the user should see "Dashboard"




