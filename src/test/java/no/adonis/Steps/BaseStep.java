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
        employees.put(name, EmployeeFactory.getEmployee(name));
        SQLUtils.createEmployee(employees.get(name));
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
        SQLUtils.createTimezone(
                new Timezone(
                        vessels.get(vessel),
                        timezone,
                        dateFrom
                ));
    }

    @And("^period started (\\d+) days backward (\\d+) days forward is created on \"([^\"]*)\" vessel$")
    public void periodStartedDaysBackwardDaysForwardIsCreatedOnVessel(int dateFromOffset, int dateToOffset, String vessel) {
        SQLUtils.createTimesheetPeriod(
                new TimesheetPeriod(
                        dateFromOffset,
                        dateToOffset,
                        vessels.get(vessel))
        );
    }


    @And("^worktype \"([^\"]*)\" is exist on the \"([^\"]*)\" vessel with options$")
    public void worktypeIsExistOnTheVesselWithOptions(String worktype, String vessel, DataTable options) {

    }
}
