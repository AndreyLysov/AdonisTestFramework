package no.adonis.DataTypes.Timeregistrations;

import no.adonis.Utils.ExcelUtils;
import org.joda.time.DateTime;

import java.util.*;

public class TimeregistrationFactory {
/*

    public static Map<String, Timeregistration> getTimeregistrations() {

        List<List<String>> table = ExcelUtils.readExcel("TimeRegistrations");

        Map<String, Timeregistration> timeregistrations = new HashMap<>();

        //Need to think how it will work
        //left it for now
        table.stream().forEach(s -> timeregistrations.put(s.get(0), new Timeregistration(
                getCorrectDate(s.get(1)),
                getCorrectDate(s.get(2)),
                s.get(3))));

        return timeregistrations;
    }
*/



    static DateTime getCorrectDate(String offset) {

        DateTime firstDayOfWeek = new DateTime().withDayOfWeek(1).withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0);

        return firstDayOfWeek.plusDays(Integer.parseInt(offset.split(";")[0]))
                .plusHours(Integer.parseInt(offset.split(";")[1]))
                .plusMinutes(Integer.parseInt(offset.split(";")[2]));
    }
}
