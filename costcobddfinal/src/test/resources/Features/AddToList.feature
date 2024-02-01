Feature: feature to add to wishlist
Scenario: Validate add to wishlist link in the shopping cart is working
Given User is on Costco main page
When User performs a product search
And adds the item to the shopping cart 
And opens shopping cart 
And clicks add to List link
Then Sign In window appears 