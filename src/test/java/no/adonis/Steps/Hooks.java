package no.adonis.Steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import no.adonis.Utils.SQLUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Properties;

public class Hooks extends CommonStep {
    private static boolean flag = false;

    @Before()
    public void beforeScenario(Scenario scenario) {
//        Constants.EMAIL_NAME = RandomUtils.getRandomMail();

        if (!flag) {

            Properties prop = new Properties();

            //Need to implement functionality which will pick up datetime format from database
            DateTimeFormatter dtf = DateTimeFormat.forPattern(SQLUtils.getDateTimeFormat());

            prop.setProperty("date", SQLUtils.getDateTimeFormat());

            SQLUtils.cleanTimezones();
            SQLUtils.cleanTimesheetPeriods();
            SQLUtils.cleanActivities();
            SQLUtils.cleanEmployees();

            /*
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MMMMM.dd GGG hh:mm aaa", Locale.getDefault());
            Date date = new Date();
            prop.setProperty("date", formatter.format(date));
            prop.setProperty("version", RestUtils.getVersion());
            prop.setProperty("browser", System.getProperty("browser"));
            prop.setProperty("browserVersion", System.getProperty("browser_version"));
            prop.setProperty("os", System.getProperty("os"));
            prop.setProperty("osVersion", System.getProperty("os_version"));
            prop.setProperty("url", Constants.BASE_URL);

            prop.setProperty("country",  System.getProperty("Country"));
            prop.setProperty("settings",  RestUtils.getCountryLocaleSettings(System.getProperty("Country")).toString());
            try (OutputStream output = new FileOutputStream("config.properties")) {
                prop.store(output, null);
            } catch (IOException e) {
                e.printStackTrace();
            }*/
//            flag = true;
        }

        myScenario = scenario;
        log.info("*****************NEW SCENARIO*************************");

        app.base.startApp();

        log.info("----------------------------------------------");
        log.info("Scenario started - " + scenario.getName());
        log.info("----------------------------------------------\n");
    }

    @After()
    public void afterScenario() {
        String scenarioStatus = "Scenario status - " + myScenario.getStatus().toUpperCase();
        log.info("----------------------------------------------");
        myScenario.write(scenarioStatus);
//        String id = System.getProperty("ID") != null ? System.getProperty("ID") : "null";
//        myScenario.write("<div align='center' style='word-wrap: break-word'> Session ID - " + id + "</div>");
//        app.common.appTakeScreenshot(myScenario);
        log.info("----------------------------------------------");
        log.info("*****************SCENARIO END*************************\n\n");
        app.base.appStop();
    }
}

//Need to check
//Copied Iaroslav's hooks

    /*
    public class Hooks extends BaseSteps {
        private static boolean flag = false;

        @Before()
        public void beforeScenario(Scenario scenario) {
            Constants.EMAIL_NAME = RandomUtils.getRandomMail();
            myScenario = scenario;
            log.info("*****************NEW SCENARIO*************************");
            app.common.appStart(app);
            patients.clear();
            archivedPatientsList.clear();
            clinicUsers.clear();
            activeClinicUsers.clear();
            suspendedClinicUsers.clear();
            temporaryValues.clear();
            report.clear();
            daysSelected.clear();
            validClinic = ClinicFactory.getValidClinic();
            clinicUser = ClinicUserFactory.getValidClinicUserNotAdmin();

            for (ReportType type : ReportType.values()) {
                applicableReports.put(type, false);
                reportsSelected.put(type, false);
                favoriteReports.put(type, false);
            }

            //for report Living plugin
            if (!flag) {

                Properties prop = new Properties();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MMMMM.dd GGG hh:mm aaa", Locale.getDefault());
                Date date = new Date();
                prop.setProperty("version", RestUtils.getVersion());
                prop.setProperty("browser", System.getProperty("browser"));
                prop.setProperty("browserVersion", System.getProperty("browser_version"));
                prop.setProperty("os", System.getProperty("os"));
                prop.setProperty("osVersion", System.getProperty("os_version"));
                prop.setProperty("url", Constants.BASE_URL);
                prop.setProperty("date", formatter.format(date));
                prop.setProperty("country",  System.getProperty("Country"));
                prop.setProperty("settings",  RestUtils.getCountryLocaleSettings(System.getProperty("Country")).toString());
                try (OutputStream output = new FileOutputStream("config.properties")) {
                    prop.store(output, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                flag = true;
            }
            log.info("----------------------------------------------");
            log.info("Scenario started - " + scenario.getName());
            log.info("----------------------------------------------\n");
        }

        @After()
        public void afterScenario() {
            String scenarioStatus = "Scenario status - " + myScenario.getStatus().toUpperCase();
            log.info("----------------------------------------------");
            myScenario.write(scenarioStatus);
            String id = System.getProperty("ID") != null ? System.getProperty("ID") : "null";
            myScenario.write("<div align='center' style='word-wrap: break-word'> Session ID - " + id + "</div>");
            app.common.appTakeScreenshot(myScenario);
            log.info("----------------------------------------------");
            log.info("*****************SCENARIO END*************************\n\n");
            app.common.appStop();
        }
    }*/