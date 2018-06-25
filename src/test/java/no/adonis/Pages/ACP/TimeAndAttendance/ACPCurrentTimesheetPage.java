package no.adonis.Pages.ACP.TimeAndAttendance;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import no.adonis.DataTypes.Timeregistrations.Timeregistration;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$$;
import static no.adonis.Common.Constants.DTF;

public class ACPCurrentTimesheetPage extends ACPMyTimesheetPage implements AddEditTimeRegistrationForm {
    SelenideElement ddlDayCount = $(byId("cbDayCount_I"));
    ElementsCollection timeCells = $$(byXpath("//table[@class='dxscDayScrollBodyTable']//td[@class='dxscTimeCellBody_Metropolis']"));
    SelenideElement itemAddTimeRegistration = $(byId("scTimesheet_viewMenuBlock_SMVIEW_DXI0_"));
    ElementsCollection timeblocksText = $$(byXpath("//div[@class='dxsc-apt-time-container']"));
    SelenideElement timeblockText = $(byXpath("//div[@class='dxsc-apt-time-container']"));

    protected void openTimeCellMenu(){
        timeCells.get(0).contextClick();
    }

    protected void clickAddEditTimeRegistration(){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        itemAddTimeRegistration.click();
    }

    @Override
    public void fillInDateTime(SelenideElement dateTimeField, DateTime time) {
        dateTimeField.click();
        dateTimeField.sendKeys(Keys.END);
        for (int i = 0; i< 20; i++)
            dateTimeField.sendKeys(Keys.BACK_SPACE);
        dateTimeField.sendKeys(DTF.print(time));
    }

    protected void checkIsTimeRegistrationDisplayed(Timeregistration timeregistration){

        log.info("Expected timeregistration:\n" + timeregistration.toString());
        log.info("Timeregistration text from page:\n" + timeblockText.text());

        Assert.assertTrue(String.format("time registration with time in %s, " +
                        "time out %s, work type %s and timezone offset %d is not displayed",
                timeregistration.getTimeIn().toDateTimeISO().toString(),
                timeregistration.getTimeOut().toDateTimeISO().toString(),
                timeregistration.getWorktype().getName(),
                timeregistration.getTimezone().getTimezoneOffset()),
                timeblockText.equals(timeregistration.toString()));

    }


    //Need to implement this for moving top and bottom borders of time registration
    /*
    WebElement elem = driver.findElement(By.className("ytp-progress-bar"));

    int width = elem.getSize().getWidth();

    Actions act = new Actions(driver);
    act.moveToElement(elem).moveByOffset((width/2)-2, 0).click().perform();
    */
}
