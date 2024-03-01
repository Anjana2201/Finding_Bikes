Feature: ZigWheels Google Sign In

  Scenario: Logging through Google
    Given The user is navigated to ZigWheels Home Page for Login Option
    And Login icon is present
    When The user clicks on Login button
    And The user clicks on Google button

  Scenario: Enter Invalid Email and Retrieve Error Message
    Given The user navigated to login window
    And Text field to be present
    When The user enters "abc@abc" as emailID
    Then Retrieve the Error Message