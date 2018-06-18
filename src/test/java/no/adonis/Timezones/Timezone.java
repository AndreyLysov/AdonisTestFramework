package no.adonis.Timezones;

import org.joda.time.DateTime;

public class Timezone {
    private int numorgid;
    private int timezoneOffset;
    private DateTime changeDate;

    public Timezone(int numorgid, int timezoneOffset, DateTime changeDate) {
        this.numorgid = numorgid;
        this.timezoneOffset = timezoneOffset;
        this.changeDate = changeDate;
    }

    public int getNumorgid() {
        return numorgid;
    }

    public int getTimezoneOffset() {
        return timezoneOffset;
    }

    public DateTime getChangeDate() {
        return changeDate;
    }

    public String toStringInHours() {
        String tmp;

        if (timezoneOffset == 0)
            tmp = "0:00";
        else if (timezoneOffset > 0)
            tmp = "+" + (timezoneOffset / 60) + ":" + (timezoneOffset % 60);
        else
            tmp = (timezoneOffset / 60) + ":" + (Math.abs(timezoneOffset) % 60);

        return "GMT " + tmp;
    }
}