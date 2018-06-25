package no.adonis.DataTypes.Worktypes;

import no.adonis.DataTypes.PWORG.PWORG;
import no.adonis.DataTypes.Timeregistrations.Timeregistration;
import no.adonis.Utils.ExcelUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorktypesFactory {

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
