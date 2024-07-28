@Suite
@Deposit
Feature: Deposit on Checking account
  Scenario: Positive case. As a user I want to deposit checking account

    Given the user loges in as "denis@gmail.com" "Denis@1985"
    And the user opens a new checking account with the following data
      | checkingAccountType | accountOwnership | accountName              | initialDepositAmount |
      | Standard Checking   | Individual       | Denis's checking account | 1000.00             |

    When the user deposit newly created Standard Checking account with amount of "1000.00"

    Then User should see the "View Checking Accounts"
