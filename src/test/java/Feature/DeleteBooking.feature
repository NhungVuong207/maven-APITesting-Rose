Feature: Take optional query strings to search and return a subset of booking ids
  
  Scenario: Delete Booking ID
    Given I create new token with username admin and password password123
    When I create a new booking
    Then I delete booking which I created