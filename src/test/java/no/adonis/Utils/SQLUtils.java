package no.adonis.Utils;

import no.adonis.Activity.Activity;
import no.adonis.Activity.ActivityCode;
import no.adonis.Common.Constants;
import no.adonis.PWORG.PWORG;
import no.adonis.TimesheetPeriod.TimesheetPeriod;
import no.adonis.Timezones.Timezone;
import no.adonis.Users.Employee;
import no.adonis.Worktypes.Worktype;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.HashMap;
import java.util.Vector;

public class SQLUtils {

    private static String connectionString = Constants.CONNECTION_STRING;
    private static DateTimeFormatter dfOut = DateTimeFormat.forPattern("yyyy-MM-dd");
    private static DateTimeFormatter dtfOut = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");

    private static void executeScript(String script) {
        try (Connection connection = DriverManager.getConnection(connectionString);
             Statement statement = connection.createStatement();) {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            statement.execute(script);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static TableModel getFromDB(String script) {
        ResultSet rs = null;
        try (Connection connection = DriverManager.getConnection(connectionString);
             Statement statement = connection.createStatement();) {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            rs = statement.executeQuery(script);
            return resultSetToTableModel(rs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void insertOrUpdateData(String script) {
        try (Connection connection = DriverManager.getConnection(connectionString);
             Statement statement = connection.createStatement();) {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            statement.executeQuery(script);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static TableModel resultSetToTableModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();

            // Get the column names
            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
            }

            // Get all rows.
            Vector rows = new Vector();

            while (rs.next()) {
                Vector newRow = new Vector();

                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }

                rows.addElement(newRow);
            }

            return new DefaultTableModel(rows, columnNames);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getDateTimeFormat() {
        TableModel result = getFromDB("select " +
                "case when (select top 1 value from web_cp_settings2 where code = 'udf') = 'False' then " +
                "(select top 1 value from web_cp_settings2 where code = 'sdf') + ' ' + " +
                "(select top 1 value from web_cp_settings2 where code = 'stf') " +
                "else NULL " +
                "end as 'DateTime'");
        if (result == null)
            return DateTimeFormat.shortDateTime().toString();
        else
            return String.valueOf(result.getValueAt(0, 0));
    }

    public static HashMap<String, Worktype> getWorktypes() {
        HashMap<String, Worktype> worktypes = new HashMap<>();
        TableModel table = getFromDB("select NAME, SEQUENCENO, NUMORGID, IS_WORK, IS_DRILL, " +
                "IS_REST, IS_MEAL, IS_SICK, IS_SIDE_DUTY, IS_WORKANDREST, " +
                "HideInTimeClock, HideInManual, NonOT from WEB_CP_WORKTYPES");
        for (int i = 1; i < table.getRowCount(); i++) {
            worktypes.put(String.valueOf(table.getValueAt(i, 0)),
                    new Worktype(
                            String.valueOf(table.getValueAt(i, 0)),
                            Integer.getInteger(String.valueOf(table.getValueAt(i, 1))),
                            Integer.getInteger(String.valueOf(table.getValueAt(i, 2))),
                            Boolean.valueOf(String.valueOf(table.getValueAt(i, 3))),
                            Boolean.valueOf(String.valueOf(table.getValueAt(i, 4))),
                            Boolean.valueOf(String.valueOf(table.getValueAt(i, 5))),
                            Boolean.valueOf(String.valueOf(table.getValueAt(i, 6))),
                            Boolean.valueOf(String.valueOf(table.getValueAt(i, 7))),
                            Boolean.valueOf(String.valueOf(table.getValueAt(i, 8))),
                            Boolean.valueOf(String.valueOf(table.getValueAt(i, 9))),
                            Boolean.valueOf(String.valueOf(table.getValueAt(i, 10))),
                            Boolean.valueOf(String.valueOf(table.getValueAt(i, 11))),
                            Boolean.valueOf(String.valueOf(table.getValueAt(i, 12)))
                    )
            );
        }
        return worktypes;
    }

    public static void createEmployee(Employee employee) {
        executeScript("INSERT INTO PW001P01 (FIRSTNAME, LASTNAME, PIN, EMPLOYMENTSTARTDATE, BIRTHDATE, " +
                "CREATEDBY, CREATETIME, SEQUENCENO) VALUES ('" +
                employee.getFirstName() + "', '" +
                employee.getLastName() + "', " +
                employee.getPin() + ", '" +
                dfOut.print(employee.getEmployeeStartDate()) + "', '" +
                dfOut.print(employee.getBirthDate()) + "', " +
                "'ATF', '" +
                dfOut.print(DateTime.now()) + "', " +
                employee.getPin() + ")");

        //Users will be created with password '1' by default
        executeScript("INSERT INTO WEB_CP_ACCOUNT (PIN, USERID, PASSWORD, CREATEDBY, LASTNAME, FIRSTNAME, EMPLOYEE_PASSWORD, EMAIL, CREATETIME) " +
                "VALUES (" +
                employee.getPin() + ", '" +
                employee.getEmail() + "', " +
                "'C4CA4238A0B923820DCC509A6F75849B', " +
                "'ATF', '" +
                employee.getLastName() + "', '" +
                employee.getFirstName() + "', " +
                "'C4CA4238A0B923820DCC509A6F75849B', '" +
                employee.getEmail() + "', " +
                "GETDATE())");
    }

    public static HashMap<String, PWORG> getPWORGS() {
        HashMap<String, PWORG> pworgs = new HashMap<>();
        TableModel table = getFromDB("SELECT NAME, NUMORGID, ORGCODE, ORGTYPE FROM PWORG");
        for (int i = 1; i < table.getRowCount(); i++) {
            pworgs.put(String.valueOf(table.getValueAt(i, 0)),
                    new PWORG(String.valueOf(table.getValueAt(i, 0)),
                            Integer.valueOf(String.valueOf(table.getValueAt(i, 1))),
                            String.valueOf(table.getValueAt(i, 2)),
                            Integer.valueOf(String.valueOf(table.getValueAt(i, 3)))));
        }
        return pworgs;
    }

    public static void cleanTimeregistrations() {
        executeScript("DELETE FROM WEB_CP_TIMECARD");
    }

    public static void cleanEmployees() {
        executeScript("DELETE FROM WEB_CP_ACCOUNT WHERE PIN IS NOT NULL");
        executeScript("DELETE FROM PW001P01");
    }

    public static void cleanActivities() {
        executeScript("DELETE FROM PW001P03");
    }

    public static void cleanTimesheets() {
        executeScript("DELETE FROM WEB_CP_TIMESHEETS");
    }

    public static void cleanDocuments() {
        executeScript("DELETE FROM WEB_CP_DOCUMENTS");
    }

    public static void cleanDocumentsWorkflow() {
        executeScript("DELETE FROM WEB_CP_WORKFLOW");
    }

    public static void cleanWorktypes() {
        executeScript("DELETE FROM WEB_CP_WORKTYPES");
    }

    public static void cleanTimesheetPeriods() {
        executeScript("DELETE FROM WEB_CP_TIMESHEETS_PERIOD");
    }

    public static void cleanTimezones() {
        executeScript("DELETE FROM WEB_CP_TIMEZONES");
    }

    public static HashMap<String, ActivityCode> getActivityCodes() {
        HashMap<String, ActivityCode> codes = new HashMap<>();
        TableModel table = getFromDB("SELECT CODE, TEXT FROM PW001C12");
        for (int i = 1; i < table.getRowCount(); i++) {
            codes.put(String.valueOf(table.getValueAt(i, 1)),
                    new ActivityCode(String.valueOf(table.getValueAt(i, 1)),
                            String.valueOf(table.getValueAt(i, 0))));
        }
        return codes;
    }

    public static void createActivity(Activity activity) {
        executeScript("INSERT INTO PW001P03 (PIN, CREATEDBY, CREATETIME, SEQUENCENO, CODE, DATEFROM, DATETO, VESSEL, VESSELNAME, RANK, NUMORGID, PLANNED) " +
                "VALUES ( " +
                activity.getEmployee().getPin() + ", " +
                "'ATF', " +
                "GETDATE(), " +
                Randomizer.getRandomInt() + ", '" +
                activity.getActivityCode().getCode() + "', '" +
                dfOut.print(activity.getDateFrom()) + "', " +
                "NULL, " +
                activity.getVessel().getNumorgId() + ", '" +
                activity.getVessel().getName() + "', '" +
                activity.getPosition().getOrgCode() + "', " +
                activity.getPosition().getNumorgId() + ", '" +
                (activity.isPlanned() ? "Y" : "N") + "')"
        );
    }

    public static void createTimezone(Timezone timezone){
        executeScript("INSERT INTO WEB_CP_TIMEZONES (ID, NUMORGID, CHANGE_DATE, TIMEZONE, CHANGE_DATE_UTC) " +
                "VALUES (" +
                Randomizer.getRandomInt() + ", " +
                timezone.getVessel().getNumorgId() + ", '" +
                dtfOut.print(timezone.getChangeDate()) + "', " +
                timezone.getTimezoneOffset() + ", '" +
                dtfOut.print(timezone.getChangeDateUTC()) + "')");
    }

    public static void createTimesheetPeriod(TimesheetPeriod tsPeriod){
        executeScript("INSERT INTO WEB_CP_TIMESHEETS_PERIOD (SEQUENCENO, PERIOD, NAME, PERIOD_FROM, PERIOD_TO, NUMORGID) " +
                "VALUES (" +
                Randomizer.getRandomInt() + ", " +
                tsPeriod.getPeriod() + ", '" +
                tsPeriod.getName() + "', '" +
                dfOut.print(tsPeriod.getDateFrom()) + "', '" +
                dfOut.print(tsPeriod.getDateTo()) + "', " +
                tsPeriod.getVessel().getNumorgId() + ")");
    }
}
