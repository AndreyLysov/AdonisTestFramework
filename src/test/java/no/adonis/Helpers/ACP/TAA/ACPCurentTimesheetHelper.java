package no.adonis.Helpers.ACP.TAA;

import no.adonis.Pages.ACP.TimeAndAttendance.ACPCurrentTimesheetPage;
import no.adonis.DataTypes.Timeregistrations.Timeregistration;
import org.joda.time.DateTime;

import static no.adonis.Common.Constants.DTF;

public class ACPCurentTimesheetHelper extends ACPCurrentTimesheetPage {
    public void openAddEditTimeRegistrationForm(){
        log.info("Opening 'Add/Edit timeregistration' form");
        openTimeCellMenu();
        clickAddEditTimeRegistration();
        log.info("The form is openned");
    }

    public void isTimeregistrationDisplayed(Timeregistration timeregistration){
        log.info("Checking is timeregistration: " + timeregistration.toString() + " displayed");
        checkIsTimeRegistrationDisplayed(timeregistration);
    }

    public void createTimeregistration(Timeregistration timeregistration){
        log.info("Creating timeregistration: " + timeregistration.toString());
        addTimeRegistration(timeregistration);
        log.info("The timeregistration is created");
    }

    public void enterTimein(DateTime timein){
        log.info("Entering time in: " + DTF.print(timein));
        setTimeIn(timein);
    }

    public void enterTimeOut(DateTime timeout){
        log.info("Entering time out " + DTF.print(timeout));
        setTimeOut(timeout);
    }
}
