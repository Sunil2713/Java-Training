package com.training.employeeanalytics.model;

public class Employee {
    private int id;
    private String name;
    private String department;
    private String designation;
    private double salary;
    private int experience;
    private String location;

    public Employee(int id, String name, String department, String designation,
            double salary, int experience, String location) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
        this.experience = experience;
        this.location = location;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', department='%s', designation='%s', salary=%.2f, experience=%d, location='%s'}",
                id, name, department, designation, salary, experience, location);
    }
}
