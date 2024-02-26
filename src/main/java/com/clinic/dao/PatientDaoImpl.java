package com.clinic.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.clinic.models.Patient;
import com.clinic.rowmappers.PatientRowMapper;

public class PatientDaoImpl implements PatientDao {

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public PatientDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void add_patient(Patient patient) {
        
    	try {
            Object[] patient_info = new Object[]{
                    patient.getFirst_name(),
                    patient.getLast_name(),
                    patient.getPhone_number(),
                    patient.getAge()
                };

                String sql= "insert into patients_info (first_name,"+
                " last_name, phone_number,  age)values(?,?,?,?)";

                jdbcTemplate.update(sql, patient_info);
    	}catch (Exception e) {
			// TODO: handle exception
    		return;
		}


    }

    @Override
    public int update_patient(Patient patient) {

        try {
        	String sql = "update patients_info set first_name='"+
        	        patient.getFirst_name()+"', "
        	        +"last_name='"+patient.getLast_name()+"',phone_number='"+
        	        patient.getPhone_number()+"', "+"age="+patient.getAge()+" "
        	        +"where patient_id="+patient.getPatient_id();

        	        return jdbcTemplate.update(sql);
        }catch (Exception e) {
			// TODO: handle exception
        	return 0;
		}

    }

    @Override
    public Patient getById(int id) {
        
        try {
        	String sql = "select * from patients_info where patient_id=?";
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, 
            new PatientRowMapper());
        }catch (Exception e) {
			// TODO: handle exception
        	return null;
		}

    }

    @Override
    public List<Patient> getAllPatients() {
        
        String sql = "select * from patients_info";
        return jdbcTemplate.query(sql, new PatientRowMapper());
    }

    @Override
    public int delete_patient(int id) {
        
        String sql = "delete from patients_info where patient_id="+id;
        return jdbcTemplate.update(sql);

    }

    @Override
    public Patient getByPhone(String phone) {
        
        try {
        	String sql = "select * from patients_info where phone_number=?";
            return jdbcTemplate.queryForObject(sql, new Object[]{phone}, 
            		new PatientRowMapper());
        }catch (Exception e) {
			// TODO: handle exception
        	return null;
		}
    }
    
    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public List<Integer> getAllIds() {
		
		try {
			
			String sql= "select patient_id from patients_info";
			return jdbcTemplate.queryForList(sql, Integer.class);
			
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

	@Override
	public List<String> getFirstName() {
		try {
			
			String sql= "select first_name from patients_info";
			return jdbcTemplate.queryForList(sql, String.class);
			
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@Override
	public List<String> getLastName() {
		try {
			
			String sql= "select last_name from patients_info";
			return jdbcTemplate.queryForList(sql, String.class);
			
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
    
}
