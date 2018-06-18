package no.adonis.Pages.ACP;

import com.codeborne.selenide.SelenideElement;
import no.adonis.Pages.APPLoggedUserPage;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class ACPStartPage extends ACPLoggedUserPage {
    SelenideElement tileMyPersonalDetails = $(byId("divTilePersonalDetails"));
    SelenideElement tileMyFlights = $(byId("divTileFlightDetails"));
    SelenideElement tileDayToDay = $(byId("divTileDayToDay"));
    SelenideElement tileTimeAndAttendance = $(byId("divTileTimeAndAttendance"));

    SelenideElement ddlMyPersDetails = $(byId("bcTilePersonalDetails"));
    SelenideElement itemDetails = $(byId("bcPDDetails"));
    SelenideElement itemAddress = $(byId("bcPDAddress"));
    SelenideElement itemNextOfKin = $(byId("bcPDNoK"));
    SelenideElement itemTravel = $(byId("bcPDTravel"));
    SelenideElement itemCertificates = $(byId("bcPDCompetence"));
    SelenideElement itemMedical = $(byId("bcPDMedical"));
    SelenideElement itemEnclosedDocuments = $(byId("bcPDEnclosed"));

    SelenideElement ddlTimeAndAttendance = $(byId("bcTileTAA"));
    SelenideElement itemMyTimesheets = $(byId("bcTileTAAMyTimesheets"));
    SelenideElement itemCoWorkersTimesheets = $(byId("bcTileTAACoWorkersTimesheets"));
    SelenideElement itemMessages = $(byId("bcTileTAAMessages"));

    SelenideElement ddlFlights = $(byId("bcTileFlightDetails"));
    SelenideElement ddlDayToDay = $(byId("bcTileD2D"));

    protected void moveToCurrentTimesheetUsingNavigationPanel(){
        ddlTimeAndAttendance.click();
        itemMyTimesheets.click();
    }

    protected void moveToPersonalDetails() {
        tileMyPersonalDetails.click();
    }

    protected void moveToMyFlights() {
        tileMyFlights.click();
    }

    protected void moveToDayToDayPlanning() {
        tileDayToDay.click();
    }

    protected void moveToTimeAndAttendance() { tileTimeAndAttendance.click(); }
}
