Feature: Search box on Costco Homepage

  Scenario Outline: Validate search box on Costco Homepage
    Given browser opens
    When I enter "<words>"
    Then I am brought the "<value>" page
    
    Examples: 
    	|words									|	value														|
    	|Macbook								| MacBook Pro & Air								|
 
