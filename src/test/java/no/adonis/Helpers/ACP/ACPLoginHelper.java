package no.adonis.Helpers.ACP;

import no.adonis.Pages.ACP.ACPLoginPage;
import no.adonis.DataTypes.Users.Employee;
import org.junit.Assert;

public class ACPLoginHelper extends ACPLoginPage {

    //Need to implement user factory and implement loggining here

    public void loginAs(Employee employee) {
        //Need to implement loggining in for valid users
        enterPin(employee.getPin());
        enterPasscode(1);
        clickLogin();
    }

    public void isOnACPLoginPage(){
        Assert.assertTrue(isOnPage());
    }
}
