package com.Map.HomeWork;

public class Employee {

    private String secondName;
    private String firstName;



    public Employee(String secondName, String firstName) {
        this.secondName = secondName;
        this.firstName=firstName;


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
        return String.format("%s %s ", secondName,firstName);
    }
}
