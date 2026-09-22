package com.training.employeeanalytics.app;

import java.util.List;

import com.training.employeeanalytics.model.Employee;
import com.training.employeeanalytics.service.EmployeeService;
import com.training.employeeanalytics.util.DataProvider;

public class EmployeeAnalyticsApp {
    public static void main(String[] args) {
        List<Employee> employees = DataProvider.getEmployees();
        EmployeeService service = new EmployeeService();

        System.out.println("All Employees:");
        employees.forEach(System.out::println);

        System.out.println("\nFind ID 108 using loop: " + service.findEmployeeByIdLoop(employees, 108));
        System.out.println("Find ID 108 using stream: " + service.findEmployeeByIdStream(employees, 108).orElse(null));
        System.out.println("Unique Locations: " + service.uniqueLocations(employees));
        System.out.println("Employees earning above 80000: " + service.salaryGreaterThan(employees, 80000));
        System.out.println("IT Employees: " + service.employeesByDepartment(employees, "IT"));
        System.out.println("Uppercase Names: " + service.uppercaseNames(employees));
        System.out.println("Top 3 Highest Paid: " + service.topHighestPaidEmployees(employees, 3));
        System.out.println("Second Highest Distinct Salary Employee: " + service.secondHighestSalaryEmployee(employees).orElse(null));
        System.out.println("Highest Paid IT Employee: " + service.highestPaidItEmployee(employees).orElse(null));
        System.out.println("Employee Ravi exists: " + service.employeeNamedExists(employees, "Ravi"));
        System.out.println("Comma-separated Names: " + service.commaSeparatedNames(employees));

        service.generateEmployeeReport(employees);
    }
}
