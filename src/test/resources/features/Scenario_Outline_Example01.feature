@datatable01 @third
Feature: scenario outline example
  Scenario: testing the data tables web page
    Given User is on the datatables homepage
    When User clicks on new button
    And User enters first name "Ceyda"
    And User enters last name "Nur"
    And User enters position "Child"
    And User enters office "TORONTO"
    And User enters extension "111"
    And User enters start date "2020-08-08"
    And User enters salary "777777"
    And User clicks Create button
    And User enters first name  "Ceyda" to the searchbox
    Then verify that user see the first name "Ceyda" in the searchbox