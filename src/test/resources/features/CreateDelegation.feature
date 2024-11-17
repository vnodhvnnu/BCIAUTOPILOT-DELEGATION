Feature: Create Delegation Feature

  Background:
    Given The user is logged in with the following credentials:
      | username            | password       |
      | kotak@gmail.com     | 911313131313   |

  @positive
  Scenario: Successfully create a delegation
    Given The user is on the dashboard if the text contains "DashBoard"
    When The user clicks on the "Create Tasks" dropdown
    And The user clicks on "Create Delegation"
    And The user enters a title "Project Updatessss" in the title textbox
    And The user starts typing "Ar" in the assign textbox
    Then Suggestions should autocomplete based on the input
    When The user selects "Arya" from the suggestions
    And The user selects a completion date "18-11-2024"
    And The user clicks the "Save" button
    Then The user is successfully created a Delegation task if the text contains "Tasks:"

  @negative
  Scenario: Fail to create a delegation due to missing title
    Given The user is on the dashboard if the text contains "DashBoard"
    When The user clicks on the "Create Tasks" dropdown
    And The user clicks on "Create Delegation"
    And The user leaves the title textbox empty
    And The user starts typing "Ar" in the assign textbox
    Then Suggestions should autocomplete based on the input
    When The user selects "Arya" from the suggestions
    And The user selects a completion date "18-11-2024"
    And The user clicks the "Save" button
    Then The text "Tasks:" should not be displayed on the dashboard

  @negative
  Scenario: Fail to create a delegation due to missing assignee
    Given The user is on the dashboard if the text contains "DashBoard"
    When The user clicks on the "Create Tasks" dropdown
    And The user clicks on "Create Delegation"
    And The user enters a title "Project Updatessss" in the title textbox
    And The user leaves the assign textbox empty
    And The user selects a completion date "18-11-2024"
    And The user clicks the "Save" button
    Then The text "Tasks:" should not be displayed on the dashboard

  @positive
  Scenario: Successfully create a delegation with an incomplete title
    Given The user is on the dashboard if the text contains "DashBoard"
    When The user clicks on the "Create Tasks" dropdown
    And The user clicks on "Create Delegation"
    And The user enters a title "Update" in the title textbox
    And The user starts typing "Ar" in the assign textbox
    Then Suggestions should autocomplete based on the input
    When The user selects "Arya" from the suggestions
    And The user selects a completion date "18-11-2024"
    And The user clicks the "Save" button
    Then The user is successfully created a Delegation task if the text contains "Tasks:"

  @negative
  Scenario: Fail to create a delegation due to invalid completion date format
    Given The user is on the dashboard if the text contains "DashBoard"
    When The user clicks on the "Create Tasks" dropdown
    And The user clicks on "Create Delegation"
    And The user enters a title "Project Updatessss" in the title textbox
    And The user starts typing "Ar" in the assign textbox
    Then Suggestions should autocomplete based on the input
    When The user selects "Arya" from the suggestions
    And The user selects a completion date "2024-11-18"
    And The user clicks the "Save" button
    Then The text "Tasks:" should not be displayed on the dashboard

  @positive
  Scenario: Successfully create a delegation with a different assignee
    Given The user is on the dashboard if the text contains "DashBoard"
    When The user clicks on the "Create Tasks" dropdown
    And The user clicks on "Create Delegation"
    And The user enters a title "New Task" in the title textbox
    And The user starts typing "ke" in the assign textbox
    Then Suggestions should autocomplete based on the input
    When The user selects "keerthi" from the suggestions
    And The user selects a completion date "25-12-2024"
    And The user clicks the "Save" button
    Then The user is successfully created a Delegation task if the text contains "Tasks:"

  @negative
  Scenario: Fail to create a delegation due to invalid assignee selection
    Given The user is on the dashboard if the text contains "DashBoard"
    When The user clicks on the "Create Tasks" dropdown
    And The user clicks on "Create Delegation"
    And The user enters a title "Project Update" in the title textbox
    And The user starts typing "In" in the assign textbox
    Then Suggestions should autocomplete based on the input
    When The user selects "InvalidAssignee" from the suggestions
    And The user selects a completion date "18-11-2024"
    And The user clicks the "Save" button
    Then The text "Tasks:" should not be displayed on the dashboard

  @positive
  Scenario: Successfully create a delegation with a different completion date
    Given The user is on the dashboard if the text contains "DashBoard"
    When The user clicks on the "Create Tasks" dropdown
    And The user clicks on "Create Delegation"
    And The user enters a title "New Delegation" in the title textbox
    And The user starts typing "An" in the assign textbox
    Then Suggestions should autocomplete based on the input
    When The user selects "Anita" from the suggestions
    And The user selects a completion date "30-11-2024"
    And The user clicks the "Save" button
    Then The user is successfully created a Delegation task if the text contains "Tasks:"

  @negative
  Scenario: Fail to create a delegation due to empty completion date
    Given The user is on the dashboard if the text contains "DashBoard"
    When The user clicks on the "Create Tasks" dropdown
    And The user clicks on "Create Delegation"
    And The user enters a title "No Date Task" in the title textbox
    And The user starts typing "Ar" in the assign textbox
    Then Suggestions should autocomplete based on the input
    When The user selects "Arya" from the suggestions
    And The user leaves the completion date empty
    And The user clicks the "Save" button
    Then The text "Tasks:" should not be displayed on the dashboard

