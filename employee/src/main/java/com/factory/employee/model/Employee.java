package com.factory.employee.model;

import javax.persistence.*;

@Entity
@Table (name="EmployeeDetails")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Employee_ID")
    private Long employeeID;

    @Column(name="Employee_Name")
    private String employeeName;

    @Column(name="Employee_Age")
    private int employeeAge;

    @Column(name="Employee_City")
    private String employeeCity;

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEmployeeCity() {
        return employeeCity;
    }

    public void setEmployeeCity(String employeeCity) {
        this.employeeCity = employeeCity;
    }

    public Employee(Long employeeID, String employeeName, int employeeAge, String employeeCity) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.employeeCity = employeeCity;
    }
    public Employee()
    {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAge=" + employeeAge +
                ", employeeCity='" + employeeCity + '\'' +
                '}';
    }
}
