package com.springboot.controller;


import com.springboot.entity.Employee;
import com.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/welcome")
    public String welcome() {
        return "Hello Welcome !!!";
    }


    @PostMapping("/create")
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Employee onboardNewEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }


    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_HR') or hasAuthority('ROLE_MANAGER')")
    public List<Employee> getAll() {
        return employeeService.getEmployees();
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_EMPLOYEE')")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }


    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ROLE_HR')")
    public Employee updateRole(@RequestBody Employee employee) {
        return employeeService.changeRoleOfEmployee(employee);
    }

}
