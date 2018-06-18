package no.adonis.Worktypes;

import no.adonis.Timeregistrations.Timeregistration;
import no.adonis.Utils.ExcelUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorktypesFactory {
    /*public static Map<String, Worktype> getWorktypes() {

        List<List<String>> table = ExcelUtils.readExcel("DataProvider.xls", "Worktypes");

        Map<String, Timeregistration> worktypes = new HashMap<>();

        table.stream().forEach(s -> timeregistrations.put(s.get(0), new Worktype(
                Boolean.getBoolean(s.get(1)),
                getCorrectDate(s.get(2)),
                s.get(3))));

        return timeregistrations;
    }*/
}
