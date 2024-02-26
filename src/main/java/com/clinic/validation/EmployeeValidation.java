package com.clinic.validation;

public class EmployeeValidation extends UserValidation {
    
    public boolean salaryValidation(float salary){
        return salary>=0;
    }

}
