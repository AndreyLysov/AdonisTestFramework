package no.adonis.DataTypes.Timeregistrations;

import no.adonis.DataTypes.Timezones.Timezone;
import no.adonis.DataTypes.Worktypes.Worktype;
import org.joda.time.DateTime;
import org.joda.time.Minutes;

import static no.adonis.Common.Constants.TF;

public class Timeregistration {
    private DateTime timeIn;
    private DateTime timeOut;
    private Timezone timezone;
    private Worktype worktype;

    @Override

    public String toString() {
        return TF.print(timeIn) + " - " + TF.print(timeOut) + " " +
                getDifferenceBetweenDateTimes(timeIn, timeOut) + " hrs; " +
                worktype.getName() + "; " + timezone.toStringInHours();
    }

    public String getDifferenceBetweenDateTimes(DateTime timein, DateTime timeout) {
        Minutes difference = Minutes.minutesBetween(timein, timeout);
        int hours = difference.toStandardHours().getHours();
        return hours + ":" + (difference.getMinutes()%hours == 0 ? "00" : difference.getMinutes());
    }

    public Timeregistration(DateTime timeIn, DateTime timeOut, Timezone timezone, Worktype worktype) {
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.timezone = timezone;
        this.worktype = worktype;
    }

    public Timeregistration(DateTime timeIn, DateTime timeOut, Worktype worktype) {
        this.timeIn = timeIn;
        this.timeOut = timeOut;
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

    public Worktype getWorktype() { return worktype; }

    public Timezone getTimezone() { return timezone; }
}
