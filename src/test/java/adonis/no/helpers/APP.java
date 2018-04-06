package adonis.no.helpers;

import adonis.no.helpers.AAP.AAPLoginHelper;
import adonis.no.helpers.ACP.ACPLoginHelper;

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