package no.adonis.Helpers.ACP.TAA;

import no.adonis.Pages.ACP.TimeAndAttendance.ACPCurrentTimesheetPage;

public class ACPCurentTimesheetHelper extends ACPCurrentTimesheetPage {
    public void openAddEditTimeRegistrationForm(){
        openTimeCellMenu();
        clickAddEditTimeRegistration();
    }

    public void addTimeRegistration(String timeRegistration){
//        insertTimeRegistration(timeregistrations.get(timeRegistration));
    }
}
