package no.adonis.Users;

import org.joda.time.DateTime;

public class Employee {
    private int pin;
    private String firstName;
    private String lasttName;
    private DateTime birthDate;
    private DateTime employeeStartDate;
    private DateTime employeeEndDate;
    private String email;

    public Employee(int pin, String firstName, String lasttName, DateTime birthDate,
                    DateTime employeeStartDate, DateTime employeeEndDate, String email) {
        this.pin = pin;
        this.firstName = firstName;
        this.lasttName = lasttName;
        this.birthDate = birthDate;
        this.employeeStartDate = employeeStartDate;
        this.employeeEndDate = employeeEndDate;
        this.email = email;
    }

    public int getPin() {
        return pin;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLasttName() {
        return lasttName;
    }

    public DateTime getBirthDate() {
        return birthDate;
    }

    public DateTime getEmployeeStartDate() {
        return employeeStartDate;
    }

    public DateTime getEmployeeEndDate() {
        return employeeEndDate;
    }

    public String getEmail() {
        return email;
    }
}


