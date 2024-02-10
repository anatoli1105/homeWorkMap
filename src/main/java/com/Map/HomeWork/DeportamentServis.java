package com.Map.HomeWork;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;

@Service
public class DeportamentServis {
    private final EmployeeServis employeeServis;

    public DeportamentServis(EmployeeServis employeeServis) {
        this.employeeServis = employeeServis;
    }

    public Employee maxSalaryDeportament(int deportament) {
        return employeeServis.list().stream().filter(o -> o.getDeprtament() == deportament)
                .max(Comparator.comparingInt(o -> o.getSalary()))
                .orElse(null);
    }

    public Employee minSalary(int deportament) {
        return employeeServis.list().stream().filter(o -> o.getDeprtament() == deportament)
                .min(Comparator.comparingInt(o -> o.getSalary()))
                .orElse(null);
    }

    public Employee deportamentWorks(int deportament) {
        return (Employee) employeeServis.list().stream().filter(o -> o.getDeprtament() == deportament)
                .collect(Collectors.toList());

    }

    public Map<Integer, List<Employee>> findDeportamentWorks() {
        return employeeServis.list().stream().collect(Collectors.groupingBy(o -> o.getDeprtament()));

    }


}
