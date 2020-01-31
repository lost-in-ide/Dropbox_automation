@file_ui @sanity
Feature: UI file manipulations from Homepage

  Background:
    Given I open "Dropbox" website
    When I click on "Sign In" link
    And I login to "existing" account
    Then I verify login successful

  @file_ui_1 @sanity
  Scenario: I upload file from Homepage
    Given I upload "Test.pdf"
    Then I verify "Test.pdf" uploaded

  @file_ui_2 @sanity
  Scenario: I upload folder from Homepage
    Given I upload "new folder"
    Then I verify "new folder" uploaded

  @file_ui_3 @sanity
  Scenario: I create file from Homepage
    Given I create "new file"
    Then I verify "new file" created

  @file_ui_4 @sanity
  Scenario: I create shared folder from Homepage
    Given I create "new shared folder"
    Then I verify "new shared folder" created

  @file_ui_5 @sanity
  Scenario: I cancel file upload
    Given I upload "new file"
    When I cancel "new file" upload
    Then I verify "new file" not uploaded

  @file_ui_6 @sanity
  Scenario: I cancel folder upload
    Given I upload "new folder"
    When I cancel "new folder" upload
    Then I verify "new folder" not uploaded

