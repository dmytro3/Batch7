@regression @smoke @ui @etsy
Feature: Validating Etsy application search and filter functionalities

  Background: Repeated first steps in each scenario
    Given user navigates to "EtsyApp" application
    When user searches for "sofa"

  @ESF-44
  Scenario: Validating search results
    Then user validates search result items name contains keyword "sofa"


  @ESF-45
  Scenario: Validating price filter functionality
    And user applies price filter 1500
    Then user validates that item prices are over 5000














