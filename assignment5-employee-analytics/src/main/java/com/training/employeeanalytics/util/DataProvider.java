package com.training.employeeanalytics.util;

import java.util.ArrayList;
import java.util.List;

import com.training.employeeanalytics.model.Employee;

public final class DataProvider {
    private DataProvider() { }

    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(101, "Ravi", "IT", "Developer", 75000, 5, "Bangalore"));
        employees.add(new Employee(102, "Priya", "HR", "Manager", 85000, 8, "Chennai"));
        employees.add(new Employee(103, "Amit", "IT", "Senior Developer", 95000, 8, "Bangalore"));
        employees.add(new Employee(104, "Sneha", "Finance", "Analyst", 65000, 4, "Mumbai"));
        employees.add(new Employee(105, "Rahul", "IT", "Developer", 70000, 4, "Hyderabad"));
        employees.add(new Employee(106, "Anjali", "HR", "Executive", 55000, 3, "Bangalore"));
        employees.add(new Employee(107, "Kiran", "Finance", "Manager", 90000, 9, "Chennai"));
        employees.add(new Employee(108, "Meena", "IT", "Architect", 125000, 12, "Bangalore"));
        employees.add(new Employee(109, "Arjun", "Sales", "Executive", 60000, 3, "Mumbai"));
        employees.add(new Employee(110, "Divya", "IT", "Developer", 72000, 5, "Pune"));
        employees.add(new Employee(111, "Suresh", "Sales", "Manager", 88000, 10, "Bangalore"));
        employees.add(new Employee(112, "Neha", "HR", "Executive", 58000, 2, "Hyderabad"));
        employees.add(new Employee(113, "Vijay", "IT", "Senior Developer", 100000, 9, "Pune"));
        employees.add(new Employee(114, "Pooja", "Finance", "Analyst", 68000, 5, "Bangalore"));
        employees.add(new Employee(115, "Manoj", "Sales", "Executive", 62000, 4, "Chennai"));
        return employees;
    }
}
