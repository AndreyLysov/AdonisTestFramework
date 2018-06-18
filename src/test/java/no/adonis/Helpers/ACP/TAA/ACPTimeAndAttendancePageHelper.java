package no.adonis.Helpers.ACP.TAA;

import no.adonis.Pages.ACP.TimeAndAttendance.ACPTimeAndAttendancePage;

public class ACPTimeAndAttendancePageHelper extends ACPTimeAndAttendancePage {

    public void openMyTimesheetsPage() {
        log.info("Opening 'My Timesheets' page");
        moveToMyTimesheets();
        log.info("'My Timesheets' page is opened");
    }

    public void openCoWorkersTimesheetsPage() {
        log.info("Opening 'Co-Workers Timesheets' page");
        moveToCoWorkersTimesheets();
        log.info("'Co-Workers Timesheets' page is opened");
    }

    public void openMessagesPage() {
        log.info("Opening the 'Message' page");
        moveToMessages();
        log.info("'Message' page is opened");
    }
}
