package no.adonis.Steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import no.adonis.Activity.Activity;
import no.adonis.TimesheetPeriod.TimesheetPeriod;
import no.adonis.Timezones.Timezone;
import no.adonis.Users.Employee;
import no.adonis.Users.EmployeeFactory;
import no.adonis.Utils.SQLUtils;
import no.adonis.Worktypes.WorktypesFactory;

public class BaseStep extends CommonStep {

    @Given("^\"([^\"]*)\" is opened$")
    public void isOpened(String portal) {
        if (portal.equals("AAP"))
            app.base.openAAP();
        else if (portal.equals("ACP"))
            app.base.openACP();
        else
            app.base.openAEP();
    }

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
        log.info(String.format("Inserting into database timezone with parameters:\n" +
                        "date from: %s\n" +
                        "timezone: %s\n"+
                        "on the %s vessel",
                dateFrom, timezone, vessel));

        SQLUtils.createTimezone(
                new Timezone(
                        vessels.get(vessel),
                        timezone,
                        dateFrom
                ));

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
        log.info("The period was inserted");
    }

    @And("^worktype \"([^\"]*)\" is exist on the \"([^\"]*)\" vessel with options \"([^\"]*)\"$")
    public void worktypeIsExistOnTheVesselWithOptions(String worktype, String vessel, String options) {
        log.info(String.format("Inserting into database worktype with parameters:\n" +
                        "code: %s\n" +
                        "name: %s\n" +
                        "on the %s vessel\n" +
                        "with options: %s",
                worktype, worktype, vessel, options));
        SQLUtils.createWorktype(WorktypesFactory.composeWorktype(worktype, vessels.get(vessel), options));
        log.info("The worktype was inserted\n");
    }
}
