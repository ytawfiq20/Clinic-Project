package com.clinic.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.clinic.models.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
        
        Employee employee = new Employee();
        employee.setEmp_id(rs.getInt("emp_id"));
        employee.setFirst_name(rs.getString("first_name"));
        employee.setLast_name(rs.getString("last_name"));
        employee.setFirst_day_work(rs.getString("first_day_work"));
        employee.setSalary(rs.getFloat("salary"));
        employee.setBonus(rs.getFloat("bonus"));
        employee.setDiscount(rs.getFloat("discount"));
        employee.setPhone_number(rs.getString("phone_number"));
        employee.setAge(rs.getInt("age"));

        return employee;

    }
    
}
