package no.adonis.Steps.ACP;

import no.adonis.Steps.CommonStep;
import cucumber.api.java.en.And;

public class ACPLoginStepDefs extends CommonStep{
    @And("^login as crewmember$")
    public void loginAsCrewmember() {
        app.acpLogin.loginAsCrewmember();
    }
}
