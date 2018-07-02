package no.adonis.Pages.ACP.TimeAndAttendance;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public interface RegistrationDetailsPage {

    SelenideElement btnSelectedDay = $(byId("btnSelectedDate"));
    SelenideElement dayNavigator = $(byId("deSchedulerDate"));
    SelenideElement btnAdd= $(byId("btnDailyNew"));
    SelenideElement btnEdit= $(byId("btnDailyEdit"));
    SelenideElement btnDelete = $(byId("btnDailyDelete"));
}
