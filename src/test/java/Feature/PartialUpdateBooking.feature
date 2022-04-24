Feature: Updates a current booking with a partial payload

  Scenario: Updates a current booking with a partial payload
    Given I create new token with username admin and password password123
    When I update a current booking with a partial payload with firstname James and lastname Brown