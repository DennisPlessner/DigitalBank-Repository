@Suite
@Registration
Feature: Digital Bank Registration Page

  Background:
    Given the user is on the sign up page

  Scenario: Positive case. As a user I want to successfully create a Digital Bank account

    When the user creates account with following fields with mocked email and ssn
      | title | firstName | lastName | gender | dateOfBirth | ssn    | email  | password | confirmPassword | address       | locality | region | postalCode | country | homePhone     | mobilePhone   | workPhone     | termsCheckMark |
      | Mr.   | Jim       | Halpert  | M      | 01/01/1990  | random | random | Jim1990! | Jim1990!        | 234 W Ohio St | Scranton | PA     | 18509      | USA     | (645)747-4576 | (736)746-9124 | (943)645-9283 | true           |
    Then the user should see the success message "Success Registration Successful. Please Login."

@NegativeRegistrationCases
  Scenario Outline: Negative case. As a admin I want to make sure that users cannot register without all valid data

    When the user creates account with following fields with mocked email and ssn

      | title   | firstName   | lastName   | gender   | dateOfBirth   | ssn   | email   | password   | confirmPassword   | address   | locality   | region   | postalCode   | country   | homePhone   | mobilePhone   | workPhone   | termsCheckMark   |
      | <title> | <firstName> | <lastName> | <gender> | <dateOfBirth> | <ssn> | <email> | <password> | <confirmPassword> | <address> | <locality> | <region> | <postalCode> | <country> | <homePhone> | <mobilePhone> | <workPhone> | <termsCheckMark> |
    Then the user should see the "<fieldWithError>" required field error message "<errorMessage>"

    Examples:

      | title | firstName | lastName | gender | dateOfBirth | ssn | email | password | confirmPassword | address | locality | region | postalCode | country | homePhone | mobilePhone | workPhone | termsCheckMark | fieldWithError | errorMessage                       |
      |       |           |          |        |             |     |       |          |                 |         |          |        |            |         |           |             |           |                | title          | Please select an item in the list. |
      |  Mr.  |           |          |        |             |     |       |          |                 |         |          |        |            |         |           |             |           |                | firstName      | Please fill out this field. |
