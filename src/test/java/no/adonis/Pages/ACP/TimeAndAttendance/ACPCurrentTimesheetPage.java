package no.adonis.Pages.ACP.TimeAndAttendance;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import no.adonis.Timeregistrations.Timeregistration;
import org.joda.time.DateTime;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$$;

public class ACPCurrentTimesheetPage extends ACPMyTimesheetPage implements AddEditTimeRegistrationForm {
    SelenideElement ddlDayCount = $(byId("cbDayCount_I"));
    ElementsCollection timeCells = $$(byXpath("//table[@class='dxscDayScrollBodyTable']//td[@class='dxscTimeCellBody_Metropolis']"));
    SelenideElement itemAddTimeRegistration = $(byId("scTimesheet_viewMenuBlock_SMVIEW_DXI0_"));
    ElementsCollection timeblocksText = $$(byXpath("//div[@class='dxsc-apt-time-container']"));

    protected void openTimeCellMenu(){
        timeCells.get(0).contextClick();
    }

    protected void clickAddEditTimeRegistration(){
        itemAddTimeRegistration.click();
    }

    protected void insertTimeRegistration(Timeregistration timeregistration){
//        createTimeRegistration(timeregistrations.get("timeregistration"));
    }

    @Override
    public void fillInDateTime(SelenideElement dateTimeField, DateTime time) {
        dateTimeField.click();
        dateTimeField.sendKeys(Keys.END);
        for (int i = 0; i< 20; i++)
            dateTimeField.sendKeys(Keys.BACK_SPACE);
        dateTimeField.sendKeys(dtfOut.print(time));
    }

    protected void checkIsTimeRegistrationDisplayed(Timeregistration timeregistration){
        timeblocksText.stream().forEach(s->s.text().equals(timeregistration.toString()));
    }

    /*
    WebElement elem = driver.findElement(By.className("ytp-progress-bar"));

    int width = elem.getSize().getWidth();

    Actions act = new Actions(driver);
    act.moveToElement(elem).moveByOffset((width/2)-2, 0).click().perform();
    */
}