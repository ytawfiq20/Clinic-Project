package com.clinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinic.dao.PatientDao;
import com.clinic.dao.PatientExaInfoDao;
import com.clinic.models.Patient;
import com.clinic.models.Patient_exa_info;
import com.clinic.validation.UserValidation;

@Controller
public class AssistantAccess {

	@Autowired
	PatientDao patientDao;
	@Autowired
	PatientExaInfoDao patientExaInfoDao;

	/*
	 * 
	 * create patient
	 * 
	 */
	
	@RequestMapping(value = "/addPatient", method = RequestMethod.GET)
	public String addPatient() {
		return "assistant-add-patient";
	}

	@RequestMapping(value = "/addPatient", method = RequestMethod.POST)
	public String addPatient(@RequestParam String fName, 
			@RequestParam String lName, @RequestParam String pNumber,
			@RequestParam int age, Model model) {

		UserValidation userValidation = new UserValidation();
		if (!userValidation.validateName(fName)) {
			model.addAttribute("Error", "Check your first name");
			return "patient-register-info";
		} else if (!userValidation.validateName(lName)) {
			model.addAttribute("Error", "Check your last name");
			return "assistant-add-patient";
		} else if (!userValidation.validateAge(age)) {
			model.addAttribute("Error", "age must be >=12 and <=90");
			return "assistant-add-patient";
		} else if (!userValidation.validatePhoneNumber(pNumber)) {
			model.addAttribute("Error", "phone number must be 11 digits" +
		"or this number exists before");
			return "assistant-add-patient";
		}
		
		
		Patient p = new Patient(fName, lName, pNumber, age);
		
		patientDao.add_patient(p);
		model.addAttribute("id", patientDao.getByPhone(pNumber).getPatient_id());
		return "redirect:/assistantPatientsList";
	}
	/*
	 * 
	 * update patient
	 * 
	 */
	@RequestMapping(value="/editPatient", method = RequestMethod.GET)
    public String updatePatient(@RequestParam int id, Model model){
        model.addAttribute("patient", patientDao.getById(id));
        return "assistant-update-patient";
    }

    @RequestMapping(value="/editPatient", method = RequestMethod.POST)
    public String updatePatient(@RequestParam int id,
        @RequestParam String fName,
    @RequestParam String lName, @RequestParam String pNumber, 
    @RequestParam int age, Model model){
    	
    	UserValidation userValidation = new UserValidation();
    	if(!userValidation.validateName(fName)) {
    		model.addAttribute("Error", "First name must be more than 2 characters");
    		model.addAttribute("patient", patientDao.getById(id));
            return "assistant-update-patient";
    	}else if(!userValidation.validateName(lName)) {
    		model.addAttribute("Error", "Last name must be more than 2 characters");
    		model.addAttribute("patient", patientDao.getById(id));
            return "assistant-update-patient";
    	}else if(!userValidation.validatePhoneNumber(pNumber)) {
    		model.addAttribute("Error", "Phone Number must be 11 digits");
    		model.addAttribute("patient", patientDao.getById(id));
            return "assistant-update-patient";
    	}else if(!userValidation.validateAge(age)) {
    		model.addAttribute("Error", "Age must be older than 12 and less than 90");
    		model.addAttribute("patient", patientDao.getById(id));
            return "assistant-update-patient";
    	}
    	
        Patient p = new Patient(id, fName, lName, pNumber, age);

        patientDao.update_patient(p);
        return "redirect:/assistantPatientsList"; 
    }

	/*
	 * 
	 * 
	 * create patient examination info
	 * 
	 */

	@GetMapping("/addExaInfo")
	public String addExaInfo(@RequestParam int id, Model model) {
		model.addAttribute("patient", patientDao.getById(id));
		return "addToExistPatient";
	}
	
	@RequestMapping(value = "/addExaInfo", method = RequestMethod.POST)
	public String addExaInfo(@RequestParam int id, @RequestParam String medecine,
			@RequestParam String status,
			@RequestParam String exa_date, Model model) {
		System.out.println(exa_date);
		if (exa_date==null) {
			model.addAttribute("Error", "You must define examination date");
			return "assistant-add-patient-exa-info";
		}
		patientExaInfoDao.add_patient_exa_info(new Patient_exa_info
				(id, medecine, status, exa_date));
		return "redirect:/patientsExaList";
	}

	/*
	 * 
	 * update patient examination info
	 * 
	 */

	@RequestMapping(value = "/editPatientExaInfo", method = RequestMethod.GET)
	public String editPatientExaInfo(Model model, @RequestParam int id) {
		if (patientExaInfoDao.getById(id) == null) {
			model.addAttribute("Error", "No unique id to update data");
			model.addAttribute("info", patientExaInfoDao.getAll());
			return "assistant-update-patient-exa-info";
		}

		model.addAttribute("patient", patientExaInfoDao.getById(id));
		return "assistant-update-patient-exa-info";
	}

	@RequestMapping(value = "/editPatientExaInfo", method = RequestMethod.POST)
	public String editPatientExaInfo(@RequestParam int patient_id, 
			@RequestParam int id, @RequestParam String medecine,
			@RequestParam String status, @RequestParam String date, 
			@RequestParam String re_exa_date, Model model,
			@RequestBody String r) {

		System.out.println(r);
		if (date==null) {
			model.addAttribute("Error", "Date must not be null");
			return "redirect:/editPatientExaInfo";
		}
		Patient_exa_info p = new Patient_exa_info(patient_id, medecine, 
				status, date, re_exa_date, id);
		patientExaInfoDao.update_patient_exa_info(p);
		System.out.println(patientExaInfoDao.getById(id).getMedecine());
		System.out.println(patientExaInfoDao.getById(id).getStatus());
		System.out.println(patientExaInfoDao.getById(id).getExa_date());
		System.out.println(patientExaInfoDao.getById(id).getRe_exa_date());
		return "redirect:/patientsExaList";

	}
    
	/*
	 * 
	 * patients list
	 * 
	 * */
	@RequestMapping(value = "/assistantPatientsList", method = RequestMethod.GET)
	public String patientsList(Model model) {
		model.addAttribute("patients", patientDao.getAllPatients());
		return "assistant-patients-list";
	}
	
	/*
	 * 
	 * patients examination info list
	 * 
	 * */
	
    @GetMapping("/patientsExaList")
    public String patietsExaList(Model model) {
    	model.addAttribute("info", patientExaInfoDao.getAll());
    	return "patients-info-list";
    }


}
