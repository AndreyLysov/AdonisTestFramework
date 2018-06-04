package no.adonis.Pages.ACP;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class ACPLoginPage {

    protected String title = "Crew Portal Login";

    SelenideElement inputPin = $(byName("pin"));
    SelenideElement inputPasscode = $(byName("password"));
    SelenideElement btnLogin = $(byId("btn-submit"));

    protected void enterPin(int pin) {
        inputPin.setValue(pin+"");
    }

    protected void enterPasscode(int password) {
        inputPasscode.setValue(password+"");
    }

    protected void clickLogin() {
        btnLogin.click();
    }

    protected boolean isOnPage(){
        return Selenide.title().equals(title);
    }
}
