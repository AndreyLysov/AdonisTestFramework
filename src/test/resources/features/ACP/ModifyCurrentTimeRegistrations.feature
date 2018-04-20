Feature: As a Crew Member I want to register and adjust my work time so I can I can account to a manager.

  Background: My Timesheets current page is opened

  Scenario: Add new current time registration
    When crew member add time registration
    Then current time registration is displayed

  Scenario: Edit current time registration via context menu
    And current time registration is displayed
    When crew member select current time registration
    And edit time registration using context menu
    Then time registration is edited

  Scenario: Edit current time registration via time in (drag & drop)
    And current time registration is displayed
    When crew member select current time registration
    And expands time in
    Then current time registration time in is changed

  Scenario: Truncate current time registration by timeout (Right)
    And current time registration is displayed
    When crew member add time registration to truncate existing one by timeout
    Then existing time registration timeout is changed
    And new time registration is displayed

  Scenario: Truncate current time registration by timein (Left)
    And current time registration is displayed
    When crew member add time registration to truncate existing one by timein
    Then existing time registration timein is changed
    And new time registration is displayed

  Scenario: Split time registration
    And current time registration is displayed
    When crew member add time registration to split existing current
    Then current time registration is splitted
    And new time registrations are displayed

  Scenario: Delete current time registration
    And current time registration is displayed
    When select current time registration
    And delete current time registration
    Then current time registration is edited
