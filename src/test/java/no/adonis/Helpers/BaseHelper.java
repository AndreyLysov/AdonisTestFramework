package no.adonis.Helpers;

import com.codeborne.selenide.WebDriverRunner;
import no.adonis.Pages.BasePage;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseHelper extends BasePage {

    public void isOnBasePage() {
        $("title").shouldHave(attribute("text", title));
    }

    public void startApp() {
        open(baseUrl);
    }

    public void appStop() { WebDriverRunner.getWebDriver().close(); }

    public void openAAP(){
        log.info("Click on the 'Administrator' link");
        moveToAAP();
        log.info("Administrator portal is opened");
    }

    public void openACP(){
        log.info("Click on the 'Crew' link");
        moveToACP();
        log.info("Crew portal is opened");
    }
    public void openAEP(){
        log.info("Click on the 'Employee' link");
        moveToAEP();
        log.info("Employee portal is opened");
    }
}
