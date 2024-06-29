package com.springboot.dao;

import com.springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    int save(Employee employee);

    List<Employee> findAll();

    public List<Employee> findAllByBeanMapper();

    Employee findById(int id);

    String getNameById(int id);

    List<Employee> findByNameAndDept(String name, String dept);

    int update(Employee employee);

    int delete(int id);
}
