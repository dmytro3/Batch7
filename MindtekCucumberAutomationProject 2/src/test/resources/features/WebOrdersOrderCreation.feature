@regression @ui @RTB-77
Feature: Validating order creation functionalities

  @RTB-88 @Calculataion
  Scenario Outline: Validating order calculation functionality
    Given user navigates to "WebOrders" application
    When user enters username "Tester" and password "test"
    And user clicks on the login button
    And user clicks on the Order module
    And user selects "<product>" with <quantity> and clicks on calculate button
    Then user validates total is calculated properly for <quantity>

    Examples:
      | product     | quantity |
      | MyMoney     | 10       |
      | FamilyAlbum | 5        |
      | ScreenSaver | 25       |

  @RTB-11 @Calculataion
  Scenario Outline: Validating create order functionality
    Given user navigates to "WebOrders" application
    When user enters username "Tester" and password "test"
    And user clicks on the login button
    And user clicks on the Order module
    And user creates order with data
      | product  | <product>  |
      | quantity | <quantity> |
      | name     | <name>     |
      | street   | <street>   |
      | city     | <city>     |
      | state    | <state>    |
      | zip      | <zip>      |
      | cType    | <cType>    |
      | cc       | <cc>       |
      | exp      | <exp>      |
    Then user validates success message "New order has been successfully added."

    Examples:
      | product     | quantity | name        | street          | city    | state | zip   | cType    | cc               | exp   |
      | MyMoney     | 10       | Patel Harsh | 123 My Road Dr. | Chicago | IL    | 60611 | Visa     | 1234123412341234 | 07/27 |
      | FamilyAlbum | 5        | Doe John    | 123 My Road Dr. | Chicago | IL    | 60611 | Master   | 1234123412341234 | 04/24 |
      | ScreenSaver | 25       | Pitt Brad   | 123 My Road Dr. | Chicago | IL    | 60611 | American | 1234123412341234 | 01/22 |

@createOrder
  Scenario Outline: Validating create order functionality
    Given user navigates to "WebOrders" application
    When user enters username "Tester" and password "test"
    And user clicks on the login button
    And user clicks on the Order module
    And user creates order with data
      | product  | <product>  |
      | quantity | <quantity> |
      | name     | <name>     |
      | street   | <street>   |
      | city     | <city>     |
      | state    | <state>    |
      | zip      | <zip>      |
      | cType    | <cType>    |
      | cc       | <cc>       |
      | exp      | <exp>      |
    Then user validates success message "New order has been successfully added."

    Examples:
      | product     | quantity | name        | street          | city    | state | zip   | cType    | cc               | exp   |
      | MyMoney     | 10       | Patel Harsh | 123 My Road Dr. | Chicago | IL    | 60611 | Visa     | 1234123412341234 | 07/27 |
      | FamilyAlbum | 5        | Doe John    | 123 My Road Dr. | Chicago | IL    | 60611 | Master   | 1234123412341234 | 04/24 |
      | ScreenSaver | 25       | Pitt Brad   | 123 My Road Dr. | Chicago | IL    | 60611 | American | 1234123412341234 | 01/22 |
  @createOrder
  Scenario Outline: Validating create order functionality
    Given user navigates to "WebOrders" application
    When user enters username "Tester" and password "test"
    And user clicks on the login button
    And user clicks on the Order module
    And user creates order with data
      | product  | <product>  |
      | quantity | <quantity> |
      | name     | <name>     |
      | street   | <street>   |
      | city     | <city>     |
      | state    | <state>    |
      | zip      | <zip>      |
      | cType    | <cType>    |
      | cc       | <cc>       |
      | exp      | <exp>      |
    Then user validates success message "New order has been successfully added."

    Examples:
      | product     | quantity | name        | street          | city    | state | zip   | cType    | cc               | exp   |
      | MyMoney     | 10       | Patel Harsh | 123 My Road Dr. | Chicago | IL    | 60611 | Visa     | 1234123412341234 | 07/27 |
      | FamilyAlbum | 5        | Doe John    | 123 My Road Dr. | Chicago | IL    | 60611 | Master   | 1234123412341234 | 04/24 |
      | ScreenSaver | 25       | Pitt Brad   | 123 My Road Dr. | Chicago | IL    | 60611 | American | 1234123412341234 | 01/22 |





