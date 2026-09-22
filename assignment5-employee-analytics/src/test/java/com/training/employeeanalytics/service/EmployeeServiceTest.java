package com.training.employeeanalytics.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.training.employeeanalytics.model.Employee;
import com.training.employeeanalytics.util.DataProvider;

public class EmployeeServiceTest {
    private EmployeeService service;
    private List<Employee> employees;

    @Before
    public void setUp() {
        service = new EmployeeService();
        employees = DataProvider.getEmployees();
    }

    @Test public void hasFifteenEmployees() { assertEquals(15, service.employeeCount(employees)); }
    @Test public void findsEmployeeByIdWithLoop() { assertEquals("Meena", service.findEmployeeByIdLoop(employees, 108).getName()); }
    @Test public void findsEmployeeByIdWithStream() { assertEquals("Ravi", service.findEmployeeByIdStream(employees, 101).get().getName()); }
    @Test public void missingEmployeeReturnsEmptyOptional() { assertFalse(service.findEmployeeByIdStream(employees, 999).isPresent()); }
    @Test public void findsUniqueLocations() { assertEquals(5, service.uniqueLocations(employees).size()); }
    @Test public void createsEmployeeMap() { assertEquals("Vijay", service.findEmployee(service.employeeMap(employees), 113).getName()); }
    @Test public void filtersSalaryAboveEightyThousand() { assertEquals(6, service.salaryGreaterThan(employees, 80000).size()); }
    @Test public void findsItEmployees() { assertEquals(6, service.employeesByDepartment(employees, "IT").size()); }
    @Test public void findsBangaloreEmployees() { assertEquals(6, service.employeesByLocation(employees, "Bangalore").size()); }
    @Test public void findsExperiencedEmployees() { assertEquals(6, service.experiencedEmployees(employees, 5).size()); }
    @Test public void mapsEmployeeNames() { assertEquals("Ravi", service.employeeNames(employees).get(0)); }
    @Test public void uppercasesNames() { assertEquals("RAVI", service.uppercaseNames(employees).get(0)); }
    @Test public void sortsHighestSalaryFirst() { assertEquals(125000.0, service.sortBySalaryDescending(employees).get(0).getSalary(), 0.0); }
    @Test public void calculatesTotalAndAverageSalary() { assertEquals(1168000.0, service.totalSalary(employees), 0.0); assertEquals(77866.66666666667, service.averageSalary(employees).get(), 0.001); }
    @Test public void findsHighestAndLowestSalaryEmployees() { assertEquals("Meena", service.highestSalaryEmployee(employees).get().getName()); assertEquals("Anjali", service.lowestSalaryEmployee(employees).get().getName()); }
    @Test public void groupsAndCountsByDepartment() { Map<String, Long> counts = service.countByDepartment(employees); assertEquals(Long.valueOf(6), counts.get("IT")); assertEquals(Long.valueOf(3), counts.get("HR")); }
    @Test public void partitionsExperiencedEmployees() { assertEquals(6, service.partitionByExperience(employees, 5).get(true).size()); assertEquals(9, service.partitionByExperience(employees, 5).get(false).size()); }
    @Test public void findsHighestPaidItAndSecondHighestDistinctSalary() { assertEquals("Meena", service.highestPaidItEmployee(employees).get().getName()); assertEquals("Vijay", service.secondHighestSalaryEmployee(employees).get().getName()); }
    @Test public void returnsTopThreeAndBusinessAnswers() { assertEquals(3, service.topHighestPaidEmployees(employees, 3).size()); assertEquals("IT", service.departmentWithHighestAverageSalary(employees).get()); assertEquals("Bangalore", service.locationWithMostEmployees(employees).get()); }
    @Test public void validatesBonusOperations() { assertTrue(service.anyEmployeeEarnsMoreThan(employees, 100000)); assertTrue(service.allEmployeesHaveAtLeastExperience(employees, 2)); assertTrue(service.employeeNamedExists(employees, "ravi")); assertEquals(537000.0, service.totalSalaryForIt(employees), 0.0); }
}
