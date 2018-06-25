package no.adonis.Helpers.ACP.TAA;

import no.adonis.Pages.ACP.TimeAndAttendance.ACPCurrentTimesheetPage;
import no.adonis.DataTypes.Timeregistrations.Timeregistration;

public class ACPCurentTimesheetHelper extends ACPCurrentTimesheetPage {
    public void openAddEditTimeRegistrationForm(){
        openTimeCellMenu();
        clickAddEditTimeRegistration();
    }

    public void isTimeregistrationDisplayed(Timeregistration timeregistration){
        checkIsTimeRegistrationDisplayed(timeregistration);
    }

    public void addTimeRegistration(String timeregistration){

    }
}
