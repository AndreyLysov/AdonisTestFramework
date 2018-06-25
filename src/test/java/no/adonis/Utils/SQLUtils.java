package no.adonis.Utils;

import no.adonis.DataTypes.Activity.Activity;
import no.adonis.DataTypes.Activity.ActivityCode;
import no.adonis.Common.Constants;
import no.adonis.DataTypes.PWORG.PWORG;
import no.adonis.DataTypes.Role.Role;
import no.adonis.DataTypes.TimesheetPeriod.TimesheetPeriod;
import no.adonis.DataTypes.Timezones.Timezone;
import no.adonis.DataTypes.UserGroup.UserGroup;
import no.adonis.DataTypes.UserSettings.UserSettings;
import no.adonis.DataTypes.Users.Employee;
import no.adonis.DataTypes.Worktypes.Worktype;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringJoiner;
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

    public static String getTimeFormat() {
        TableModel tm = getFromDB("SELECT case when (select top 1 value from web_cp_settings2 where code = 'udf') = 'False' " +
                "then (select top 1 value from web_cp_settings2 where code = 'stf') else NULL end as 'Time'");
        if (tm == null) {
            return DateTimeFormat.shortTime().toString();
        } else {
            return String.valueOf(tm.getValueAt(0, 0));
        }
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

        executeScript("INSERT INTO PW001P0P (PIN, STARTDATE, PNUMBER, SEQUENCENO, CREATETIME) " +
                "VALUES (" +
                employee.getPin() + ", '" +
                dfOut.print(employee.getEmployeeStartDate()) + "', " +
                "'A', " +
                employee.getPin() + ", " +
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
        cleanUserSettings();
        executeScript("DELETE FROM PW001P0P");
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

    //    PAYSCALETABLE = PSC1; PAYSCALE = PSCODE
    public static void createActivity(Activity activity) {
        executeScript("INSERT INTO PW001P03 (PIN, CREATEDBY, CREATETIME, SEQUENCENO, CODE, DATEFROM, DATETO, " +
                "VESSEL, VESSELNAME, RANK, NUMORGID, PLANNED) " +
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

    public static void createTimezone(Timezone timezone) {
        executeScript("INSERT INTO WEB_CP_TIMEZONES (ID, NUMORGID, CHANGE_DATE, TIMEZONE, CHANGE_DATE_UTC) " +
                "VALUES (" +
                Randomizer.getRandomInt() + ", " +
                timezone.getVessel().getNumorgId() + ", '" +
                dtfOut.print(timezone.getChangeDate()) + "', " +
                timezone.getTimezoneOffset() + ", '" +
                dtfOut.print(timezone.getChangeDateUTC()) + "')");
    }

    public static void createTimesheetPeriod(TimesheetPeriod tsPeriod) {
        executeScript("INSERT INTO WEB_CP_TIMESHEETS_PERIOD (SEQUENCENO, PERIOD, NAME, PERIOD_FROM, PERIOD_TO, NUMORGID) " +
                "VALUES (" +
                Randomizer.getRandomInt() + ", " +
                tsPeriod.getPeriod() + ", '" +
                tsPeriod.getName() + "', '" +
                dfOut.print(tsPeriod.getDateFrom()) + "', '" +
                dfOut.print(tsPeriod.getDateTo()) + "', " +
                tsPeriod.getVessel().getNumorgId() + ")");
    }

    public static void createWorktype(Worktype worktype) {
        executeScript("INSERT INTO WEB_CP_WORKTYPES (SEQUENCENO, CODE, NAME, NUMORGID, IS_WORK, IS_DRILL, IS_REST, " +
                "IS_MEAL, IS_SIDE_DUTY, IS_SICK, IS_WORKANDREST, HideInTimeClock, HideInManual, NonOT) " +
                "VALUES (" +
                Randomizer.getRandomInt() + ", '" +
                worktype.getCode() + "', '" +
                worktype.getName() + "', " +
                worktype.getVessel().getNumorgId() + ", '" +
                (worktype.isWork() ? "Y" : "N") + "', '" +
                (worktype.isDrill() ? "Y" : "N") + "', '" +
                (worktype.isRest() ? "Y" : "N") + "', '" +
                (worktype.isMeal() ? "Y" : "N") + "', '" +
                (worktype.isSideDuty() ? "Y" : "N") + "', '" +
                (worktype.isSick() ? "Y" : "N") + "', '" +
                (worktype.isWorkAndRest() ? "Y" : "N") + "', " +
                (worktype.isHideInTimeclock() ? 1 : 0) + ", " +
                (worktype.isHideInManual() ? 1 : 0) + ", " +
                (worktype.isNonOT() ? 1 : 0) + ")");
    }

    public static void createRole(Role role) {
        executeScript("INSERT INTO WEB_CP_ROLES (ROLE_ID, ROLE) VALUES (" +
                role.getSequenceno() + ", '" +
                role.getName() + "')");
    }

    public static void cleanRoles() {
        executeScript("DELETE FROM WEB_CP_ROLE_ACCESS");
        executeScript("DELETE FROM WEB_CP_ROLES");
    }

    public static void addAccessToModules(Role role, String modules) {
        StringJoiner joiner = new StringJoiner("','", "'", "'");
        for (String module : modules.split(";")) {
            joiner.add(module);
        }

        TableModel table = getFromDB("SELECT ELEMENT_ID FROM WEB_CP_ELEMENTS WHERE CAPTION IN (" + joiner + ")");

        ArrayList<Integer> moduleNumbers = new ArrayList<>();
        for (int i = 0; i < table.getRowCount(); i++) {
            moduleNumbers.add(Integer.parseInt(String.valueOf(table.getValueAt(i, 0))));
        }

        for (Integer module :
                moduleNumbers) {
            executeScript("INSERT INTO WEB_CP_ROLE_ACCESS (ROLE_ID, ELEMENT_ID, MODIFY) " +
                    "VALUES (" +
                    role.getSequenceno() + ", " +
                    module + ", " +
                    "'W')");
        }
    }

    public static void createUserGroup(UserGroup ug) {
        executeScript("INSERT INTO WEB_CP_USERGROUP (USERGROUPID, CAPTION) VALUES (" +
                ug.getSequenceno() + ", '" +
                ug.getName() + "')");
    }

    public static void linkPositionToUserGroup(UserGroup ug, PWORG position) {
        executeScript("INSERT INTO WEB_CP_USERGROUP_POSITION (USERGROUPID, POSITION_NUMORGID) VALUES (" +
                ug.getSequenceno() + ", " +
                position.getNumorgId() + ")");
    }

    public static void cleanUserGroups() {
        executeScript("DELETE FROM WEB_CP_USERGROUP_POSITION");
        executeScript("DELETE FROM WEB_CP_USERGROUP");
    }

    public static void linkUserGroupToRole(UserGroup ug, Role role) {
        executeScript("INSERT INTO WEB_CP_USERGROUP_ROLE (ROLE_ID, USERGROUPID, PARENT_USERGROUPID) VALUES (" +
                role.getSequenceno() + ", " +
                ug.getSequenceno() + ", " +
                "0)");
    }

    public static void cleanLinkBetweenUserGroupAndRole() {
        executeScript("DELETE FROM WEB_CP_USERGROUP_ROLE");
    }

    public static void setUserSettings(UserSettings userSettings) {
        executeScript("INSERT INTO WEB_CP_USER_SETTINGS (PIN, TAA_WORKDAYS, TAA_WORKSTART, TAA_WORKEND, " +
                "TAA_WORKTIME_ONLY, TAA_TIMESLOTS_ONLY) " +
                "VALUES (" +
                userSettings.getEmployee().getPin() + ", " +
                (userSettings.isWorkDaysIs5() ? 5 : 7) + ", " +
                userSettings.getStartWorkHour() + ", " +
                userSettings.getEndWorkHour() + ", " +
                (userSettings.isDisplayWorktimeOnly() ? 1 : 0) + ", " +
                (userSettings.isDisplayTimeslots() ? 1 : 0) +
                ")"
        );
    }

    public static void cleanUserSettings() {
        executeScript("DELETE FROM WEB_CP_USER_SETTINGS");
    }
}
