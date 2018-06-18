Feature: As a Crew Member I want to register and adjust my work time so I can I can account to a manager.

  Background:
    Given My Timesheets current page is opened

  Scenario: Add new time registration
    When crew member add time registration
    Then time registration is displayed

  Scenario: Edit time registration via context menu
    And time registration is displayed
    When crew member select time registration
    And edit time registration using context menu
    Then time registration is edited

  Scenario: Edit time registration via time in (drag & drop)
    And time registration is displayed
    When crew member select time registration
    And expands time in
    Then time registration time in is changed

  Scenario: Edit time registration via time out (drag & drop)
    And time registration is displayed
    When crew member select time registration
    And expands timeout
    Then time registration time out is changed

  Scenario: Truncate by timeout (Right)
    And time registration is displayed
    When crew member add time registration to truncate existing one by timeout
    Then existing time registration timeout is changed
    And new time registration is displayed

  Scenario: Truncate by timein (Left)
    And time registration is displayed
    When crew member add time registration to truncate existing one by timein
    Then existing time registration timein is changed
    And new time registration is displayed

  Scenario: Override time registration
    And time registrations are exist
    When crew member overrides existing time registrations
    And add new time registration
    Then time registrations are overridden
    And new time registration is displayed

  Scenario: Split time registration
    And time registration is displayed
    When crew member add time registration to split existing
    Then time registration is splitted
    And new time registrations are displayed

  Scenario: Move time registration
    And time registration is displayed
    When crew member select time registration
    And move time registration
    Then time registration is moved

  Scenario: Delete time registration
    And time registration is displayed
    When select time registration
    And delete time registration
    Then time registration is edited

  Scenario: Recurrence time registration
    When crew member add time registration
    And select recurrence options for 4 days
    Then time registrations are created for selected period
