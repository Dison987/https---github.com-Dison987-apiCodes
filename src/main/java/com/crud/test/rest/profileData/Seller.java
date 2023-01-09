package com.crud.test.rest.profileData;

import java.math.BigDecimal;
import java.sql.Date;

public class Seller {
    
    private long user_id;
    private long seller_id;
    private String seller_name;
    private Date dof;
    private String tel_no;
    private String address;
    private String state_name;
    private long state_id;
    private String occupation;
    private String ex_salary;
    private int work_expyr;


 


    public Seller(long user_id, long seller_id,String seller_name, Date dof, String tel_no, String address, String state_name,
            String occupation, String ex_salary, int work_expyr) {
        this.user_id = user_id;
        this.seller_id = seller_id;
        this.seller_name = seller_name;
        this.dof = dof;
        this.tel_no = tel_no;
        this.address = address;
        this.state_name = state_name;
        this.occupation = occupation;
        this.ex_salary = ex_salary;
        this.work_expyr = work_expyr;
    }
    public Seller(){

    }
    public Seller( long state_id) {
       
        this.state_id = state_id;
    }
    public long getState_id() {
        return state_id;
    }
    public void setState_id(long state_id) {
        this.state_id = state_id;
    }
    public long getUser_id() {
        return user_id;
    }
    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
    public String getSeller_name() {
        return seller_name;
    }
    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }
    public Date getDof() {
        return dof;
    }
    public void setDof(Date dof) {
        this.dof = dof;
    }
    public String getTel_no() {
        return tel_no;
    }
    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getState_name() {
        return state_name;
    }
    public void setState_name(String state_name) {
        this.state_name = state_name;
    }
    public String getOccupation() {
        return occupation;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public String getEx_salary() {
        return ex_salary;
    }
    public void setEx_salary(String ex_salary) {
        this.ex_salary = ex_salary;
    }
    public int getWork_expyr() {
        return work_expyr;
    }
    public void setWork_expyr(int work_expyr) {
        this.work_expyr = work_expyr;
    }


    public long getSeller_id() {
        return seller_id;
    }


    public void setSeller_id(long seller_id) {
        this.seller_id = seller_id;
    }

    

    


    

    
}
