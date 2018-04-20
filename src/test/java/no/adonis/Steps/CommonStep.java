package no.adonis.Steps;

import cucumber.api.Scenario;
import no.adonis.Helpers.APP;
import no.adonis.Timeregistrations.Timeregistration;
import no.adonis.Timeregistrations.TimeregistrationFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommonStep {
    protected APP app;
    protected Map<String, Timeregistration> timeregistrations;
    protected Scenario scenario;
    protected Logger log;

    public CommonStep() {
        app = new APP();
        timeregistrations = TimeregistrationFactory.getTimeregistrations();
        log  = Logger.getLogger(this.getClass().getSimpleName());
    }

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        log.info(scenario.getName() + " is running");
    }

    @After
    public void tearDown() {
        log.info("Test case execution was finished");
    }
    @BeforeClass
    public static void Up() {
        List<String> properties = new ArrayList<>();
        properties.add("Enviroment=dev_enviromet");
        properties.add("test_property=add your own information");

        Path allureResults = null;
        try {
            allureResults = Paths.get(ClassLoader.getSystemResource("").toURI()).getParent();
            allureResults = Paths.get(allureResults.toAbsolutePath().toString(), "../allure-results", "environment.properties");
            if (!Files.exists(allureResults.getParent())) {
                Files.createDirectories(allureResults.getParent());
            }
            Files.write(allureResults, properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public static void Down() {

    }
}
