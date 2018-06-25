package no.adonis.DataTypes.UserSettings;

import no.adonis.DataTypes.Users.Employee;

public class UserSettings {
    private Employee employee;
    private boolean workDaysIs5;
    private int startWorkHour;
    private int endWorkHour;
    private boolean displayWorktimeOnly;
    private boolean displayTimeslots;

    public UserSettings(Employee employee, boolean workDaysIs5, int startWorkHour, int endWorkHour, boolean displayWorktimeOnly, boolean displayTimeslots) {
        this.employee = employee;
        this.workDaysIs5 = workDaysIs5;
        this.startWorkHour = startWorkHour;
        this.endWorkHour = endWorkHour;
        this.displayWorktimeOnly = displayWorktimeOnly;
        this.displayTimeslots = displayTimeslots;
    }

    public Employee getEmployee() {
        return employee;
    }

    public boolean isWorkDaysIs5() {
        return workDaysIs5;
    }

    public int getStartWorkHour() {
        return startWorkHour;
    }

    public int getEndWorkHour() {
        return endWorkHour;
    }

    public boolean isDisplayWorktimeOnly() {
        return displayWorktimeOnly;
    }

    public boolean isDisplayTimeslots() {
        return displayTimeslots;
    }

    @Override
    public String toString() {
        return "UserSettings{" +
                "employee=" + employee +
                ", workDaysIs5=" + workDaysIs5 +
                ", startWorkHour=" + startWorkHour +
                ", endWorkHour=" + endWorkHour +
                ", displayWorktimeOnly=" + displayWorktimeOnly +
                ", displayTimeslots=" + displayTimeslots +
                '}';
    }
}
