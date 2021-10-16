@SmokeTests
Feature: Add Products to Cart
	User selecting any 4 products to wish list
	And Adding one product to Cart which price is low
	
#Bckground: We can use if we have any common steps for all test scenarios...

@AddCart
Scenario: Add Products to Wishlist and then to Cart
	Given I add four products to my wish list
	When I view my wishlist table
	Then I find total four selected items in my Wishlist
	When I search for lowest price product
	And I am able to add the lowest price item to my cart
	Then I am able to verify the item in my cart