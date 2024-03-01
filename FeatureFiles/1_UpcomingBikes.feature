Feature: ZigWheels Get Upcoming Bikes

  Scenario: Navigate to Upcoming Bikes
    Given The user is navigated to ZigWheels Home Page
    And New Bikes dropdown is present
    When The user hover cursor on New Bikes and navigate to Upcoming Bikes
		Then The user should be redirected to Upcoming Bikes page
		 
	Scenario: Set Filter and View All Bikes
		Given The option to select manufacturer is present
		When The user selects "Honda" as the manufacturer and clicks View More Bikes option
		Then Export the data of diplayed bikes to console and excel