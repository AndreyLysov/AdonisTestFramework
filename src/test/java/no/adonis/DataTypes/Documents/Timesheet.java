package no.adonis.DataTypes.Documents;

import no.adonis.DataTypes.Activity.Activity;
import no.adonis.DataTypes.Users.Employee;
import org.joda.time.DateTime;

import static no.adonis.Common.Constants.DF;

public class Timesheet extends Document {

    private Employee employee;
    private String name;
    private DateTime dateFrom;
    private DateTime dateTo;
    private Activity activity;
    private static int counter = 0;
    private String stateName;
    private int state;

    public Timesheet(Employee employee, DateTime dateFrom, DateTime dateTo, Activity activity, String stateName) {
        this.employee = employee;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.name = dateFrom.toString("MMM yyyy");
        this.activity = activity;
        this.sequenceno = counter;
        this.documentId = counter++;
        this.stateName = stateName;
        setState(stateName);
    }

    public Timesheet(Employee employee, DateTime dateFrom, Activity activity, String stateName) {
        this.employee = employee;
        this.dateFrom = dateFrom;
        this.activity = activity;
        this.sequenceno = counter;
        this.documentId = counter++;
        this.stateName = stateName;
        setState(stateName);
    }

    private void setState(String stateName) {
        switch (stateName) {
            case "Created":
                this.state = 1;
                break;
            case "Submitted":
                this.state = 2;
                break;
            case "Approved":
                this.state = 3;
                break;
        }
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getName() {
        return name;
    }

    public int getDocumentId() {
        return documentId;
    }

    public int getSequenceno() {
        return sequenceno;
    }

    public DateTime getDateFrom() {
        return dateFrom;
    }

    public Activity getActivity() {
        return activity;
    }

    public static int getCounter() {
        return counter;
    }

    public DateTime getDateTo() {
        return dateTo;
    }

    @Override
    public String toString() {
        return name + " " +
                DF.print(dateFrom) +
                " - " +
                (dateTo == null ? DF.print(new DateTime()) : DF.print(dateTo)) +
                " : " +
                stateName;
    }
}
