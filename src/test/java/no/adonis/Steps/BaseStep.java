package no.adonis.Steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BaseStep extends CommonStep {

    @Then("^start page is opened$")
    public void startPageIsOpened() {

    }

    @When("^open AAP$")
    public void openAAP() {
        app.base.openAAP();
    }

    @When("^open ACP$")
    public void openACP() {
        app.base.openACP();
    }

    @When("^open AEP$")
    public void openAEP() {
        app.base.openAEP();
    }


}
