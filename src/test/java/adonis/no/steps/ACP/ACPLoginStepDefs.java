package adonis.no.steps.ACP;

import adonis.no.steps.CommonStep;
import cucumber.api.java.en.And;

public class ACPLoginStepDefs extends CommonStep{
    @And("^login as crewmember$")
    public void loginAsCrewmember() {
        app.acpLogin.loginAsCrewmember();
    }
}
