package com.clinic.models;

public class Doctor {

    private int doctor_id;
    private String doctor_name;
    private String description;
    private String phone_number;
    private String field;
    private String working_days;

    public int getDoctor_id() {
        return doctor_id;
    }
    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }
    public String getDoctor_name() {
        return doctor_name;
    }
    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }
    public String getWorking_days() {
        return working_days;
    }
    public void setWorking_days(String working_days) {
        this.working_days = working_days;
    }

    @Override
    public String toString() {
        return "Doctor [doctor_id=" + doctor_id + ", doctor_name=" +
        doctor_name + ", description=" + description
        + ", phone_number=" + phone_number + ", field=" + 
        field + ", working_days=" + working_days + "]";
    }

    

    
}
