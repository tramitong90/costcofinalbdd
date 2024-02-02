Feature: feature remove last item from cart
Scenario: Validate remove last item from cart is working
Given open browser 
And User is on costco main page
When User adds the product to the cart 
And  shopping cart is open
And clicks remove link
Then cart is empty