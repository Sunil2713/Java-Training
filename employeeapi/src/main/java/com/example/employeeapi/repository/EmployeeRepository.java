package com.example.employeeapi.repository;
 
import org.springframework.stereotype.Repository;
import com.example.employeeapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
 
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
 
}
 
 