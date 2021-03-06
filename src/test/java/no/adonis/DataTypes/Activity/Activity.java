package no.adonis.DataTypes.Activity;

import no.adonis.DataTypes.PWORG.PWORG;
import no.adonis.DataTypes.Users.Employee;
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

    @Override
    public String toString() {
        return "Activity{" +
                "employee=" + employee +
                ", dateFrom=" + dateFrom +
                ", position=" + position +
                ", activityCode=" + activityCode +
                ", planned=" + planned +
                ", vessel=" + vessel +
                '}';
    }
}
