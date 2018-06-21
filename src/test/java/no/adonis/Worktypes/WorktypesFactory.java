package no.adonis.Worktypes;

import no.adonis.PWORG.PWORG;
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

    public static Worktype composeWorktype(String name, PWORG vessel, String options) {
        Worktype worktype = new Worktype(name, vessel);
        String[] optionList = options.split(";");
        for (String option :
                optionList) {
            switch (option) {
                case "isWork":
                    worktype.setWork(true);
                    break;
                case "isDrill":
                    worktype.setDrill(true);
                    break;
                case "isRest":
                    worktype.setRest(true);
                    break;
                case "isMeal":
                    worktype.setMeal(true);
                    break;
                case "isSideDuty":
                    worktype.setSideDuty(true);
                    break;
                case "isSick":
                    worktype.setSick(true);
                    break;
                case "isWorkAndRest":
                    worktype.setWorkAndRest(true);
                    break;
                case "hideInTimeclock":
                    worktype.setHideInTimeclock(true);
                    break;
                case "hideInManual":
                    worktype.setHideInManual(true);
                    break;
                case "nonOT":
                    worktype.setNonOT(true);
                    break;
            }
        }

        return worktype;
    }
}
