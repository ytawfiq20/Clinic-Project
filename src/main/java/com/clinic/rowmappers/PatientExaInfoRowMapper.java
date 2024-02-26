package com.clinic.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.clinic.models.Patient_exa_info;

public class PatientExaInfoRowMapper implements RowMapper<Patient_exa_info> {

    @Override
    @Nullable
    public Patient_exa_info mapRow(ResultSet rs, int arg1) throws SQLException {
        
        Patient_exa_info patient_exa_info = new Patient_exa_info();

        patient_exa_info.setPatient_id(rs.getInt("patient_id"));
        patient_exa_info.setMedecine(rs.getString("medecine"));
        patient_exa_info.setStatus(rs.getString("status"));
        patient_exa_info.setExa_date(rs.getString("exa_date"));
        patient_exa_info.setRe_exa_date(rs.getString("re_exa_date"));
        patient_exa_info.setId(rs.getInt("id"));

        return patient_exa_info;

    }


    
}
