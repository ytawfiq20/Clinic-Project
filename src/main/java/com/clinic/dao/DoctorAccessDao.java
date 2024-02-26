package com.clinic.dao;

import java.util.List;

import javax.sql.DataSource;

import com.clinic.models.Doctor_access;

public interface DoctorAccessDao {
    
    int add_new_doctor(Doctor_access doc);
    int update_doctor(int id, Doctor_access doc);
    int delete_doctor(int id);
    Doctor_access getById(int id);
    Doctor_access getByUsername(String username);
    List<String> usernames();
    List<String> passwords();

    void setDataSource(DataSource dataSource);

}
