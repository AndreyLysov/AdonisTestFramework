package no.adonis.Steps;

import cucumber.api.Scenario;
import no.adonis.Activity.ActivityCode;
import no.adonis.Helpers.APP;
import no.adonis.PWORG.PWORG;
import no.adonis.Users.Employee;
import no.adonis.Users.EmployeeFactory;
import no.adonis.Utils.ExcelUtils;
import no.adonis.Utils.SQLUtils;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.stream.Collectors;

public class CommonStep {
    protected APP app;

    protected Scenario myScenario;
    protected Logger log;
    protected Map<String, Employee> employees;
    private Map<String, PWORG> pworgs;
    protected Map<String, PWORG> vessels;
    protected Map<String, PWORG> departments;
    protected Map<String, PWORG> positions;
    protected Map<String, ActivityCode> activityCodes;

    public CommonStep() {
        app = new APP();
        employees = EmployeeFactory.getEmployees();
        log = Logger.getLogger(this.getClass().getSimpleName());
        pworgs = SQLUtils.getPWORGS();
        vessels = pworgs.entrySet()
                .stream()
                .filter(s -> s.getValue().getOrgType() == 3)
                .collect(Collectors.toMap(s -> s.getKey(), s -> s.getValue()));
        departments = pworgs.entrySet()
                .stream()
                .filter(s -> s.getValue().getOrgType() == 4)
                .collect(Collectors.toMap(s -> s.getKey(), s -> s.getValue()));
        positions = pworgs.entrySet()
                .stream()
                .filter(s -> s.getValue().getOrgType() == 5)
                .collect(Collectors.toMap(s -> s.getKey(), s -> s.getValue()));
        activityCodes = SQLUtils.getActivityCodes();
    }



    /*
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
    */

}

//test push




/*

Given "<Employee>" is created
    And "<Employee>" has onboard activity on "<PWORG>" vessel on "<Position>" position
    And "<PWORG>" is on "+0" timezone from "previous year"
    And period for "current" month is created
    And worktype "Work" is exist on the "<PWORG>" vessel
    |IsWork|
    And "<Position>" linked to "User Group" linked to "Roles" with access to all modules
    And "<Position>" is set as "subordinator" in COA settings
    And "ACP" is opened
    And "<Employee>" is logged in
    And "My Timesheet" page is opened

  Scenario: Add time registration
    When create "time registration"
    Then "time registration" is displayed

  Examples:
  |PWORG|Position|Employee|
  |Vessel1|Seaman|Bart Simpson|

*/


/*



 */