package adonis.no.pages.ACP;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ACPLoginPage {

    protected String title = "CrewPortal Login";

    SelenideElement inputPin = $(byName("tbPin"));
    SelenideElement inputPasscode = $(byName("tbPasscode"));
    SelenideElement btnLogin = $(byId("btnLogin"));

    protected void enterPin(int pin) {
        inputPin.setValue(pin+"");
    }

    protected void enterPasscode(int password) {
        inputPasscode.setValue(password+"");
    }

    protected void clickLogin() {
        btnLogin.click();
    }
}
