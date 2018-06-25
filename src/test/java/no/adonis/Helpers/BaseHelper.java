package no.adonis.Helpers;

import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class BaseHelper {

    public void startApp() {
        open(baseUrl);
    }

    public void stopApp() {
        WebDriverRunner.getWebDriver().close();
    }
}
