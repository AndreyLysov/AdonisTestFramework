package no.adonis.DataTypes.Users;

import no.adonis.Utils.ExcelUtils;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeFactory {


    public static Map<String, Employee> getEmployees() {
        List<List<String>> table = ExcelUtils.readExcel("Employees");

        Map<String, Employee> employees = new HashMap<>();

        table.stream().forEach(s -> employees.put(s.get(1) + " " + s.get(2), new Employee(
                (int)Double.parseDouble(s.get(0)),
                s.get(1),
                s.get(2),
                DateTime.parse(s.get(3)),
                DateTime.parse(s.get(4)),
                DateTime.parse(s.get(5)),
                s.get(6))));
        return employees;
    }

    public static Employee getEmployee(String name){
        Map<String, Employee> employees = getEmployees();
        return employees.get(name);
    }
}

