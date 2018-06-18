package no.adonis.Steps.ACP;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import no.adonis.Steps.CommonStep;


public class ACPStartPageSteps extends CommonStep {

    @And("^\"([^\"]*)\" page is opened$")
    public void pageIsOpened(String page) {
        app.acpStart.openMyTimesheetPage(page);
    }
}



