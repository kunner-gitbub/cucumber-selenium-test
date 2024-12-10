package com.kun.jjftest;

/**
 * ClassName: Employee
 * Package: com.kun.jjftest
 * Description:
 *
 * @Author KunJiang
 * @Create 12/9/24 7:46 PM
 * @Version 1.0
 */

public class Employee {
    private int empID;
    private String empName;

    public Employee() {
    }

    public Employee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                '}';
    }
}
