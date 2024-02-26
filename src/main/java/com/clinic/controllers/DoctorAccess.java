package com.clinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinic.dao.EmployeeAccessDao;
import com.clinic.dao.EmployeeDao;
import com.clinic.dao.PatientDao;
import com.clinic.dao.PatientExaInfoDao;
import com.clinic.models.Employee;
import com.clinic.models.Employee_access;
import com.clinic.validation.EmployeeValidation;

/*
 * 
 * 
 * this controller contains all operation that doctor can perform like
 * (add-update-delete) employees or patients
 * 
 * 
 * */
@Controller
public class DoctorAccess {
	
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	EmployeeAccessDao employeeAccessDao;
	@Autowired
	PatientDao patientDao;
	@Autowired
	PatientExaInfoDao patientExaInfoDao;

	/*
	 * 
	 * add Employees
	 * 
	 * */
	
	@RequestMapping(value = "/addEmployee", method=RequestMethod.GET)
    public String addEmployee(){
        return "add-employee-info";
    }

    @RequestMapping(value = "/addEmployee", method=RequestMethod.POST)
    public String addEmployee(
        @RequestParam String fName, @RequestParam String lName,
        @RequestParam String fDay, @RequestParam float salary,
        @RequestParam float bonus, @RequestParam float discount,
        @RequestParam String pNumber, @RequestParam int age, Model model
        ){
    	if(fName.equals("null")||lName.equals("null")
    			||pNumber.equals("null")||fDay.equals("null")) {
    		model.addAttribute("Error", "Check your data");
            return "redirect:/addEmployee";
    	}
            Employee employee = new Employee(
                fName, lName, fDay, salary, bonus, discount, pNumber, age
            );
        EmployeeValidation employeeValidation = new EmployeeValidation();
        if(!employeeValidation.validateName(fName)){
            model.addAttribute("Error", "Check your first name");
            return "redirect:/addEmployee";
        }else if(!employeeValidation.validateName(lName)){
            model.addAttribute("Error", "Check your last name");
            return "redirect:/addEmployee";
        }else if(!employeeValidation.validateAge(age)){
            model.addAttribute("Error", "age must be >=12 and <=90");
            return "redirect:/addEmployee";
        }else if(!employeeValidation.validatePhoneNumber(pNumber)){
            model.addAttribute("Error", "phone number must be 11 digits"+
            "or this number exists before");
            return "redirect:/addEmployee";
        }else if(!employeeValidation.salaryValidation(salary)){
            model.addAttribute("Error", "salary must be >=0");
            return "redirect:/addEmployee";
        }

        employeeDao.addEmployee(employee);
        return "redirect:/getAllEmployees";
    }
    
    /*
     * 
     * create employees login info
     * 
     * */
    
    @RequestMapping(value = "/addEmployeeAccess", method = RequestMethod.POST)
    public String addEmployeeAccessInfo(
        @RequestParam int id, @RequestParam String uName, 
        @RequestParam String password, Model model
    ){
    	Employee_access employee_access = employeeAccessDao.getById(id);
    	if(employee_access==null) {
    		model.addAttribute("Error", "Invalid id");
    		return"update-employee-access";
    	}
        employeeAccessDao.add_assistant_access(new Employee_access(id, uName, password));
        return "redirect:/getAllEmployees";
    }
    
    /*
     * 
     * update employees login info
     * 
     * */
    
    @RequestMapping(value = "/editEmployeeAccess", method = RequestMethod.GET)
    public String editEmployeeAccess(@RequestParam int id, Model model){
        model.addAttribute("id", id);
        return "update-employee-access";
    }

    @RequestMapping(value = "/editEmployeeAccess", method = RequestMethod.POST)
    public String editEmployeeAccess(
        @RequestParam int id, @RequestParam String uName, 
        @RequestParam String password, Model model
    ){
        
        if(employeeAccessDao.getById(id)!=null){
            employeeAccessDao.edit_assistant_access(id, 
            		new Employee_access(id, uName, password));
            return "redirect:/getAllEmployees";
        }
        model.addAttribute("Error", "Valid access data");
        model.addAttribute("id", id);
        return "update-employee-access";
    }
    
