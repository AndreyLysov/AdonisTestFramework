package no.adonis.Helpers;

import com.codeborne.selenide.WebDriverRunner;
import no.adonis.Pages.ClientPage;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ClientHelper extends ClientPage {

    public void isOnBasePage() {
        $("title").shouldHave(attribute("text", title));
    }

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
