package no.adonis.DataTypes.Timezones;

import no.adonis.DataTypes.PWORG.PWORG;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.time.format.DateTimeFormatter;

public class Timezone {
    private PWORG vessel;
    private int timezoneOffset;
    private DateTime changeDate;
    private static org.joda.time.format.DateTimeFormatter df = DateTimeFormat.forPattern("yyyy-MM-dd");

    private DateTime changeDateUTC;

    public Timezone(PWORG vessel, String timezone, String changeDate) {
        this.vessel = vessel;
        this.timezoneOffset = timezoneNameToOffset(timezone);
        this.changeDate = df.parseDateTime(changeDate);
        changeDateUTC = this.changeDate.plusMinutes(timezoneOffset);
    }


    public Timezone(PWORG vessel, int timezoneOffset, DateTime changeDate) {
        this.vessel = vessel;
        this.timezoneOffset = timezoneOffset;
        this.changeDate = changeDate;
        this.changeDateUTC = this.changeDate.plusMinutes(timezoneOffset);
    }

    private int timezoneNameToOffset(String timezone) {
        if (timezone.equals("0"))
            return 0;
        else {
            int offset = Integer.valueOf(timezone.substring(1)) * 60;
            return timezone.charAt(0) == '+' ? offset : offset * (-1);
        }
    }

    public PWORG getVessel() {
        return vessel;
    }

    public int getTimezoneOffset() {
        return timezoneOffset;
    }

    public DateTime getChangeDate() {
        return changeDate;
    }

    public DateTime getChangeDateUTC() {
        return changeDateUTC;
    }

    public String toStringInHours() {
        String tmp;
        int minutes = Math.abs(timezoneOffset) % 60;

        if (timezoneOffset == 0)
            tmp = "0:00";
        else if (timezoneOffset > 0)
            tmp = "+" + (timezoneOffset / 60) + ":" + (timezoneOffset % 60);
        else
            tmp = (timezoneOffset / 60) + ":" + (minutes == 0 ? "00" : minutes);

        return "GMT " + tmp;
    }

    @Override
    public String toString() {
        return "Timezone{" +
                "vessel=" + vessel +
                ", timezoneOffset=" + timezoneOffset +
                ", changeDate=" + changeDate +
                ", changeDateUTC=" + changeDateUTC +
                '}';
    }
}