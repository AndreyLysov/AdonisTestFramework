package no.adonis.Pages.AAP;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class AAPLoginPage {

    protected String title = "CrewPortal Login";

    SelenideElement inputEmail = $(byName("tbEmail"));
    SelenideElement inputPassword = $(byName("tbPassword"));
    SelenideElement btnLogin = $(byId("LogIn"));
    SelenideElement btnResendPassword = $(byId("Resend"));

    void enterEmail(String email) {
        inputEmail.setValue(email);
    }

    void enterPassword(String password) {
        inputPassword.setValue(password);
    }
}
