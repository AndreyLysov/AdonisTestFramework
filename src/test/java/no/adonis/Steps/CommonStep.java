package no.adonis.Steps;

import cucumber.api.Scenario;
import no.adonis.DataTypes.Activity.ActivityCode;
import no.adonis.Helpers.APP;
import no.adonis.DataTypes.PWORG.PWORG;
import no.adonis.DataTypes.Role.Role;
import no.adonis.DataTypes.Timezones.Timezone;
import no.adonis.DataTypes.UserGroup.UserGroup;
import no.adonis.DataTypes.Users.Employee;
import no.adonis.DataTypes.Users.EmployeeFactory;
import no.adonis.Utils.SQLUtils;
import no.adonis.DataTypes.Worktypes.Worktype;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CommonStep {
    protected APP app;

    protected Scenario myScenario;
    protected Logger log;
    protected static Map<String, Employee> employees = EmployeeFactory.getEmployees();
    private static Map<String, PWORG> pworgs = SQLUtils.getPWORGS();;
    protected static Map<String, Worktype> worktypes = new HashMap<>();
    protected static Map<String, Timezone> timezones = new HashMap<>();

    protected static Map<String, PWORG> vessels = pworgs.entrySet()
            .stream()
            .filter(s -> s.getValue().getOrgType() == 3)
            .collect(Collectors.toMap(s -> s.getKey(), s -> s.getValue()));

    protected static Map<String, PWORG> departments = pworgs.entrySet()
            .stream()
            .filter(s -> s.getValue().getOrgType() == 4)
            .collect(Collectors.toMap(s -> s.getKey(), s -> s.getValue()));

    protected static Map<String, PWORG> positions = pworgs.entrySet()
            .stream()
            .filter(s -> s.getValue().getOrgType() == 5)
            .collect(Collectors.toMap(s -> s.getKey(), s -> s.getValue()));;

    protected static Map<String, ActivityCode> activityCodes = SQLUtils.getActivityCodes();;
    protected static Map<String, Role> roles = new HashMap<>();;
    protected static Map<String, UserGroup> userGroups = new HashMap<>();;

    public CommonStep() {
        app = new APP();
        log = Logger.getLogger(this.getClass().getSimpleName());
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