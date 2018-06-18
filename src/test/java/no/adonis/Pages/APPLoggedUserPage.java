package no.adonis.Pages;

import com.codeborne.selenide.SelenideElement;
import no.adonis.Pages.BasePage;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class APPLoggedUserPage extends BasePage {

    SelenideElement txtClient = $(byXpath("div[@class='header-left']/div"));
    SelenideElement lnkUserName = $(byClassName("UserName"));
    SelenideElement btnLogOff = $(byClassName("footer"));
}
