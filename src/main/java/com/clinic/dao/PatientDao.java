package com.clinic.dao;

import java.util.List;

import javax.sql.DataSource;

import com.clinic.models.Patient;

public interface PatientDao {
    
    void add_patient(Patient patient);
    int update_patient(Patient patient);
    Patient getById(int id);
    Patient getByPhone(String phone);
    List<Patient> getAllPatients();
    int delete_patient(int id);
    List<Integer>getAllIds();
    List<String>getFirstName();
    List<String> getLastName();

    void setDataSource(DataSource dataSource);

}
