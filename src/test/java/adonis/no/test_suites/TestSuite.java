package adonis.no.test_suites;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "adonis.no.steps"
//        tags = "@Test"
)

public class TestSuite{
//    Leave me empty
}