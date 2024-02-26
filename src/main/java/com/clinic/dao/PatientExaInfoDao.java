package com.clinic.dao;

import java.util.List;

import javax.sql.DataSource;

import com.clinic.models.Patient_exa_info;

public interface PatientExaInfoDao {
    
    void add_patient_exa_info(Patient_exa_info patient_exa_info);
    int update_patient_exa_info(Patient_exa_info patient_exa_info);
    int delete_patient_exa_info(int id);
    int deleteAllExaForOnePatient(int id);
    Patient_exa_info getById(int id);
    List<Integer>getAllIds();
    List<Patient_exa_info>getAll();
    int addNewInfoToPatient1(Patient_exa_info patient_exa_info);
    int addNewInfoToPatient2(Patient_exa_info patient_exa_info);
    List<Patient_exa_info> allPatientVisits(int id);

    void setDataSource(DataSource dataSource);

}
