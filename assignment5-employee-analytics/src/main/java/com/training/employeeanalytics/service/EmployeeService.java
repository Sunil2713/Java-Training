package com.training.employeeanalytics.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.training.employeeanalytics.model.Employee;

public class EmployeeService {

    public Employee findEmployeeByIdLoop(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public Optional<Employee> findEmployeeByIdStream(List<Employee> employees, int id) {
        return employees.stream().filter(employee -> employee.getId() == id).findFirst();
    }

    public Set<String> uniqueLocations(List<Employee> employees) {
        return employees.stream().map(Employee::getLocation).collect(Collectors.toSet());
    }

    public Map<Integer, Employee> employeeMap(List<Employee> employees) {
        return employees.stream().collect(Collectors.toMap(Employee::getId, employee -> employee));
    }

    public Employee findEmployee(Map<Integer, Employee> employeesById, int id) {
        return employeesById.get(id);
    }

    public List<Employee> salaryGreaterThan(List<Employee> employees, double amount) {
        return employees.stream().filter(employee -> employee.getSalary() > amount).collect(Collectors.toList());
    }

    public List<Employee> employeesByDepartment(List<Employee> employees, String department) {
        return employees.stream().filter(employee -> employee.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }

    public List<Employee> employeesByLocation(List<Employee> employees, String location) {
        return employees.stream().filter(employee -> employee.getLocation().equalsIgnoreCase(location))
                .collect(Collectors.toList());
    }

    public List<Employee> experiencedEmployees(List<Employee> employees, int years) {
        return employees.stream().filter(employee -> employee.getExperience() > years).collect(Collectors.toList());
    }

    public List<String> employeeNames(List<Employee> employees) {
        return employees.stream().map(Employee::getName).collect(Collectors.toList());
    }

    public Set<String> uniqueDepartments(List<Employee> employees) {
        return employees.stream().map(Employee::getDepartment).collect(Collectors.toSet());
    }

    public List<String> uppercaseNames(List<Employee> employees) {
        return employees.stream().map(employee -> employee.getName().toUpperCase()).collect(Collectors.toList());
    }

    public List<Employee> sortBySalaryAscending(List<Employee> employees) {
        return employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).collect(Collectors.toList());
    }

    public List<Employee> sortBySalaryDescending(List<Employee> employees) {
        return employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).collect(Collectors.toList());
    }

    public List<Employee> sortByExperience(List<Employee> employees, boolean descending) {
        Comparator<Employee> comparator = Comparator.comparingInt(Employee::getExperience);
        if (descending) {
            comparator = comparator.reversed();
        }
        return employees.stream().sorted(comparator).collect(Collectors.toList());
    }

