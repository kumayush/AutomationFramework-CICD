
@tag
Feature: Purchase the order form the ecommerce website
  I want to use this template for my feature file


Background: 
Given I landed on the ecommerce page

  @tag2
Scenario Outline: positive test of submitting the order
Given Logged in with username<name> and password <password>
When I add the product <productName> to cart
And checkout <productName> and submit the order
Then "THANKYOU FOR THE ORDER." message is displayed on the confirmation page

Examples: 
      | name               |password |productName|
      |testing@testing1.com|Test@1234|ZARA COAT 3|
      
