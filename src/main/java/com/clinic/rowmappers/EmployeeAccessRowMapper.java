package com.clinic.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.clinic.models.Employee_access;

public class EmployeeAccessRowMapper implements RowMapper<Employee_access> {

    @Override
    @Nullable
    public Employee_access mapRow(ResultSet rs, int arg1) throws SQLException {
        
        Employee_access employee_access = new Employee_access();
        employee_access.setEmp_id(rs.getInt("emp_id"));
        employee_access.setUsername(rs.getString("username"));
        employee_access.setPassword(rs.getString("password"));

        return employee_access;

    }
    
}
