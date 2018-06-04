Feature: test

  Scenario: testtesttesttesttest
    Given ACP is opened
    And login as crewmember
    And open time and attendance page
    And open my timesheet page
    And open add edit time registration form
    And crew member add time registration
    Then start page is opened

  Scenario: Add time registration
    Given Current time sheet page is opened
    Then start page is opened

