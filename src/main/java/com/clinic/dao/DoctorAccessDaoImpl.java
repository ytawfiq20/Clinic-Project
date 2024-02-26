package com.clinic.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.clinic.models.Doctor_access;
import com.clinic.rowmappers.DoctorAccessRowMapper;

public class DoctorAccessDaoImpl implements DoctorAccessDao {

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public DoctorAccessDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int add_new_doctor(Doctor_access doc) {
    	
        try {
            Object[] doc_info = new Object[]{
                    doc.getDoctor_id(),
                    doc.getUsername(),
                    doc.getPassword()
                };
                String sql = "insert into doctors_access(doctor_id,"+
                "username, password)values(?,?,?)";

                jdbcTemplate.update(sql, doc_info);
                return 1;
        }catch(Exception e) {
        	return 0;
        }


    }

    @Override
    public int update_doctor(int id, Doctor_access doc) {
        
    	try {
    		String sql = "updata doctors_access set doctor_id="+
    		        doc.getDoctor_id()+", username='"+doc.getUsername()+"', "
    		        +"password='"+doc.getPassword()+"' "+
    		        "where doctor_id="+id;

    		        return jdbcTemplate.update(sql);
    	}catch (Exception e) {
			return 0;
		}
        
    }

    @Override
    public int delete_doctor(int id) {
        
        try {
        	String sql = "delete form doctors_access where doctor_id="+id;
            return jdbcTemplate.update(sql);
        }catch (Exception e) {
			return 0;
		}

    }

    @Override
    public Doctor_access getById(int id) {
        try {
        	String sql = "select * from doctors_access where doctor_id=?";
            return jdbcTemplate.queryForObject(sql, 
            new Object[]{id}, new DoctorAccessRowMapper());
        }catch (Exception e) {
			return null;
		}
    }
    
	@Override
	public List<String> usernames() {
		String sql="select username from doctors_access";
		return jdbcTemplate.queryForList(sql, String.class);
	}

	@Override
	public List<String> passwords() {
		String sql="select password from doctors_access";
		return jdbcTemplate.queryForList(sql, String.class);
	}

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public Doctor_access getByUsername(String username) {
		try {
			String sql= "select * from doctors_access where username=?";
			return jdbcTemplate.queryForObject(sql, 
					new Object[] {username}, new DoctorAccessRowMapper());
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
    
}
