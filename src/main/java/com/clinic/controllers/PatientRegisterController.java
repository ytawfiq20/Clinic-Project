package com.clinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinic.dao.PatientDao;
import com.clinic.dao.PatientExaInfoDao;
import com.clinic.models.Patient;
import com.clinic.validation.UserValidation;

@Controller
public class PatientRegisterController {

    @Autowired
    PatientDao patientDao;
    @Autowired
    PatientExaInfoDao patientExaInfoDao;

    @RequestMapping(value = "/patientRegister", method = RequestMethod.GET)
    public String patientRegister(){
        return "patient-register-info";
    }

    @RequestMapping(value = "/patientRegister", method = RequestMethod.POST)
    public String patientRegister(Model model, @RequestParam String fName, 
    @RequestParam String lName, @RequestParam String pNumber, @RequestParam int age){

        UserValidation userValidation = new UserValidation();
        if(!userValidation.validateName(fName)){
            model.addAttribute("Error", "Check your first name");
            return "patient-register-info";
        }else if(!userValidation.validateName(lName)){
            model.addAttribute("Error", "Check your last name");
            return "patient-register-info";
        }else if(!userValidation.validateAge(age)){
            model.addAttribute("Error", "age must be >=12 and <=90");
            return "patient-register-info";
        }else if(!userValidation.validatePhoneNumber(pNumber)){
            model.addAttribute("Error", "phone number must be 11 digits"+
            "or this number exists before");
            return "patient-register-info";
        }
        
        patientDao.add_patient(new Patient(fName, lName, pNumber, age));
        return "booked";

    }
    
    


    
    
}
