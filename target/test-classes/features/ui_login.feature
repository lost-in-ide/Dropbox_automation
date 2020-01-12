@login_ui @smoke
Feature: UI login

  Background:
    Given I open "Dropbox" website
    And I click on "SignIn" link

  @login_ui1 @smoke
  Scenario: Login with valid credentials
    And I login to "existing" account
    Then I verify login successful

  @login_ui2 @smoke
  Scenario: Login with invalid password
    And I Login with invalid password
    Then I verify "invalid password" error message is displayed

  @login_ui3 @smoke
  Scenario: Login with email field left blanc
    And I login with "email" left blanc
    Then I verify "blanc" error message is displayed

  @login_ui4 @smoke
  Scenario: Login with password field left blanc
    And I login with "password" left blanc
    Then I verify "blanc" error message is displayed

#  seems to happen only on the first try, so not applicable
  @login_ui5 @smoke
  Scenario: Login to non-existing account
    And I login to "non-existing" account
    Then I verify I am offered to "create" an account

