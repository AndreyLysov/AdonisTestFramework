package no.adonis.Activity;

import no.adonis.PWORG.PWORG;
import no.adonis.Users.Employee;
import org.joda.time.DateTime;

public class Activity {
    private Employee employee;
    private PWORG position;
    private String code;
    private DateTime dateFrom;
    private String planned;

    public Activity(Employee employee, PWORG position, String code, DateTime dateFrom, String planned) {

        this.employee = employee;
        this.position = position;
        this.code = code;
        this.dateFrom = dateFrom;
        this.planned = planned;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setPosition(PWORG position) {
        this.position = position;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDateFrom(DateTime dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setPlanned(String planned) {
        this.planned = planned;
    }
}
