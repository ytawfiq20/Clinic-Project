package com.clinic.dao;

import java.util.List;

import javax.sql.DataSource;

import com.clinic.models.Employee;

public interface EmployeeDao {
    
    void addEmployee(Employee employee);
    int updateEmployee(int id, Employee employee);
    int deleteEmployee(int id);
    Employee getByID(int emp_id);
    List<Employee> getAllEmployees();

    void setDataSource(DataSource dataSource);

}
