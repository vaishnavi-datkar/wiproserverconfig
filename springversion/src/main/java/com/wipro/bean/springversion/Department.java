package com.wipro.bean.springversion;

public class Department {
    private String deptCode;
    private String deptName;

    // Constructor
    public Department(String deptCode, String deptName) {
        this.deptCode = deptCode;
        this.deptName = deptName;
    }

    // Display method to print values
    public void display() {
        System.out.println("Department Code: " + deptCode);
        System.out.println("Department Name: " + deptName);
    }
}
