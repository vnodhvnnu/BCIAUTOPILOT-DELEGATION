Feature: Login Page Feature

  @positive
  Scenario: Successful login with valid email and password
    Given The user is on login page
    When The user enters a valid email "kotak@gmail.com" and valid password "911313131313"
    And The user clicks on the login button
    Then The text "DashBoard" should be displayed on the dashboard indicating successful login

  @negative
  Scenario: Unsuccessful login with valid email and invalid password
    Given The user is on login page
    When The user enters a valid email "kotak@gmail.com" and invalid password "9834455"
    And The user clicks on the login button
    Then The text "DashBoard" should not be displayed indicating unsuccessful login

  @negative
  Scenario: Unsuccessful login with invalid email and valid password
    Given The user is on login page
    When The user enters an invalid email "invalid.email@gmail.com" and valid password "911313131313"
    And The user clicks on the login button
    Then The text "DashBoard" should not be displayed indicating unsuccessful login

  @negative
  Scenario: Unsuccessful login with empty email and password fields
    Given The user is on login page
    When The user leaves the email and password fields empty
    And The user clicks on the login button
    Then The text "DashBoard" should not be displayed indicating unsuccessful login

  @negative
  Scenario: Unsuccessful login with valid email and empty password
    Given The user is on login page
    When The user enters a valid email "kotak@gmail.com" and leaves the password field empty
    And The user clicks on the login button
    Then The text "DashBoard" should not be displayed indicating unsuccessful login

  @negative
  Scenario: Unsuccessful login with empty email and valid password
    Given The user is on login page
    When The user leaves the email field empty and enters a valid password "911313131313"
    And The user clicks on the login button
    Then The text "MIS" should not be displayed indicating unsuccessful login
