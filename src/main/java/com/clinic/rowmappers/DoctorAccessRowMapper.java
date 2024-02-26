package com.clinic.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.clinic.models.Doctor_access;

public class DoctorAccessRowMapper implements RowMapper<Doctor_access> {

    @Override
    public Doctor_access mapRow(ResultSet rs, int arg1) throws SQLException {
        
        Doctor_access doctor_access = new Doctor_access();
        doctor_access.setDoctor_id(rs.getInt("doctor_id"));
        doctor_access.setUsername(rs.getString("username"));
        doctor_access.setPassword(rs.getString("password"));

        return doctor_access;

    }
    
}
