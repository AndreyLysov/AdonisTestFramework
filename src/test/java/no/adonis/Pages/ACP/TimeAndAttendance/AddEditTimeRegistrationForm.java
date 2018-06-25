package no.adonis.Pages.ACP.TimeAndAttendance;

import com.codeborne.selenide.SelenideElement;
import no.adonis.Helpers.ACP.TAA.AddTimeRegistrationImplementations.AddTimeRegistration;
import no.adonis.DataTypes.Timeregistrations.Timeregistration;
import org.joda.time.DateTime;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public interface AddEditTimeRegistrationForm extends AddTimeRegistration {
    SelenideElement datetimeTimeIn = $(byId("teTimeIn_I"));
    SelenideElement datetimeTimeOut = $(byId("teTimeOut_I"));
    SelenideElement ddlWorktype = $(byId("cbWorkTypes_I"));
    SelenideElement ddlTimezone = $(byId("cmbEPTimeZone_I"));
    SelenideElement chckbxRecurrence = $(byId("IsRecurrenceTR_S_D"));
    SelenideElement chckbxCurrentTimeRegistration = $(byId("cbIsCurrent_S_D"));
    SelenideElement btnSave = $(byId("btnAddTimeReg_CD"));

    public void fillInDateTime(SelenideElement dateTimeField, DateTime time);


    default void enterTimeIn(DateTime timeIn) {
        fillInDateTime(datetimeTimeIn, timeIn);
    }


    default void enterTimeOut(DateTime timeOut) {
        if (timeOut != null) {
            fillInDateTime(datetimeTimeOut, timeOut);
        } else {
            makeTimeRegistrationCurrent();
        }
    }

    default void selectWorktype(String worktype) {
        ddlWorktype.click();
        $(byXpath("//td[.='" + worktype + "']")).click();
    }

    default void makeTimeRegistrationCurrent() {
        chckbxCurrentTimeRegistration.click();
    }

    default void createTimeRegistration(Timeregistration timeregistration) {
        enterTimeIn(timeregistration.getTimeIn());
        enterTimeOut(timeregistration.getTimeOut());
        selectWorktype(timeregistration.getWorktype().getName());
        btnSave.click();
    }
}
