package no.adonis.Pages.ACP;

import com.codeborne.selenide.SelenideElement;
import no.adonis.Pages.APPLoggedUserPage;
import no.adonis.Pages.BasePage;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class ACPLoggedUserPage extends APPLoggedUserPage {

    SelenideElement inputPin = $(byId("notification-button"));
}
