package com.clinic.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinic.dao.PatientDao;
import com.clinic.dao.PatientExaInfoDao;
import com.clinic.models.Patient_exa_info;



@Controller
public class ReportsController {
	
	@Autowired
	PatientExaInfoDao patientExaInfoDao;
	@Autowired
	PatientDao patientDao;
	
	@GetMapping("/reportForm")
	public String patientReportsForm(Model model) {

		List<Integer> ids = patientDao.getAllIds();
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(int i=0; i<ids.size(); i++) {
			String fName=patientDao.getById(ids.get(i)).getFirst_name()+' ';
			String lName=patientDao.getById(ids.get(i)).getLast_name();
			map.put(ids.get(i), fName+lName);
		}
		System.out.println(ids);
		System.out.println(map);
		model.addAttribute("map", map);
		return("reportsForm");
	}

	@GetMapping("/patientReport")
	public String getPatientReports(@RequestParam int id, Model model) {
		
		if(patientDao.getById(id) == null) {
			model.addAttribute("Error", "Invalid patient");
			return("reportsForm");
		}
		List<Patient_exa_info> exaInfo = patientExaInfoDao.allPatientVisits(id);
		model.addAttribute("patientInfo", patientDao.getById(id));
		model.addAttribute("exaInfo", exaInfo);
		model.addAttribute("Error", "No Examination info found for this patient");
		return("reportList");
		
	}
	
	
}
