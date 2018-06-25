package no.adonis.DataTypes.Users;

import org.joda.time.DateTime;

public class Employee {
    private int pin;
    private String firstName;
    private String lastName;
    private DateTime birthDate;
    private DateTime employeeStartDate;
    private DateTime employeeEndDate;
    private String email;

    public Employee(int pin, String firstName, String lastName, DateTime birthDate,
                    DateTime employeeStartDate, DateTime employeeEndDate, String email) {
        this.pin = pin;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getLastName() {
        return lastName;
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

    @Override
    public String toString() {
        return "Employee{" +
                "pin=" + pin +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", employeeStartDate=" + employeeStartDate +
                ", employeeEndDate=" + employeeEndDate +
                ", email='" + email + '\'' +
                '}';
    }
}