    /*
     * 
     * update patients info like (name-age-phone number)
     * 
     * */
    
    
    /*
     * 
     * create patient examination info
     * 
     * */
    
    
    
    /*
     * 
     * update patient examination info like (status-medecine-examination date-
     * re examination date)
     * 
     * */
    
   
    
    /*
     * 
     * delete employees or patients
     * 
     * */

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public String deleteEmployee(@RequestParam int id){
    	employeeAccessDao.deleteEmployeeAccess(id);
        employeeDao.deleteEmployee(id);
        return "redirect:/getAllEmployees";
    }
    
    @RequestMapping(value = "/deletePatient", method = RequestMethod.GET)
    public String deletePatient(@RequestParam int id){
    	patientExaInfoDao.deleteAllExaForOnePatient(id);
        patientDao.delete_patient(id);
        return "redirect:/docPatientsList";
    }
    
    /*
     * 
     * delete examination info
     * 
     * */
    
    @GetMapping("/docExaList")
    public String doctorExaList(Model model) {
    	model.addAttribute("info", patientExaInfoDao.getAll());
    	return "doctor-patient-exa-info";
    }
    
    @GetMapping("/delExaInfo")
    public String delExaInfo(@RequestParam int id) {
    	patientExaInfoDao.delete_patient_exa_info(id);
    	return "redirect:/docExaList";
    }

    
    /*
     * 
     * edit employee info
     * 
     * */
    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public String editEmployee(@RequestParam int id, Model model){
        model.addAttribute("employee", employeeDao.getByID(id));
        return "update-employee";
    }
    
    @RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
    public String editEmployee(
        @RequestParam int id, @RequestParam String fName, 
        @RequestParam String lName,
        @RequestParam String fDay, @RequestParam float salary,
        @RequestParam float bonus, @RequestParam float discount,
        @RequestParam String pNumber, @RequestParam int age, Model model
        ){
        Employee employee = 
        new Employee(fName, lName, fDay, salary,
         bonus, discount, pNumber, age);
        EmployeeValidation employeeValidation = new EmployeeValidation();
        
        if(!employeeValidation.validateName(fName)){
            model.addAttribute("Error", "Check your first name");
            model.addAttribute("employee", employeeDao.getByID(id));
            return "update-employee";
        }else if(!employeeValidation.validateName(lName)){
            model.addAttribute("Error", "Check your last name");
            model.addAttribute("employee", employeeDao.getByID(id));
            return "update-employee";
        }else if(!employeeValidation.validateAge(age)){
            model.addAttribute("Error", "age must be >=12 and <=90");
            return "update-employee";
        }else if(!employeeValidation.validatePhoneNumber(pNumber)){
            model.addAttribute("Error", "phone number must be 11 digits"+
            "or this number exists before");
            model.addAttribute("employee", employeeDao.getByID(id));
            return "update-employee";
        }else if(!employeeValidation.salaryValidation(salary)){
            model.addAttribute("Error", "salary must be >=0");
            model.addAttribute("employee", employeeDao.getByID(id));
            return "update-employee";
        }
        if(employeeDao.updateEmployee(id, employee)==0) {
        	model.addAttribute("Error", "Check your data");
            model.addAttribute("employee", employeeDao.getByID(id));
            return "update-employee";
        }
        employeeDao.updateEmployee(id, employee);
        model.addAttribute("id", id);
        return "redirect:/getAllEmployees";
    }

    
    /*
     * 
     * patients list
     * 
     * */
    @RequestMapping(value = "/docPatientsList" , method = RequestMethod.GET)
    public String patientsList(Model model){
        model.addAttribute("patients", patientDao.getAllPatients());
        return "doctor-patient-list";
    }
    
    /*
     * 
     * employees list
     * 
     * */
    @RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
    public String getAllEmployees(Model model){

        model.addAttribute("employees", employeeDao.getAllEmployees());
        return "show-all-employees";

    }
	
}
