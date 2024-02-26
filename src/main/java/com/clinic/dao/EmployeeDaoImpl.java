package com.clinic.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.clinic.models.Employee;
import com.clinic.rowmappers.EmployeeRowMapper;

public class EmployeeDaoImpl implements EmployeeDao {

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public EmployeeDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addEmployee(Employee employee) {
    	
    	try {
    		Object[] employee_info = new Object[]{
    	            employee.getFirst_name(),
    	            employee.getLast_name(),
    	            employee.getFirst_day_work(),
    	            employee.getSalary(),
    	            employee.getBonus(),
    	            employee.getDiscount(),
    	            employee.getPhone_number(),
    	            employee.getAge()
    	        };
    	        
    	        String sql = "insert into employee(first_name,"+
    	        "last_name, first_day_work, salary, bonus, discount,"
    	        +"phone_number, age)values("
    	        +"?,?,?,?,?,?,?,?)";
    	         jdbcTemplate.update(sql, employee_info);
    	         
    	}catch (Exception e) {
			return;
		}
    	
        
    }

    @Override
    public int updateEmployee(int id, Employee employee) {
        try {
        	String sql = "update employee set first_name='"+
        	        employee.getFirst_name()+"', last_name='"+
        	        employee.getLast_name()+"', first_day_work='"+
        	        employee.getFirst_day_work()+"', salary="+
        	        employee.getSalary()+", bonus="+employee.getBonus()+
        	        ", discount="+employee.getDiscount()+",phone_number='"+
        	        employee.getPhone_number()+"', age="+employee.getAge()+
        	        " where emp_id="+id;

        	        return jdbcTemplate.update(sql);
        }catch (Exception e) {
			return 0;
		}
    }

    @Override
    public int deleteEmployee(int id) {
        String sql = "delete from employee where emp_id="+id;

        return jdbcTemplate.update(sql);
    }

    @Override
    public Employee getByID(int emp_id) {

        String sql = "select * from employee where emp_id=?";

        return jdbcTemplate.queryForObject(sql, 
        new Object[]{emp_id}, new EmployeeRowMapper());

    }

    @Override
    public List<Employee> getAllEmployees() {
        
        String sql = "select * from employee";

        return jdbcTemplate.query(sql, new EmployeeRowMapper());

    }

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



 
}
