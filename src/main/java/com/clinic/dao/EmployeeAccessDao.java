package com.clinic.dao;

import java.util.List;

import javax.sql.DataSource;

import com.clinic.models.Employee_access;

public interface EmployeeAccessDao {

    void add_assistant_access(Employee_access emp_access);
    int edit_assistant_access(int id, Employee_access emp_access);
    int deleteEmployeeAccess(int id);
    List<Integer>getAllIds();
    Employee_access getByUserName(String username);

    void setDataSource(DataSource dataSource);
	Employee_access getById(int id);

}
