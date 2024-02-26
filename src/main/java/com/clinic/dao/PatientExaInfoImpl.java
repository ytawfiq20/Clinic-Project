package com.clinic.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.clinic.models.Patient_exa_info;
import com.clinic.rowmappers.PatientExaInfoRowMapper;

public class PatientExaInfoImpl implements PatientExaInfoDao {

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public PatientExaInfoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void add_patient_exa_info(Patient_exa_info patient_exa_info) {
        
    	try {
    		Object[] info = new Object[]{
    	            patient_exa_info.getPatient_id(),
    	            patient_exa_info.getMedecine(),
    	            patient_exa_info.getStatus(),
    	            patient_exa_info.getExa_date()
    	        };

    	        String sql = "insert into patient_exa_info(patient_id, medecine,"
    	        +"status, exa_date)values(?,?,?,?)";
    	        jdbcTemplate.update(sql, info);
    	}catch (Exception e) {
			// TODO: handle exception
    		return;
		}
        

    }

    @Override
    public int update_patient_exa_info(Patient_exa_info patient_exa_info) {
        
        try {
        	String sql= "update patient_exa_info set patient_id= "
        			+patient_exa_info.getPatient_id()
        	   +", medecine='"+patient_exa_info.getMedecine()+"', status='"+
        	   patient_exa_info.getStatus()+"', exa_date='"
        	   +patient_exa_info.getExa_date()+
        	   "', re_exa_date='"+patient_exa_info.getRe_exa_date()+"' where "
        	   +"id="+patient_exa_info.getId();

        	        return jdbcTemplate.update(sql);
        }catch (Exception e) {
			// TODO: handle exception
        	return 0;
		}

    }

    @Override
    public int delete_patient_exa_info(int id) {
        
        String sql = "delete from patient_exa_info where id = "+id;
        return jdbcTemplate.update(sql);

    }

    @Override
    public Patient_exa_info getById(int id) {
        
        try {
        	String sql = "select * from patient_exa_info where id=?";
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, 
            		new PatientExaInfoRowMapper());
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
        
        String sql = "select patient_id from patient_exa_info";
        return jdbcTemplate.queryForList(sql, Integer.class);

    }

    @Override
    public List<Patient_exa_info> getAll() {
        
        String sql = "select * from patient_exa_info";
        return jdbcTemplate.query(sql, new PatientExaInfoRowMapper());

    }

	@Override
	public int addNewInfoToPatient1(Patient_exa_info patient_exa_info) {
		try {
		
			Object[] p= new Object[] {
				patient_exa_info.getPatient_id(), patient_exa_info.getMedecine(),
				patient_exa_info.getStatus(),
				patient_exa_info.getExa_date(), patient_exa_info.getRe_exa_date()
			};
			String sql = "insert into patient_exa_info(patient_id,"
					+ "medecine, status, exa_date, re_exa_date)values(?,?,?,?,?)";
			return jdbcTemplate.update(sql, p);
			
		}catch(Exception e) {
			return 0;
		}
	}
	
	@Override
	public int addNewInfoToPatient2(Patient_exa_info patient_exa_info) {
		try {
		
			Object[] p= new Object[] {
				patient_exa_info.getPatient_id(), patient_exa_info.getMedecine(),
				patient_exa_info.getStatus(),
				patient_exa_info.getExa_date()
			};
			String sql = "insert into patient_exa_info(patient_id,"
					+ "medecine, status, exa_date)values(?,?,?,?)";
			return jdbcTemplate.update(sql, p);
			
		}catch(Exception e) {
			return 0;
		}
	}

	@Override
	public int deleteAllExaForOnePatient(int id) {
		String sql= "delete from patient_exa_info where patient_id = "+id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Patient_exa_info> allPatientVisits(int id) {
		
		try {
			
			String sql= "select * from patient_exa_info where patient_id=?";
			return jdbcTemplate.query(sql, new Object[] {id},
					new PatientExaInfoRowMapper());
			
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

    
}
