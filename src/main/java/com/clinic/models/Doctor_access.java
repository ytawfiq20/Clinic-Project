package com.clinic.models;

public class Doctor_access {
    
    private int doctor_id;
    private String username;
    private String password;
    
    public int getDoctor_id() {
        return doctor_id;
    }
    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
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

    @Override
    public String toString() {
        return "Doctor_access [doctor_id=" + doctor_id +
        ", username=" + username + ", password=" + password + "]";
    }

    

}
