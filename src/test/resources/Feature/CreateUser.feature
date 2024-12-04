Feature: Testing the create user functionality

  Scenario: Create a user using valid input data
    When send valid request using endpoint "/api/users"
    Then verify the status code
    And Verify create user response
