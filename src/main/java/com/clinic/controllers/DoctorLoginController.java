package com.clinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinic.dao.DoctorAccessDao;
import com.clinic.models.Doctor_access;


@Controller
public class DoctorLoginController {

    @Autowired
    private DoctorAccessDao doctorAccessDao;


    @RequestMapping(value = "/doctorLoginPage", method =  RequestMethod.GET)
    public String doctorLogin(){
        return "doctor-login";
    }

    @RequestMapping(value = "/doctorLogin", method = RequestMethod.POST)
    public String checkDoctorLogin(
        @RequestParam String uName, @RequestParam String password,
        Model model
        ){
        
    		Doctor_access d = doctorAccessDao.getByUsername(uName);
    		if(d==null) {
    			model.addAttribute("Error", "Invalid username");
    			return "doctor-login";
    		}
    		else if(!password.equals(d.getPassword())) {
    			model.addAttribute("Error", "Error password");
    			return "doctor-login";
    		}
    		
    		return "doctor-choose-page";
    		
        }

    
}
