package no.adonis.Steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
    public void isCreated(String employee) {
        SQLUtils.createEmployee(employees.get(employee));
    }
}
