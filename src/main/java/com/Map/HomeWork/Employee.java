package com.Map.HomeWork;

public class Employee {

    private String secondName;
    private String firstName;
    private Integer salary;
    private Integer deportament;



    public Employee(String secondName, String firstName,Integer salary,Integer deportament) {
        this.secondName = secondName;
        this.firstName=firstName;
        this.salary=salary;
        this.deportament=deportament;


    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getDeprtament() {
        return deportament;
    }

    public void setDeprtament(Integer deprtament) {
        this.deportament = deprtament;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Override
    public String toString() {
        return String.format("%s %s %d %d", secondName,firstName,salary,deportament);
    }
}
