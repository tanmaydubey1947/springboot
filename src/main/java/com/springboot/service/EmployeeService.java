package com.springboot.service;


import com.springboot.dao.EmployeeDAO;
import com.springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public String saveEmployee(Employee employee) {
        int count = employeeDAO.save(employee);
        return "RECORD INSERTED ! " + count;
    }

    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    public List<Employee> findAllByBeanMapper() {
        return employeeDAO.findAllByBeanMapper();
    }

    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    public String getNameById(int id) {
        return employeeDAO.getNameById(id);
    }

    public List<Employee> findByNameAndDept(String name, String dept) {
        return employeeDAO.findByNameAndDept(name, dept);
    }

    public String update(Employee employee) {
        int count = employeeDAO.update(employee);
        return "RECORD UPDATED ! " + count;
    }

    public String delete(int id) {
        int count = employeeDAO.delete(id);
        return "RECORD DELETED ! " + count;
    }
}
