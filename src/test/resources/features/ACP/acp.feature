Feature: As a Crew Member I want to register and adjust my work time so I can I can account to a manager.

  Background:
    Given  "ACP" is opened
    And "My Timesheet" page is opened

  Scenario: Add time registration
    When create "time registration"


    Given "<Employee>" is created
    And "<Employee>" has current "<Activity code>" activity on "<Vessel>" vessel started 20 days ago on "<Position>" position
    And "<Vessel>" is on "+0" timezone from "previous year"
    And period started 10 days backward 20 days forward is created
    And worktype "Work" is exist on the "<Vessel>" vessel with options
      |IsWork|
    And "<Position>" linked to "User Group" linked to "Roles" with access to all modules
    And "<Position>" is set as "subordinator" in COA settings
    And "ACP" is opened
    And "<Employee>" is logged in
    And "My Timesheet" page is opened

  Scenario: Add time registration
    When create "time registration"
    Then "time registration" is displayed

  Examples:
  |Vessel|Position|Employee|Activity code|
  |Black Pearl|Seaman|Bart Simpson|Onboard|
