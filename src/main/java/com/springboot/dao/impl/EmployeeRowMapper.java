package com.springboot.dao.impl;

import com.springboot.entity.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Employee.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .doj(rs.getDate("doj"))
                .email(rs.getString("email"))
                .dept(rs.getString("dept"))
                .build();
    }
}
