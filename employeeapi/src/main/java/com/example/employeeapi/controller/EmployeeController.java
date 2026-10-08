package com.example.employeeapi.controller;
 
import com.example.employeeapi.model.Employee;
import com.example.employeeapi.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {
 
   private final EmployeeService employeeService;
 
   public EmployeeController(EmployeeService employeeService) {
       this.employeeService = employeeService;
   }
 
   // Add employee
   @PostMapping
   public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
       Employee savedEmployee = employeeService.addEmployee(employee);
       return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
   }
 
   // Get all employees
   @GetMapping
   public ResponseEntity<List<Employee>> getAllEmployees() {
       List<Employee> employees = employeeService.getAllEmployees();
       return new ResponseEntity<>(employees, HttpStatus.OK);
   }
 
   // Get employee by ID
   @GetMapping("/{id}")
   public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
       Employee employee = employeeService.getEmployeeById(id);
       return new ResponseEntity<>(employee, HttpStatus.OK);
   }
 
   // Update employee
   @PutMapping("/{id}")
   public ResponseEntity<Employee> updateEmployee(@PathVariable int id,
                                                  @RequestBody Employee employeeDetails) {
       Employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
       return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
   }
 
   // Delete employee
   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
       employeeService.deleteEmployee(id);
       return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
   }
}