package no.adonis.Activity;

import no.adonis.PWORG.PWORG;
import no.adonis.Users.Employee;
import org.joda.time.DateTime;

public class Activity {
    private Employee employee;
    private DateTime dateFrom;
    private PWORG position;
    private ActivityCode activityCode;
    private boolean planned;
    private PWORG vessel;

    public Activity(Employee employee, PWORG position, ActivityCode activityCode, DateTime dateFrom, PWORG vessel, boolean planned) {

        this.employee = employee;
        this.position = position;
        this.activityCode = activityCode;
        this.dateFrom = dateFrom;
        this.planned = planned;
        this.vessel = vessel;
    }

    public Activity(Employee employee, PWORG position, ActivityCode activityCode, int dateFromOffset, PWORG vessel, boolean planned){
        this.employee = employee;
        this.position = position;
        this.activityCode = activityCode;
        this.dateFrom = new DateTime().minusDays(dateFromOffset);
        this.planned = planned;
        this.vessel = vessel;
    }

    public Employee getEmployee() {
        return employee;
    }

    public DateTime getDateFrom() {
        return dateFrom;
    }

    public PWORG getPosition() {
        return position;
    }

    public ActivityCode getActivityCode() {
        return activityCode;
    }

    public boolean isPlanned() {
        return planned;
    }

    public PWORG getVessel() {
        return vessel;
    }
}
