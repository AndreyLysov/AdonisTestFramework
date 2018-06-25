package no.adonis.Pages.ACP.TimeAndAttendance;

import com.codeborne.selenide.SelenideElement;
import no.adonis.DataTypes.Timeregistrations.Timeregistration;
import org.joda.time.DateTime;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static no.adonis.Common.Constants.DTF;

public interface AddEditTimeRegistrationForm {
    SelenideElement datetimeTimeIn = $(byId("teTimeIn_I"));
    SelenideElement datetimeTimeOut = $(byId("teTimeOut_I"));
    SelenideElement ddlWorktype = $(byId("cbWorkTypes_I"));
    SelenideElement ddlTimezone = $(byId("cmbEPTimeZone_I"));
    SelenideElement chckbxRecurrence = $(byId("IsRecurrenceTR_S_D"));
    SelenideElement chckbxCurrentTimeRegistration = $(byId("cbIsCurrent_S_D"));
    SelenideElement btnSave = $(byId("btnAddTimeReg_CD"));

    default void setTimeIn(DateTime timeIn) {
        fillInDateTime(datetimeTimeIn, timeIn);
    }


    default void fillInDateTime(SelenideElement dateTimeField, DateTime time) {
        dateTimeField.click();
        dateTimeField.sendKeys(Keys.END);
        for (int i = 0; i< 20; i++)
            dateTimeField.sendKeys(Keys.BACK_SPACE);
        dateTimeField.sendKeys(DTF.print(time));
    }



    default void setTimeOut(DateTime timeOut) {
        if (timeOut != null) {
            fillInDateTime(datetimeTimeOut, timeOut);
        } else {
            makeTimeRegistrationCurrent();
        }
    }

    default void setWorktype(String worktype) {
        ddlWorktype.click();
        $(byXpath("//td[.='" + worktype + "']")).click();
    }

    default void makeTimeRegistrationCurrent() {
        chckbxCurrentTimeRegistration.click();
    }

    default void addTimeRegistration(Timeregistration timeregistration) {
        setTimeIn(timeregistration.getTimeIn());
        setTimeOut(timeregistration.getTimeOut());
        setWorktype(timeregistration.getWorktype().getName());
        btnSave.click();
    }
}
