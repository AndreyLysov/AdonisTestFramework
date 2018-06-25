package no.adonis.Steps.ACP;

import cucumber.api.java.en.And;
import no.adonis.Steps.CommonStep;

public class ACPLoginStep extends CommonStep {
    @And("^\"([^\"]*)\" is logged in$")
    public void isLoggedIn(String employee) {
        app.acpLogin.loginAs(employees.get(employee));
    }
}