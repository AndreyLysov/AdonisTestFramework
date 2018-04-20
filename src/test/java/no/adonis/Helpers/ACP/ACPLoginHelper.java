package no.adonis.Helpers.ACP;

import no.adonis.Pages.ACP.ACPLoginPage;

public class ACPLoginHelper extends ACPLoginPage {
    public void loginAsCrewmember() {
        enterPin(30941);
        enterPasscode(1);
        clickLogin();
    }
}
