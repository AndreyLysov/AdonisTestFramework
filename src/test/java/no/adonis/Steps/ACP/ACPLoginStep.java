package no.adonis.Steps.ACP;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import no.adonis.Steps.CommonStep;
import cucumber.api.java.en.And;

public class ACPLoginStep extends CommonStep{
    @And("^login as crewmember$")
    public void loginAsCrewmember() {
        app.acpLogin.loginAsCrewmember();
    }


    @Given("^ACP is opened$")
    public void acpIsOpened() {
        app.base.openACP();
    }
}
