package no.adonis.Helpers.ACP;

import no.adonis.Pages.ACP.ACPStartPage;

public class ACPStartHelper extends ACPStartPage {

    public void openMyTimesheetPage(){
        moveToTimeAndAttendance();
    }

    public void openMyTimesheetPage(String page) {

        log.info("Opening '" + page + "' page");

        if (page.equals("My Timesheet")) {
            moveToCurrentTimesheetUsingNavigationPanel();
        } else if (page.equals("Day To Day"))
            moveToDayToDayPlanning();
         else if (page.equals("My Flights"))
            moveToMyFlights();
         else if (page.equals("Personal Details"))
            moveToPersonalDetails();
         else if (page.equals("Time And Attendance"))
            moveToTimeAndAttendance();
        log.info("'" + page + "' page is opened");
    }
}
