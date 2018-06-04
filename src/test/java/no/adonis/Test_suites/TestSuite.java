package no.adonis.Test_suites;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@RunWith(Cucumber.class)
@CucumberOptions(

        format = {
                "com.github.kirlionik.cucumberallure.AllureReporter",
                "json:target/reports.json",
                "html:target/reports",
                "pretty",
        },

        features = {"src/test/resources/features"},

        glue = {"no/adonis/Steps"},
        tags = {"~@Example"}
)

public class TestSuite{

}



/*
import com.medtronic.Pages.BasePage;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@RunWith(Cucumber.class)
@CucumberOptions(

        format = {
                "com.github.kirlionik.cucumberallure.AllureReporter",
                "json:target/reports.json",
                "html:target/reports",
                "pretty",
        },

        features = {
                "src/test/resources/Features/TC070ContactUs.feature"},
        glue = {"com/medtronic/Steps"},
        tags = {"~@ignored"}
)

public class TestRun extends BasePage {

    static public Properties prop = new Properties();
    private static OutputStream output = null;

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
 */