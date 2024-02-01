Feature: feature to test Costco Homepage
  @tag1
  Scenario Outline: Validate all menu titles
    Given browser is open
    And User is on costco homepage
    When user clicks on "<title>" menu
    Then user is brought to the  "<value>" page


    Examples: 
      | title            					| value                                         |
      | Home_Ancillary_0 					| https://www.costco.com/grocery-household.html |	
      | Home_Ancillary_3					| https://www.costcobusinessdelivery.com/				|
      |	Home_Ancillary_4					| https://www.costco.com/optical.html						|
