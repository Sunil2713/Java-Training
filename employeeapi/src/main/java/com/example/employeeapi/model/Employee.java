package com.example.employeeapi.model;
 
import jakarta.persistence.*;
 
@Entity
@Table(name="employees")
public class Employee {
 
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="emp_id")
private int empId;
@Column(name="emp_name")
private String empName;
@Column(name="salary")
private double salary;
@Column(name="department")
private String department;
public Employee() {
}
 
public int getEmpId() {
return empId;
}
 
public void setEmpId(int empId) {
this.empId = empId;
}
 
public String getEmpName() {
return empName;
}
 
public void setEmpName(String empName) {
this.empName = empName;
}
 
public double getSalary() {
return salary;
}
 
public void setSalary(double salary) {
this.salary = salary;
}
 
public String getDepartment() {
return department;
}
 
public void setDepartment(String department) {
this.department = department;
}
 
@Override
public String toString() {
return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", department=" + department
+ "]";
}
}