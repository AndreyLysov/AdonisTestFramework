package no.adonis.Timeregistrations;

import no.adonis.Timezones.Timezone;
import no.adonis.Worktypes.Worktype;
import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.Minutes;

public class Timeregistration {
    private DateTime timeIn;
    private DateTime timeOut;
    private Timezone timezone;
    private Worktype worktype;

    @Override
    public String toString() {
        return timeIn + " - " + timeOut + " " +
                Hours.hoursBetween(timeIn, timeOut) + ":" +
                getDifferenceBetweenDateTimes(timeIn, timeOut) + " hrs; " +
                worktype.getName() + "; " + timezone.toStringInHours();
    }

    public String getDifferenceBetweenDateTimes(DateTime timein, DateTime timeout) {
        Minutes difference = Minutes.minutesBetween(timein, timeout);
        int hours = difference.toStandardHours().getHours();
        return hours + ":" + (difference.getMinutes()%hours);
    }

    public Timeregistration(int pin, DateTime timeIn, DateTime timeOut, Timezone timezone, Worktype worktype) {
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.timezone = timezone;
        this.worktype = worktype;
    }

    public DateTime getTimeIn() {
        return timeIn;
    }

    public DateTime getTimeOut() {
        return timeOut;
    }

    public Timezone getTimeZoneOffset() {
        return timezone;
    }

    public Worktype getWorktype() {
        return worktype;
    }
}
