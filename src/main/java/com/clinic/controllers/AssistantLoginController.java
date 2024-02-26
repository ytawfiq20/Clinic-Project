package com.clinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinic.dao.EmployeeAccessDao;
import com.clinic.models.Employee_access;

@Controller
public class AssistantLoginController {

	@Autowired
	EmployeeAccessDao employeeAccessDao;
	
	 /*
     * 
     * assistant login
     * 
     * */
    
    @RequestMapping(value = "/assistantLogin", method=RequestMethod.GET)
    public String assistantLogin(){
        return "assistant-login";
    }

    @PostMapping("/assistantLogin")
    //@RequestMapping(value = "/assistantLogin", method=RequestMethod.POST)
    public String assistantLogin(
    @RequestParam String username, @RequestParam String password, 
    Model model){
        
    	Employee_access e = employeeAccessDao.getByUserName(username);
    	
    	if(e==null) {
    		model.addAttribute("Error", "Invalid username");
    		return "assistant-login";
    	}
    	else if(!password.equals(e.getPassword())) {
    		model.addAttribute("Error", "Error password");
    		return "assistant-login";
    	}
    	
    	return "redirect:/assistantPatientsList";
        
    }
}
