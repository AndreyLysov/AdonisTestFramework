Feature: As a Crew Member I want to register and adjust my work time so I can I can account to a manager.

  Background:
#    Given  "ACP" is opened
#    And "My Timesheet" page is opened

  Scenario Outline: Add time registration
    Given "<Employee>" is created
    And "<Employee>" has current "<Activity code>" activity on "<Vessel>" vessel started 20 days ago on "<Position>" position
    And "<Vessel>" is on "-1" timezone from "2018-01-01"
    And period started 10 days backward 20 days forward is created on "<Vessel>" vessel
    And worktype "Work" is exist on the "<Vessel>" vessel with "<Options>" options
    And "<Role>" role with access to "<Modules>" modules is created
    Examples:
      | Vessel      | Position | Employee     | Activity code | Options              | Role | Modules                          |
      | Black Pearl | Seaman   | Bart Simpson | Onboard       | isWork;isWorkAndRest | Crew | My Time Sheets;Time And Attendance |




#    And "<Position>" linked to "User Group" linked to "Roles" with access to all module
#    And  "Chain name" COA is created
#    And "<Position>" is set as approver in the "<Chain name>" COA
#    And "<Position>" is set as subordinator in the "<Chain name>" COA


#    And "ACP" is opened

#    And "<Employee>" is logged in
#    And "My Timesheet" page is opened
#
#  Scenario: Add time registration
#    When create "time registration"
#    Then "time registration" is displayed
#