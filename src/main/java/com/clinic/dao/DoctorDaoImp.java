package com.clinic.dao;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;



public class DoctorDaoImp implements DoctorDao {


    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public DoctorDaoImp(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }




    
}
