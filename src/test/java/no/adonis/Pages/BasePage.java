package no.adonis.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class BasePage {
    protected String title = "Select Client";

    SelenideElement linkAAP = $(byXpath("//a[contains(text(),'/administrator')]"));
    SelenideElement linkACP = $(byXpath("//a[contains(text(),'/crew')]"));
    SelenideElement linkAEP = $(byXpath("//a[contains(text(),'/employee')]"));



    public void openAAP() {
        linkAAP.click();
    }

    public void openACP() {
        linkACP.click();
    }

    public void openAEP() {
        linkAEP.click();
    }
}
