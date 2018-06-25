package no.adonis.Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import no.adonis.DataTypes.Activity.Activity;
import no.adonis.DataTypes.Role.Role;
import no.adonis.DataTypes.TimesheetPeriod.TimesheetPeriod;
import no.adonis.DataTypes.Timezones.Timezone;
import no.adonis.DataTypes.UserGroup.UserGroup;
import no.adonis.DataTypes.Users.Employee;
import no.adonis.Utils.SQLUtils;
import no.adonis.DataTypes.Worktypes.Worktype;
import no.adonis.DataTypes.Worktypes.WorktypesFactory;

public class UtilsSteps extends CommonStep{

    @Given("^\"([^\"]*)\" is created$")
    public void isCreated(String name) {
        //Need to think how to remove redundant employees
//        employees.put(name, EmployeeFactory.getEmployee(name))

        Employee employee = employees.get(name);

        log.info(String.format("Inserting into database employee with parameters:\n" +
                        "pin: %d\n" +
                        "first name: %s\n" +
                        "last name: %s\n" +
                        "birth date: %s\n" +
                        "employee start date: %s\n" +
                        "employee end date: %s\n" +
                        "email: %s",
                employee.getPin(), employee.getFirstName(), employee.getLastName(),
                employee.getBirthDate().toDateTimeISO().toString(), employee.getEmployeeStartDate().toDateTimeISO().toString(),
                employee.getEmployeeEndDate().toDateTimeISO().toString(), employee.getEmail()));

        SQLUtils.createEmployee(employee);

        log.info("The employee was inserted\n");
    }

    @And("^\"([^\"]*)\" has current \"([^\"]*)\" activity on \"([^\"]*)\" vessel started (\\d+) days ago on \"([^\"]*)\" position$")
    public void hasCurrentActivityOnVesselStartedDaysAgoOnPosition(String employee, String activityCode, String vessel, int dateFromOffset, String position) {
        SQLUtils.createActivity(
                new Activity(
                        employees.get(employee),
                        positions.get(position),
                        activityCodes.get(activityCode),
                        dateFromOffset,
                        vessels.get(vessel),
                        false));
    }

    @And("^\"([^\"]*)\" is on \"([^\"]*)\" timezone from \"([^\"]*)\"$")
    public void isOnTimezoneFrom(String vessel, String timezone, String dateFrom) {

        timezones.put(timezone, new Timezone(vessels.get(vessel), timezone, dateFrom));

        log.info(String.format("Inserting into database timezone with parameters:\n" +
                        "date from: %s\n" +
                        "timezone: %s\n"+
                        "on the %s vessel",
                dateFrom, timezone, vessel));

        SQLUtils.createTimezone(timezones.get(timezone));

        log.info("The timezone was inserted\n");
    }

    @And("^period started (\\d+) days backward (\\d+) days forward is created on \"([^\"]*)\" vessel$")
    public void periodStartedDaysBackwardDaysForwardIsCreatedOnVessel(int dateFromOffset, int dateToOffset, String vessel) {
        log.info(String.format("Inserting into database timesheet period with parameters:\n" +
                        "date from offset: -%d days\n" +
                        "end date offset: +%d days\n" +
                        "on the %s vessel\n",
                dateFromOffset, dateToOffset, vessel));
        SQLUtils.createTimesheetPeriod(
                new TimesheetPeriod(
                        dateFromOffset,
                        dateToOffset,
                        vessels.get(vessel))
        );
        log.info("The period was inserted\n");
    }

    @And("^worktype \"([^\"]*)\" is exist on the \"([^\"]*)\" vessel with \"([^\"]*)\" options$")
    public void worktypeIsExistOnTheVesselWithOptions(String worktype, String vessel, String options) {

        Worktype wt = WorktypesFactory.composeWorktype(worktype, vessels.get(vessel), options);

        worktypes.put(worktype, wt);

        log.info(String.format("Inserting into database worktype with parameters:\n" +
                        "code: %s\n" +
                        "name: %s\n" +
                        "on the %s vessel\n" +
                        "with options: %s",
                wt.getCode(), wt.getName(), wt.getVessel().getName(), options));

        SQLUtils.createWorktype(worktypes.get(worktype));

        log.info("The worktype was inserted\n");
    }

    @And("^\"([^\"]*)\" role with access to \"([^\"]*)\" modules is created$")
    public void roleWithAccessToModulesIsCreated(String roleName, String modules) {
        log.info(String.format("Inserting into database role with parameters\n" +
                        "role name: %s\n" +
                        "with access to modules: %s",
                roleName, modules));

        Role role = new Role(roleName);
        roles.put(roleName, role);
        SQLUtils.createRole(role);

        SQLUtils.addAccessToModules(role, modules);

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

        log.info(String.format("%s position is linking to %s user group\n",
                position, userGroup));

        SQLUtils.linkPositionToUserGroup(userGroups.get(userGroup), positions.get(position));

        log.info("Position is linked");
    }

    @And("^\"([^\"]*)\" user group is created$")
    public void userGroupIsCreated(String userGroup) {
        UserGroup ug = new UserGroup(userGroup);
        userGroups.put(userGroup, ug);

        log.info(String.format("Inserting %s user group into database\n", userGroup));

        SQLUtils.createUserGroup(ug);

        log.info("User group is created");
    }
}
