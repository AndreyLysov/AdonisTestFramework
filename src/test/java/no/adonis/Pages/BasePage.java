package no.adonis.Pages;

import com.codeborne.selenide.WebDriverRunner;
import no.adonis.Utils.SQLUtils;
import org.apache.log4j.Logger;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;


public class BasePage {
    protected String title = "Select Client";
    protected Logger log;
    protected static Actions actions = new Actions(WebDriverRunner.getWebDriver());
    public BasePage(){
        log  = Logger.getLogger(this.getClass().getSimpleName());
    }
}