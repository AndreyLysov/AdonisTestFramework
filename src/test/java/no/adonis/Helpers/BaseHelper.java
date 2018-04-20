package no.adonis.Helpers;

import no.adonis.Pages.BasePage;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseHelper extends BasePage {

    public void isOnBasePage() {
        $("title").shouldHave(attribute("text", title));
    }

    public void openBasePage() {
        open(baseUrl);
    }
}
