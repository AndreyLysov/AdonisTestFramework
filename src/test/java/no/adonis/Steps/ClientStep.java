package no.adonis.Steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import no.adonis.DataTypes.Activity.Activity;
import no.adonis.DataTypes.Role.Role;
import no.adonis.DataTypes.TimesheetPeriod.TimesheetPeriod;
import no.adonis.DataTypes.Timezones.Timezone;
import no.adonis.DataTypes.UserGroup.UserGroup;
import no.adonis.DataTypes.Users.Employee;
import no.adonis.Utils.SQLUtils;
import no.adonis.DataTypes.Worktypes.Worktype;
import no.adonis.DataTypes.Worktypes.WorktypesFactory;

public class ClientStep extends CommonStep {

    @Given("^\"([^\"]*)\" is opened$")
    public void isOpened(String portal) {
        if (portal.equals("AAP"))
            app.client.openAAP();
        else if (portal.equals("ACP"))
            app.client.openACP();
        else
            app.client.openAEP();
    }
}
