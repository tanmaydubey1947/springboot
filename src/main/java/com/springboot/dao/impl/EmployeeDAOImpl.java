package com.springboot.dao.impl;

import com.springboot.dao.EmployeeDAO;
import com.springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int save(Employee employee) {
        String query = "INSERT INTO EMPLOYEE_DATA (name, dept, email, doj) values(?, ?, ?, ?)";
        return jdbcTemplate.update(query, employee.getName(), employee.getDept(), employee.getEmail(), employee.getDoj());
    }

    @Override
    public List<Employee> findAll() {
        String query = "SELECT * FROM EMPLOYEE_DATA";
        return jdbcTemplate.query(query, new EmployeeRowMapper()); // This can be replaced with lambda expression
    }

    @Override
    public List<Employee> findAllByBeanMapper() {
        String query = "SELECT * FROM EMPLOYEE_DATA";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Employee.class));
    }

    @Override
    public Employee findById(int id) {
        String query = "SELECT * FROM EMPLOYEE_DATA WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Employee.class), id);
    }

    @Override
    public String getNameById(int id) {
        String query = "SELECT name FROM EMPLOYEE_DATA WHERE id = ?";
        return jdbcTemplate.queryForObject(query, String.class, id);
    }

    @Override
    public List<Employee> findByNameAndDept(String name, String dept) {
        String query = "SELECT * FROM EMPLOYEE_DATA WHERE name = ? AND dept = ?";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Employee.class), name, dept);
    }

    @Override
    public int update(Employee employee) {
        String query = "UPDATE EMPLOYEE_DATA SET name = ?, dept = ?, email = ?, doj = ? WHERE id = ?";
        return jdbcTemplate.update(query, employee.getName(), employee.getDept(), employee.getEmail(), employee.getDoj(), employee.getId());
    }

    @Override
    public int delete(int id) {
        String query = "DELETE FROM EMPLOYEE_DATA WHERE id = ?";
        return jdbcTemplate.update(query, id);
    }
}
