Feature: Account Creation and Sign In

  Scenario: Create an account and sign in with valid credentials
    Given launch the Browser and Open url
    When Click on Create an Account button
    And Enter first name "Testuser124567", last name "New", email "testuserneww124567@gmail.com", and password "Testuser@12345"
    And Click on Log out
    Then User log out successfully
    When Click on Sign In button
    And Enter email "testuserneww124567@gmail.com" and password "Testuser@12345"
    Then User signed in successfully

  Scenario: Create an account with existing mail
  Given launch the Browser and Open url
  When Click on Create an Account button
  And Enter first name "Testuser12456", last name "New", email "new@gmail.com", and password "Testuser@12345"
  Then Enter invalid email showerror
  
  Scenario: Login with existing email id
  Given launch the Browser and Open url
  When Click on Sign In button
  And Enter email "new@gmail.com" and password "Testuser@12345"
  Then Enter invalid email login error
  