package adonis.no.helpers.ACP;

import adonis.no.pages.ACP.ACPLoginPage;

public class ACPLoginHelper extends ACPLoginPage {
    public void loginAsCrewmember() {
        enterPin(30941);
        enterPasscode(1);
        clickLogin();
    }
}
