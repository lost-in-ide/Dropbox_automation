@login_ui @smoke
Feature: UI login

  Background:
    Given I open "Dropbox" website
    And I click on "Sign In" link

  @login_ui_1 @smoke
  Scenario: Login with valid credentials
    And I login to "existing" account
    Then I verify login successful

  @login_ui_2 @smoke
  Scenario: Login with invalid password
    And I Login with invalid password
    Then I verify "invalid password" error message is displayed

  @login_ui_3 @smoke
  Scenario: Login with email field left blanc
    And I login with "email" left blanc
    Then I verify "blanc" error message is displayed

  @login_ui_4 @smoke
  Scenario: Login with password field left blanc
    And I login with "password" left blanc
    Then I verify "blanc" error message is displayed

  @login_ui_5 @smoke
  Scenario: Sign in with Google
    And I click on "sign in with Google" link
    Then I verify login successful

