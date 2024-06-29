package com.springboot.controller;


import com.springboot.entity.Employee;
import com.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public String saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/findAll")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/findAllByBeanMapper")
    public List<Employee> findAllByBeanMapper() {
        return employeeService.findAllByBeanMapper();
    }

    @GetMapping("/findById/{id}")
    public Employee findById(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @GetMapping("/getNameById/{id}")
    public String getNameById(@PathVariable int id) {
        return employeeService.getNameById(id);
    }

    @GetMapping("/findByNameAndDept/{name}/{dept}")
    public List<Employee> findByNameAndDept(@PathVariable String name, @PathVariable String dept) {
        return employeeService.findByNameAndDept(name, dept);
    }

    @PutMapping
    public String update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return employeeService.delete(id);
    }
}
