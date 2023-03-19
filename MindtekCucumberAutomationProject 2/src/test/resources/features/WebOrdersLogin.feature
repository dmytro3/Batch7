@regression @smoke @ui @webOrders
Feature: WebOrders application login feature

  #Before
  @SVB-15
  Scenario: Validating login feature with valid credentials
    Given user navigates to "WebOrders" application
    When user enters username "Teste" and password "test"
    And user clicks on the login button
    Then user validates application is logged in
  #After


     #Before
  Scenario: Validating login feature with invalid credentials
    Given user navigates to "WebOrders" application
    When user enters username "Invalid" and password "invalid"
    And user clicks on the login button
    Then user validates an error message "Invalid Login or Password."
#After









