package com.Map.HomeWork;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.*;

@Service
public class EmployeeServis {

    private final Map<String, Employee> employees = new HashMap<>(10);

    public void addWorker(String secondName, String firstname,int salary,int deportament) {
        if (employees.size() >= 10) {
            throw new EmployeeStorageFullException();
        }
        String employee = find(secondName, firstname);


        if (employee != null) {
            throw new EmployeeAlredyAddedException();
        }
        employees.put(key(secondName, firstname), new Employee(secondName, firstname,salary,deportament));

    }

    public void removeWorker(String secondName, String firstname) {
        String employee = key(secondName, firstname);
        if (find(secondName, firstname) == null) {
            throw new EmployeeNotFoundException();
        } else {

            employees.remove(employee);
        }
    }

    public Employee findWorker(String secondName, String firstname) {
        if (find(secondName, firstname) == null) {
            throw new EmployeeNotFoundException();
        }
            return findWorker(secondName,firstname);


    }

    public String find(String secondName, String firstname) {

        for (String iter : employees.keySet()) {
            if(StringUtils.isAlpha(secondName)||StringUtils.isAlpha(firstname)){
                throw new NameException();
            }
            else {
                StringUtils.upperCase(secondName);
                StringUtils.upperCase(firstname);
            }
            if (iter.equals(key(secondName, firstname))) {
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

    public Collection<Employee> list() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
