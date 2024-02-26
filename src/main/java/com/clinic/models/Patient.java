package com.clinic.models;

public class Patient {
    
    private int patient_id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private int age;

    public Patient(){

    }

	public Patient(int patient_id, String first_name, String last_name, 
			String phone_number, int age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.age = age;
        this.patient_id = patient_id;
    }
	
	
	public Patient(String first_name, String last_name, 
			String phone_number, int age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.age = age;
    }


    public int getPatient_id() {
        return patient_id;
    }
    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }


	@Override
	public String toString() {
		return String.format("Patient [patient_id=%s, first_name=%s, "
				+ "last_name=%s, phone_number=%s, age=%s]",
				patient_id, first_name, last_name, phone_number, age);
	}
	
	

    

    

}
