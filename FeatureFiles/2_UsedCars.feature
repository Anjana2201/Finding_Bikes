Feature: ZigWheels Get Used Cars

  Scenario: Navigate to Used Cars
    Given the user is navigated to ZigWheels Home Page again
    And Used Cars dropdown is present
    When the user hover cursor on Used Cars and navigate to Chennai
    Then the user should be redirected to Used Cars in Chennai page

  Scenario: Get a List of Popular Models
    Given the Popular Models list is present
    When the user scrolls for visibility of list
    Then Export the list of data to console and excel
