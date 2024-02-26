package com.clinic.models;

public class Patient_exa_info {
    
    private int patient_id;
    private String medecine;
    private String status;
    private String exa_date;
    private String re_exa_date;
    private int id;
    
    public Patient_exa_info(){

    }

	public Patient_exa_info(int patient_id, String medecine, 
			String status, String exa_date, String re_exa_date) {
		super();
		this.patient_id = patient_id;
		this.medecine = medecine;
		this.status = status;
		this.exa_date = exa_date;
		this.re_exa_date = re_exa_date;
	}
	
	
	public Patient_exa_info(int patient_id, String medecine, 
			String status, String exa_date) {
		super();
		this.patient_id = patient_id;
		this.medecine = medecine;
		this.status = status;
		this.exa_date = exa_date;
	}
	
	public Patient_exa_info(int patient_id, String medecine, String status, 
			String exa_date, String re_exa_date, int id) {
		super();
		this.patient_id = patient_id;
		this.medecine = medecine;
		this.status = status;
		this.exa_date = exa_date;
		this.re_exa_date = re_exa_date;
		this.id = id;
	}
	
	public Patient_exa_info(int patient_id, String medecine, String status, 
			String exa_date, int id) {
		super();
		this.patient_id = patient_id;
		this.medecine = medecine;
		this.status = status;
		this.exa_date = exa_date;
		this.id = id;
	}

	public int getPatient_id() {
        return patient_id;
    }
    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }
    public String getMedecine() {
        return medecine;
    }
    public void setMedecine(String medecine) {
        this.medecine = medecine;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getExa_date() {
        return exa_date;
    }
    public void setExa_date(String exa_date) {
        this.exa_date = exa_date;
    }
    public String getRe_exa_date() {
        return re_exa_date;
    }
    public void setRe_exa_date(String re_exa_date) {
        this.re_exa_date = re_exa_date;
    }


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format(
				"Patient_exa_info [patient_id=%s, medecine=%s, status=%s, "
				+ "exa_date=%s, re_exa_date=%s, id=%s]",
				patient_id, medecine, status, exa_date, re_exa_date, id);
	}

    

}
