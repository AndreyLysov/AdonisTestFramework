package no.adonis.Pages.ACP.TimeAndAttendance;

import com.codeborne.selenide.SelenideElement;
import no.adonis.Pages.ACP.ACPLoggedUserPage;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ACPMyTimesheetPage extends ACPLoggedUserPage {
    SelenideElement txtPageName = $(byXpath("//h3"));
    SelenideElement btnCurrent = $(byId("miTimeSheetMenu_DXI0_"));
    SelenideElement btnOverview = $(byXpath("miTimeSheetMenu_DXI1_"));
    SelenideElement btnPastDueAndRejected = $(byXpath("miTimeSheetMenu_DXI2_"));
    SelenideElement btnSubmitted = $(byXpath("miTimeSheetMenu_DXI3_"));
    SelenideElement ddlReports = $(byXpath("miTimeSheetMenu_DXI4_"));
}
