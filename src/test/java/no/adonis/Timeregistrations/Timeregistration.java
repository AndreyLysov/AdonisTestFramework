package no.adonis.Timeregistrations;

import org.joda.time.DateTime;

import java.util.Date;

public class Timeregistration {
    private int pin;
    private DateTime timeIn;
    private DateTime timeOut;
    private int timeZoneOffset;
    private String worktype;


    public Timeregistration(DateTime timeIn, DateTime timeOut, String worktype) {
        setTimeIn(timeIn);
        setTimeOut(timeOut);
        setWorktype(worktype);
    }

    public void setTimeIn(DateTime timeIn) {
        this.timeIn = timeIn;
    }

    public void setTimeOut(DateTime timeOut) {
        this.timeOut = timeOut;
    }

    public void setTimeZoneOffset(int timeZoneOffset) {
        this.timeZoneOffset = timeZoneOffset;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype;
    }

    public int getPin() {
        return pin;
    }

    public DateTime getTimeIn() {
        return timeIn;
    }

    public DateTime getTimeOut() {
        return timeOut;
    }

    public int getTimeZoneOffset() {
        return timeZoneOffset;
    }

    public String getWorktype() {
        return worktype;
    }
}
