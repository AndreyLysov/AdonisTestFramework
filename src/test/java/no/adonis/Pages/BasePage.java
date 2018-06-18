package no.adonis.Pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import no.adonis.Steps.CommonStep;
import no.adonis.Timeregistrations.Timeregistration;
import no.adonis.Timeregistrations.TimeregistrationFactory;
import no.adonis.Users.Employee;
import no.adonis.Users.EmployeeFactory;
import org.apache.log4j.Logger;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.interactions.Actions;

import java.text.DateFormat;
import java.util.Map;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class BasePage {
    protected String title = "Select Client";
    protected Logger log;
    protected Actions actions;
//    protected Map<String, Timeregistration> timeregistrations;
    protected DateTimeFormatter dtfOut;
    public BasePage(){
        log  = Logger.getLogger(this.getClass().getSimpleName());
        actions = new Actions(WebDriverRunner.getWebDriver());
//        timeregistrations = TimeregistrationFactory.getTimeregistrations();
        dtfOut = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm");
    }

    SelenideElement linkAAP = $(byXpath("//a[contains(text(),'/administrator')]"));
    SelenideElement linkACP = $(byXpath("//a[contains(text(),'/crew')]"));
    SelenideElement linkAEP = $(byXpath("//a[contains(text(),'/employee')]"));


    protected void moveToAAP() { linkAAP.click(); }

    protected void moveToACP() { linkACP.click(); }

    protected void moveToAEP() { linkAEP.click(); }
}