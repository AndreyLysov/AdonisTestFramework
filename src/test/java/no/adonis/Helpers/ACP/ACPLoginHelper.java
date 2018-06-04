package no.adonis.Helpers.ACP;

import no.adonis.Pages.ACP.ACPLoginPage;
import org.junit.Assert;

public class ACPLoginHelper extends ACPLoginPage {

    //Need to implement user factory and implement loggining here

    public void loginAsCrewmember() {
        enterPin(30941);
        enterPasscode(1);
        clickLogin();
    }

    public void isOnACPLoginPage(){
        Assert.assertTrue(isOnPage());
    }
}
