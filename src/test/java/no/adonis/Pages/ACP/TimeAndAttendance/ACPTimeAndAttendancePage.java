package no.adonis.Pages.ACP.TimeAndAttendance;

import com.codeborne.selenide.SelenideElement;
import no.adonis.Pages.ACP.ACPLoggedUserPage;
import no.adonis.Pages.APPLoggedUserPage;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class ACPTimeAndAttendancePage extends ACPLoggedUserPage {
    SelenideElement tileMyTimesheets = $(byId("divTileMyTimesheet"));
    SelenideElement tileCoWorkersTimesheet = $(byId("divTileCoWorkersTimesheet"));
    SelenideElement tileMessages = $(byId("divTileMessage"));

    protected void moveToMyTimesheets() { tileMyTimesheets.click(); }

    protected void moveToCoWorkersTimesheets() { tileCoWorkersTimesheet.click(); }

    protected void moveToMessages() {
        tileMessages.click();
    }
}
