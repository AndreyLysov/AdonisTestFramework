package no.adonis.Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import no.adonis.DataTypes.Activity.Activity;
import no.adonis.DataTypes.Role.Role;
import no.adonis.DataTypes.TimesheetPeriod.TimesheetPeriod;
import no.adonis.DataTypes.Timezones.Timezone;
import no.adonis.DataTypes.UserGroup.UserGroup;
import no.adonis.DataTypes.UserSettings.UserSettings;
import no.adonis.DataTypes.Users.Employee;
import no.adonis.DataTypes.Worktypes.Worktype;
import no.adonis.DataTypes.Worktypes.WorktypesFactory;
import no.adonis.Utils.SQLUtils;

public class UtilsSteps extends CommonStep {

    @Given("^\"([^\"]*)\" is created$")
    public void isCreated(String name) {

        Employee employee = employees.get(name);

        log.info("Inserting into database: " + employee.toString());

        SQLUtils.createEmployee(employee);

        log.info("The employee was inserted\n");
    }

    @And("^\"([^\"]*)\" has current \"([^\"]*)\" activity on \"([^\"]*)\" vessel started (\\d+) days ago on \"([^\"]*)\" position$")
    public void hasCurrentActivityOnVesselStartedDaysAgoOnPosition(String employee, String activityCode, String vessel,
                                                                   int dateFromOffset, String position) {

        Activity activity = new Activity(
                employees.get(employee),
                positions.get(position),
                activityCodes.get(activityCode),
                dateFromOffset,
                vessels.get(vessel),
                false);

        log.info("Inserting " + activity.toString());

        SQLUtils.createActivity(activity);

        log.info("The activity was inserted\n");
    }

    @And("^\"([^\"]*)\" is on \"([^\"]*)\" timezone from \"([^\"]*)\"$")
    public void isOnTimezoneFrom(String vessel, String timezone, String dateFrom) {

        timezones.put(timezone, new Timezone(vessels.get(vessel), timezone, dateFrom));

        log.info("Inserting into database: " + timezones.get(timezone));

        SQLUtils.createTimezone(timezones.get(timezone));

        log.info("The timezone was inserted\n");
    }

    @And("^period started (\\d+) days backward (\\d+) days forward is created on \"([^\"]*)\" vessel$")
    public void periodStartedDaysBackwardDaysForwardIsCreatedOnVessel(int dateFromOffset, int dateToOffset, String vessel) {

        TimesheetPeriod tsPeriod = new TimesheetPeriod(
                dateFromOffset,
                dateToOffset,
                vessels.get(vessel));

        log.info("Inserting into database: " + tsPeriod);

        SQLUtils.createTimesheetPeriod(
                tsPeriod
        );

        log.info("The period was inserted\n");
    }

    @And("^worktype \"([^\"]*)\" is exist on the \"([^\"]*)\" vessel with \"([^\"]*)\" options$")
    public void worktypeIsExistOnTheVesselWithOptions(String worktype, String vessel, String options) {

        Worktype wt = WorktypesFactory.composeWorktype(worktype, vessels.get(vessel), options);

        worktypes.put(worktype, wt);

        log.info("Inserting into database: " + worktypes.get(worktype)) ;

        SQLUtils.createWorktype(worktypes.get(worktype));

        log.info("The worktype was inserted\n");
    }

    @And("^\"([^\"]*)\" role with access to \"([^\"]*)\" modules is created$")
    public void roleWithAccessToModulesIsCreated(String roleName, String modules) {


        roles.put(roleName, new Role(roleName));

        log.info("Inseting into database: " + roles.get(roleName));

        SQLUtils.createRole(roles.get(roleName));

        log.info("Linking " + modules + "to the " + roleName);

        SQLUtils.addAccessToModules(roles.get(roleName), modules);

        log.info("The role was inserted\n");
    }

    @And("^\"([^\"]*)\" user group linked to \"([^\"]*)\" role$")
    public void userGroupLinkedToRole(String userGroup, String role) {

        log.info(String.format("%s user group is linking to %s role", userGroup, role));

        SQLUtils.linkUserGroupToRole(userGroups.get(userGroup), roles.get(role));

        log.info("User group is linked");
    }

    @And("^\"([^\"]*)\" position is linked to \"([^\"]*)\" user group$")
    public void positionIsLinkedToUserGroup(String position, String userGroup) {

        log.info(positions.get(position).toString() + " position is linking to "
                        + userGroups.get(userGroup) + " user group\n");

        SQLUtils.linkPositionToUserGroup(userGroups.get(userGroup), positions.get(position));

        log.info("Position is linked");
    }

    @And("^\"([^\"]*)\" user group is created$")
    public void userGroupIsCreated(String userGroup) {
        UserGroup ug = new UserGroup(userGroup);
        userGroups.put(userGroup, ug);

        log.info("Inserting into database: " + userGroups.get(userGroup).toString());

        SQLUtils.createUserGroup(ug);

        log.info("User group was created");
    }

    @And("^\"([^\"]*)\" has user settings: workdays: (\\d+); start work hour: (\\d+); end work hour: (\\d+); display work time only: \"([^\"]*)\"; display timeslots: \"([^\"]*)\"$")
    public void hasUserSettingsWorkdaysStartWorkHourEndWorkHourDisplayWorkTimeOnlyDisplayTimeslots(String employee,
                                                                                                   int workDays,
                                                                                                   int startWorkHour,
                                                                                                   int endWorkHour,
                                                                                                   String displayWorkTime,
                                                                                                   String displayTimeslots) {
        UserSettings userSettings = new UserSettings(
                employees.get(employee),
                workDays == 5,
                startWorkHour,
                endWorkHour,
                displayWorkTime.equals("yes"),
                displayTimeslots.equals("yes")
        );

        log.info("Inserting user settings into database:\n" +
                userSettings.toString());

        SQLUtils.setUserSettings(userSettings);

        log.info("User settings were inserted");
    }
}
