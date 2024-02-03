package com.Map.HomeWork;

import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.*;

@Service
public class EmployeeServis {

    private final Map<String, Employee> employees = new HashMap<>(10);

    public void addWorker(String secondName, String firstname) {
        if (employees.size() >= 10) {
            throw new EmployeeStorageFullException();
        }
        String employee = find(secondName, firstname);


        if (employee != null) {
            throw new EmployeeAlredyAddedException();
        }
        employees.put(key(secondName, firstname), new Employee(secondName, firstname));

    }

    public void removeWorker(String secondName, String firstname) {
        String employee = key(secondName, firstname);
        if (find(secondName, firstname) == null) {
            throw new EmployeeNotFoundException();
        } else {

            employees.remove(employee);
        }
    }

    public String findWorker(String secondName, String firstname) {
        if (find(secondName, firstname) == null) {
            throw new EmployeeNotFoundException();
        } else {
            return find(secondName, firstname);
        }

    }

    public String find(String secondName, String firstname) {
        for (String iter : employees.keySet()) {
            if (iter.equals(key(secondName, firstname))) {//getSecondName().equals(secondName)&&iter.getFirstName().equals(firstname)){
                return iter;
            }
        }
        return null;
    }

    public Map<String, Employee> listWorker() {
        return employees;
    }

    public static String key(String secondName, String firstname) {
        return secondName + "," + firstname;
    }
}
