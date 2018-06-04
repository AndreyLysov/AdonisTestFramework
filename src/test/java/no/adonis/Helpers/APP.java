package no.adonis.Helpers;

import no.adonis.Helpers.AAP.AAPLoginHelper;
import no.adonis.Helpers.ACP.ACPLoginHelper;
import no.adonis.Helpers.ACP.ACPStartHelper;
import no.adonis.Helpers.ACP.TAA.ACPCurentTimesheetHelper;
import no.adonis.Helpers.ACP.TAA.ACPTimeAndAttendancePageHelper;

public class APP {

    public BaseHelper base;

    //Administrator helpers
    public AAPLoginHelper aapLogin;

    //Crew portal helpers
    public ACPLoginHelper acpLogin;
    public ACPStartHelper acpStart;
    public ACPTimeAndAttendancePageHelper acpTAA;
    public ACPCurentTimesheetHelper acpCurrentTS;

    public APP() {
        base = new BaseHelper();
        aapLogin = new AAPLoginHelper();
        acpLogin = new ACPLoginHelper();
        acpStart = new ACPStartHelper();
        acpTAA = new ACPTimeAndAttendancePageHelper();
        acpCurrentTS = new ACPCurentTimesheetHelper();
    }
}