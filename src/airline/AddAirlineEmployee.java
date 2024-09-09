package com.airline;

public class AddAirlineEmployee {
    private String employeeID;
    private String employeeName;
    private String role;

    public AddAirlineEmployee(String employeeID, String employeeName, String role) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.role = role;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }
