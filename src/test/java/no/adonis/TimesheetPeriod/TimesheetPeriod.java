package no.adonis.TimesheetPeriod;

import no.adonis.PWORG.PWORG;
import org.joda.time.DateTime;

public class TimesheetPeriod {
    private int period;
    private String name;
    private DateTime dateFrom;
    private DateTime dateTo;
    private PWORG vessel;

    public TimesheetPeriod(DateTime dateFrom, DateTime dateTo, PWORG vessel) {
        this.period = Integer.valueOf(dateFrom.getYear()+""+dateFrom.getMonthOfYear());
        this.name = dateFrom.toString("MMM yyyy");
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.vessel = vessel;
    }

    public TimesheetPeriod(int dateFromOffset, int dateToOffset, PWORG vessel){
        DateTime today = new DateTime().withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0);
        this.dateFrom = today.minusDays(dateFromOffset);
        this.dateTo = today.plusDays(dateToOffset);
        this.period = Integer.valueOf(dateFrom.getYear()+""+dateFrom.getMonthOfYear());
        this.name = dateFrom.toString("MMM yyyy");
        this.vessel = vessel;
    }

    public int getPeriod() {
        return period;
    }

    public String getName() {
        return name;
    }

    public DateTime getDateFrom() {
        return dateFrom;
    }

    public DateTime getDateTo() {
        return dateTo;
    }

    public PWORG getVessel() {
        return vessel;
    }
}
