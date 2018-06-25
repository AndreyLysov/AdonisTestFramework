package no.adonis.Steps.ACP.TimeAndAttendanceSteps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import no.adonis.Steps.CommonStep;
import no.adonis.DataTypes.Timeregistrations.Timeregistration;
import org.joda.time.DateTime;

public class ACPCurrentTimesheetSteps extends CommonStep {
    @And("^open add edit time registration form$")
    public void openAddEditTimeRegistrationForm() {
        log.info("Opening 'Add/Edit time registration' form");
        app.acpCurrentTS.openAddEditTimeRegistrationForm();
        log.info("'Add/Edit time registration' form is opened");
    }

    @Then("^time registration is displayed$")
    public void timeRegistrationIsDisplayed() {

        log.info("Time registration is displayed");
    }

    @When("^create time registration with timein (\\d+) hours and time out (\\d+) hours and \"([^\"]*)\" work type for yesterday$")
    public void createTimeRegistrationWithTimeinHoursAndTimeOutHoursAndWorkTypeForYesterday(int timein, int timeout, String worktype) {

        DateTime yesterday = new DateTime().minusDays(1);

        app.acpCurrentTS.openAddEditTimeRegistrationForm();

        Timeregistration tr = new Timeregistration(
                yesterday.withHourOfDay(timein).withMinuteOfHour(0),
                yesterday.withHourOfDay(timeout).withMinuteOfHour(0),
                worktypes.get(worktype));

        app.acpCurrentTS.createTimeregistration(tr);
    }

    @Then("^time registration with time in (\\d+) hours, time out (\\d+) hours, \"([^\"]*)\" work type and \"([^\"]*)\" timezone for yesterday is displayed$")
    public void timeRegistrationWithTimeInHoursTimeOutHoursWorkTypeAndTimezoneIsDisplayed(int timein, int timeout, String worktype, String timezone) {

        DateTime yesterday = new DateTime().minusDays(1);

        Timeregistration tr = new Timeregistration(
                yesterday.withHourOfDay(timein).withMinuteOfHour(0),
                yesterday.withHourOfDay(timeout).withMinuteOfHour(0),
                timezones.get(timezone),
                worktypes.get(worktype));

        app.acpCurrentTS.isTimeregistrationDisplayed(tr);
    }
}
