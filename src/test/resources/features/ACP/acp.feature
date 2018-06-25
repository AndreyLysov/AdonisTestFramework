Feature: As a Crew Member I want to register and adjust my work time so I can I can account to a manager.

  Background:
    Given "Bart Simpson" is created
    And "Bart Simpson" has current "Onboard" activity on "Black Pearl" vessel started 20 days ago on "Seaman" position
    And period started 10 days backward 20 days forward is created on "Black Pearl" vessel
    And "Crew" role with access to "My time sheets;Time and attendance;Overview;Current;" modules is created
    And "Crew group" user group is created
    And "Seaman" position is linked to "Crew group" user group
    And "Crew group" user group linked to "Crew" role

  Scenario: Add time registration
    And "Black Pearl" is on "-1" timezone from "2018-01-01"
    And worktype "Work" is exist on the "Black Pearl" vessel with "isWork;isWorkAndRest" options
    And "ACP" is opened
    And "Bart Simpson" is logged in
    And "My Timesheet" page is opened
    When create time registration with timein 10 hours and time out 16 hours and "Work" work type for yesterday
    Then time registration with time in 10 hours, time out 16 hours, "Work" work type and "-1" timezone for yesterday is displayed


#    And  "Chain name" COA is created
#    And "<Position>" is set as approver in the "<Chain name>" COA
#    And "<Position>" is set as subordinator in the "<Chain name>" COA

    #
#  Scenario: Add time registration
#
#    Then "time registration" is displayed
#
