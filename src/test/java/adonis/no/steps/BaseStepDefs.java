package adonis.no.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BaseStepDefs extends CommonStep {

    @Given("^open base page$")
    public void openStartPage() {
        app.base.openBasePage();
    }

    @Then("^start page is opened$")
    public void startPageIsOpened() {
       // throw new NotImplementedException();
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
