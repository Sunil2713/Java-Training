package com.example.employeeapi.service;
 
import com.example.employeeapi.exception.ResourceNotFoundException;
import com.example.employeeapi.model.Employee;
import com.example.employeeapi.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service
public class EmployeeService {
 
   private final EmployeeRepository employeeRepository;
 
   public EmployeeService(EmployeeRepository employeeRepository) {
       this.employeeRepository = employeeRepository;
   }
 
   public Employee addEmployee(Employee employee) {
       return employeeRepository.save(employee);
   }
 
   public List<Employee> getAllEmployees() {
       return employeeRepository.findAll();
   }
 
   public Employee getEmployeeById(int id) {
       return employeeRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
   }
 
   public Employee updateEmployee(int id, Employee employeeDetails) {
 
       Employee existingEmployee = employeeRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
 
       existingEmployee.setEmpName(employeeDetails.getEmpName());
       existingEmployee.setSalary(employeeDetails.getSalary());
       existingEmployee.setDepartment(employeeDetails.getDepartment());
 
       return employeeRepository.save(existingEmployee);
   }
 
   public void deleteEmployee(int id) {
 
       Employee existingEmployee = employeeRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
 
       employeeRepository.delete(existingEmployee);
   }
}