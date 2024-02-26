package com.clinic.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.clinic.models.Employee_access;
import com.clinic.rowmappers.EmployeeAccessRowMapper;

public class EmployeeAccessDaoImpl implements EmployeeAccessDao {

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public EmployeeAccessDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void add_assistant_access(Employee_access emp_access) {
        
        Object[] emp_access_info = new Object[]{
            emp_access.getEmp_id(),
            emp_access.getUsername(),
            emp_access.getPassword()
        };

        String sql = "insert into employee_access(emp_id, username, password)"+
        "values(?,?,?)";

        jdbcTemplate.update(sql, emp_access_info);
    }

    @Override
    public int edit_assistant_access(int id, Employee_access emp_access) {
        
        try {
        	String sql = "update employee_access set emp_id="+emp_access.getEmp_id()+
        	        ", username='"+emp_access.getUsername()+"', password='"+emp_access.getPassword()+"' "+
        	        "where emp_id="+id;

        	        return jdbcTemplate.update(sql);
        }catch (Exception e) {
			// TODO: handle exception
        	return 0;
		}

    }

    

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Integer> getAllIds() {
        
        String sql = "select emp_id from employee_access";
        return jdbcTemplate.queryForList(sql, Integer.class);

    }


	@Override
	public Employee_access getByUserName(String username) {
		String sql = "select * from employee_access where username=?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] {username},
					new EmployeeAccessRowMapper());
		}catch (Exception e) {
			return null;
		}
		
	}
	
	@Override
	public Employee_access getById(int id) {
		String sql = "select * from employee_access where emp_id=?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] {id},
					new EmployeeAccessRowMapper());
		}catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public int deleteEmployeeAccess(int id) {
		String sql = "delete from employee_access where emp_id="+id;
		return jdbcTemplate.update(sql);
	}


    
}
