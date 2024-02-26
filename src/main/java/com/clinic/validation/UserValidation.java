package com.clinic.validation;

public class UserValidation {
    
    private boolean isChar(char c){
        return c>='A'&&c<='Z' || c>='a'&&c<='z';
    }

    private boolean isName(String s){
        int c=0;
        for(int i=0; i<s.length(); i++){
            if(isChar(s.charAt(i))){
                c++;
            }
        }
        return c==s.length() && c>=3;
    }
    public boolean validateName(String name){

        String[] s = name.split(" ");
        int c=0;
        for(String n:s){
            if(isName(n)){
                c++;
            }
        }
        return c==s.length;
    }

    public boolean validateAge(int age){
        return age>=12 && age<=90;
    }

    public boolean validatePhoneNumber(String p){
        int c=0;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i)>='0'&&p.charAt(i)<='9'){
                c++;
            }
        }
        return c==11;
    }



}
