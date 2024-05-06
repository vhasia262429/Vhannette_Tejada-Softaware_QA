Feature: Signed in User, Logged in User, Remove Item from the cart, and Successful purchase

  @PurchaseSuccessfully
  Scenario: Validate user is able to sign in using valid credentials and log in successfully
    Given user navigates to demo blaze home page
    When user enters valid username and password
    Then user is signed in successfully
    When user enters the sign in credentials
    Then user is logged in successfully to the demo blaze web application
    And user validates that the categories and available items is displayed
    When user add items to the cart
    And user clicks the cart link
    Then user validates that the cart contains two items
    When user remove one item in the cart
    Then user validates that a confirmation pop up is displayed and the total price is updated
    When user clicks the place order button
    And user enters the required fields and optional fields
    And user clicks purchase button
    Then user validates that a pop up is displayed for a successful purchase
