package com.clinic.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.clinic.models.Patient;

public class PatientRowMapper implements RowMapper<Patient> {

    @Override
    public Patient mapRow(ResultSet rs, int arg1) throws SQLException {

        Patient patient = new Patient();
        patient.setPatient_id(rs.getInt("patient_id"));
        patient.setFirst_name(rs.getString("first_name"));
        patient.setLast_name(rs.getString("last_name"));
        patient.setPhone_number(rs.getString("phone_number"));
        patient.setAge(rs.getInt("age"));

        return patient;
    }
    
}
