package com.clinic.models;

public class Employee_access {
    
    private int emp_id;
    private String username;
    private String password;

    public Employee_access(){

    }
    
    public Employee_access(int emp_id, String username, String password){
        this.emp_id=emp_id;
        this.username=username;
        this.password=password;
    }

    public int getEmp_id() {
        return emp_id;
    }
    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    

    

}
