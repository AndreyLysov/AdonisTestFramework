package no.adonis.Pages.ACP.TimeAndAttendance;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import no.adonis.DataTypes.Documents.Timesheet;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ACPOverviewPage extends ACPMyTimesheetPage implements AddEditTimeRegistrationForm {

    SelenideElement ddlTimesheetList = $(byId("RHOPcbTimesheets"));
    SelenideElement lnkDocumentState = $(byId("btDocState"));
    SelenideElement chckbxShowTimeSlots = $(byId("cbShowDetails_S_D"));
    ElementsCollection lnksEdit = $$(byXpath("//table[@class='dxgvControl_Metropolis dxgv']//tr//span[text()='Edit']"));
    SelenideElement lnkEditLast =
            $(byXpath("(//table[@class='dxgvControl_Metropolis dxgv']//tr//span[text()='Edit'])[last()]"));
    SelenideElement lnkPenultimateEdit =
            $(byXpath("(//table[@class='dxgvControl_Metropolis dxgv']//tr//span[text()='Edit'])[last()-1]"));

    protected void clickDocumentState(){
        lnkDocumentState.click();
    }

    protected void clickShowTimeSlots() {
        chckbxShowTimeSlots.click();
    }

    protected void selectTimesheet(Timesheet timesheet) {
        ddlTimesheetList.click();
        $(byXpath("//td[text()='" +
                timesheet.toString() +
                "']"))
                .click();
    }

    protected void openRegistrationDetailsForLastDay() {
        lnkEditLast.click();
    }

    protected void openRegistrationDetailsForPenultimateDay() {
        lnkPenultimateEdit.click();
    }

    protected void openRegistrationDetailsForDayNumber(int dayNumber) {
        lnksEdit.get(dayNumber-1).click();
    }
}
