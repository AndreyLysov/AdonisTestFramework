package no.adonis.Steps.ACP.TimeAndAttendanceSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import no.adonis.Steps.CommonStep;

public class ACPTimeAndAttendanceSteps extends CommonStep {

    @And("^open my timesheet page$")
    public void openMyTimesheetPage() {
        app.acpTAA.openMyTimesheetsPage();
    }



}