    public List<Employee> sortByDepartmentThenSalaryDescending(List<Employee> employees) {
        return employees.stream().sorted(Comparator.comparing(Employee::getDepartment)
                .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed())).collect(Collectors.toList());
    }

    public long employeeCount(List<Employee> employees) { return employees.stream().count(); }
    public Optional<Employee> highestSalaryEmployee(List<Employee> employees) { return employees.stream().max(Comparator.comparingDouble(Employee::getSalary)); }
    public Optional<Employee> lowestSalaryEmployee(List<Employee> employees) { return employees.stream().min(Comparator.comparingDouble(Employee::getSalary)); }
    public double totalSalary(List<Employee> employees) { return employees.stream().mapToDouble(Employee::getSalary).sum(); }
    public Optional<Double> averageSalary(List<Employee> employees) {
        java.util.OptionalDouble average = employees.stream().mapToDouble(Employee::getSalary).average();
        return average.isPresent() ? Optional.of(average.getAsDouble()) : Optional.empty();
    }

    public Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public Map<String, Long> countByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }

    public Map<String, Double> averageSalaryByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public Map<Boolean, List<Employee>> partitionByExperience(List<Employee> employees, int years) {
        return employees.stream().collect(Collectors.partitioningBy(employee -> employee.getExperience() > years));
    }

    public Optional<Employee> findEmployeeByName(List<Employee> employees, String name) {
        return employees.stream().filter(employee -> employee.getName().equalsIgnoreCase(name)).findFirst();
    }

    public Optional<Employee> highestPaidItEmployee(List<Employee> employees) {
        return employeesByDepartment(employees, "IT").stream().max(Comparator.comparingDouble(Employee::getSalary));
    }

    public Map<String, Employee> highestPaidEmployeeByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));
    }

    public List<Employee> employeesEarningAboveAverage(List<Employee> employees) {
        double average = averageSalary(employees).orElse(0.0);
        return employees.stream().filter(employee -> employee.getSalary() > average).collect(Collectors.toList());
    }

    public List<Employee> topHighestPaidEmployees(List<Employee> employees, int limit) {
        return sortBySalaryDescending(employees).stream().limit(limit).collect(Collectors.toList());
    }

    // Duplicate salaries are ignored: this returns an employee with the second distinct highest salary.
    public Optional<Employee> secondHighestSalaryEmployee(List<Employee> employees) {
        List<Double> salaries = employees.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder())
                .skip(1).limit(1).collect(Collectors.toList());
        if (salaries.isEmpty()) {
            return Optional.empty();
        }
        return employees.stream().filter(employee -> employee.getSalary() == salaries.get(0)).findFirst();
    }

    public Map<String, DoubleSummaryStatistics> departmentSalaryReport(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.summarizingDouble(Employee::getSalary)));
    }

    public List<Employee> namesStartingWith(List<Employee> employees, String prefix) {
        return employees.stream().filter(employee -> employee.getName().startsWith(prefix)).collect(Collectors.toList());
    }

    public List<Employee> salaryBetween(List<Employee> employees, double minimum, double maximum) {
        return employees.stream().filter(employee -> employee.getSalary() >= minimum && employee.getSalary() <= maximum)
                .collect(Collectors.toList());
    }

    public List<Employee> bangaloreExperiencedEmployees(List<Employee> employees) {
        return employees.stream().filter(employee -> employee.getLocation().equalsIgnoreCase("Bangalore"))
                .filter(employee -> employee.getExperience() > 5).collect(Collectors.toList());
    }

    public Optional<String> departmentWithHighestAverageSalary(List<Employee> employees) {
        return averageSalaryByDepartment(employees).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
    }

    public Optional<String> locationWithMostEmployees(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getLocation, Collectors.counting())).entrySet().stream()
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
    }

    public List<Employee> topItEmployeesBySalary(List<Employee> employees, int limit) {
        return employeesByDepartment(employees, "IT").stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(limit).collect(Collectors.toList());
    }

    public Set<String> uniqueDesignations(List<Employee> employees) { return employees.stream().map(Employee::getDesignation).collect(Collectors.toSet()); }
    public Optional<Employee> longestServingEmployee(List<Employee> employees) { return employees.stream().max(Comparator.comparingInt(Employee::getExperience)); }
    public double totalSalaryForIt(List<Employee> employees) { return employeesByDepartment(employees, "IT").stream().mapToDouble(Employee::getSalary).sum(); }
    public boolean anyEmployeeEarnsMoreThan(List<Employee> employees, double amount) { return employees.stream().anyMatch(employee -> employee.getSalary() > amount); }
    public boolean allEmployeesHaveAtLeastExperience(List<Employee> employees, int years) { return employees.stream().allMatch(employee -> employee.getExperience() >= years); }
    public boolean employeeNamedExists(List<Employee> employees, String name) { return employees.stream().anyMatch(employee -> employee.getName().equalsIgnoreCase(name)); }
    public String commaSeparatedNames(List<Employee> employees) { return employees.stream().map(Employee::getName).collect(Collectors.joining(", ")); }
    public Optional<Employee> firstEmployeeSalaryGreaterThan(List<Employee> employees, double amount) { return employees.stream().filter(employee -> employee.getSalary() > amount).findFirst(); }
    public Map<String, List<String>> departmentToEmployeeNames(List<Employee> employees) { return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList()))); }

    public void generateEmployeeReport(List<Employee> employees) {
        System.out.println("\n========== EMPLOYEE ANALYTICS DASHBOARD ==========");
        System.out.println("Total Employees: " + employeeCount(employees));
        System.out.printf("Average Salary: %.2f%n", averageSalary(employees).orElse(0.0));
        System.out.println("Highest Salary Employee: " + highestSalaryEmployee(employees).orElse(null));
        System.out.println("Lowest Salary Employee: " + lowestSalaryEmployee(employees).orElse(null));
        System.out.println("Employee Count by Department: " + countByDepartment(employees));
        System.out.println("Employee Count by Location: " + employees.stream().collect(Collectors.groupingBy(Employee::getLocation, Collectors.counting())));
        System.out.println("Employees with More Than 5 Years Experience: " + experiencedEmployees(employees, 5));
        System.out.println("Top 3 Highest Paid Employees: " + topHighestPaidEmployees(employees, 3));
        System.out.println("Average Salary by Department: " + averageSalaryByDepartment(employees));
        System.out.println("Department Salary Report:");
        departmentSalaryReport(employees).forEach((department, summary) -> System.out.printf("%s -> count=%d, total=%.2f, average=%.2f, min=%.2f, max=%.2f%n",
                department, summary.getCount(), summary.getSum(), summary.getAverage(), summary.getMin(), summary.getMax()));
    }
}
