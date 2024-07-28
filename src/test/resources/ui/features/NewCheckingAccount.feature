@Suite
Feature: Creating a new checking account

  Scenario Outline: Creating a new standard individual checking account
    Given The user is logged in as "denis@gmail.com", "Denis@1985"
    When the user creates a new checking account with the following data
      | checkingAccountType   | accountOwnership   | accountName   | initialDepositAmount   |
      | <checkingAccountType> | <accountOwnership> | <accountName> | <initialDepositAmount> |

    Then the user should see the green "Confirmation" message

    Examples:
      | checkingAccountType | accountOwnership | accountName                    | initialDepositAmount |
      | Standard Checking   | Individual       | Denis's checking account       | 100000.0             |
      | Interest Checking   | Joint            | Denis's interest joint account | 500000.0             |
      | Interest Checking   | Individual       | Denis's interest account       | 800000.0             |

