package com.Map.HomeWork;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class DeportamentController {

    private final DeportamentServis servis;

    public DeportamentController(DeportamentServis servis) {
        this.servis = servis;
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalary(@RequestParam int deportament) {

        return servis.maxSalaryDeportament(deportament);

    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam int deportament) {

        return servis.minSalary(deportament);

    }

    @GetMapping(path = "/all")
    public Employee allWorks(@RequestParam int deportament) {

        return servis.deportamentWorks(deportament);

    }

    @GetMapping(path = "/alll")
    public Map<Integer, List<Employee>> all() {

        return servis.findDeportamentWorks();

    }


}
