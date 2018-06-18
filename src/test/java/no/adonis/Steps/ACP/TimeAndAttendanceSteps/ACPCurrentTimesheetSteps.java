package no.adonis.Steps.ACP.TimeAndAttendanceSteps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import no.adonis.Steps.CommonStep;

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

    @When("^create \"([^\"]*)\"$")
    public void create(String timeRegistration) {
        app.acpCurrentTS.addTimeRegistration(timeRegistration);
    }
}
