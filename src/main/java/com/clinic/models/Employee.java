package com.clinic.models;

public class Employee {
    
    private int emp_id;
    private String first_name;
    private String last_name;
    private String first_day_work;
    private float salary;
    private float bonus;
    private float discount;
    private String phone_number;
    private int age;

    public Employee(){
        
    }

    public Employee(String first_name, String last_name, String first_day_work, float salary, float bonus,
            float discount, String phone_number, int age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.first_day_work = first_day_work;
        this.salary = salary;
        this.bonus = bonus;
        this.discount = discount;
        this.phone_number = phone_number;
        this.age = age;
    }
    public int getEmp_id() {
        return emp_id;
    }
    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
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
    public String getFirst_day_work() {
        return first_day_work;
    }
    public void setFirst_day_work(String first_day_work) {
        this.first_day_work = first_day_work;
    }
    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
    public float getBonus() {
        return bonus;
    }
    public void setBonus(float bonus) {
        this.bonus = bonus;
    }
    public float getDiscount() {
        return discount;
    }
    public void setDiscount(float discount) {
        this.discount = discount;
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
        return "Employee [emp_id=" + emp_id + ", first_name=" + 
        first_name + ", last_name=" + last_name
        + ", first_day_work=" + first_day_work + ", salary=" +
        salary + ", bonus=" + bonus + ", discount="
        + discount + ", phone_number=" + phone_number +
        ", age=" + age + "]";
    }

    

    


}
