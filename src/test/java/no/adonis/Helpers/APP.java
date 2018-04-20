package no.adonis.Helpers;

import no.adonis.Helpers.AAP.AAPLoginHelper;
import no.adonis.Helpers.ACP.ACPLoginHelper;

public class APP {
    public BaseHelper base;
    public AAPLoginHelper aapLogin;
    public ACPLoginHelper acpLogin;

    public APP() {
        base = new BaseHelper();
        aapLogin = new AAPLoginHelper();
        acpLogin = new ACPLoginHelper();
    }
}