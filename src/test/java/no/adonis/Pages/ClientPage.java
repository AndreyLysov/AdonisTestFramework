package no.adonis.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ClientPage extends BasePage{

    SelenideElement linkAAP = $(byXpath("//a[contains(text(),'/administrator')]"));
    SelenideElement linkACP = $(byXpath("//a[contains(text(),'/crew')]"));
    SelenideElement linkAEP = $(byXpath("//a[contains(text(),'/employee')]"));

    protected void moveToAAP() { linkAAP.click(); }

    protected void moveToACP() { linkACP.click(); }

    protected void moveToAEP() { linkAEP.click(); }
}
