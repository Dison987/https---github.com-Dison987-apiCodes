package com.crud.test.rest;



public class Seller {
    
    private long user_id;
    private long seller_id;
    private String sellerName;
    private String dof;
    private String telNo;
    private String address;
    private long stateID;
    private String occupation;
    private String expectedSalary;
    private String workExp;


 


   
    public Seller(long user_id, long seller_id, String sellerName, String dof, String telNo, String address,
            long stateID, String occupation, String expectedSalary, String workExp) {
        this.user_id = user_id;
        this.seller_id = seller_id;
        this.sellerName = sellerName;
        this.dof = dof;
        this.telNo = telNo;
        this.address = address;
        this.stateID = stateID;
        this.occupation = occupation;
        this.expectedSalary = expectedSalary;
        this.workExp = workExp;
    }
    
    public Seller(){

    }
    public long getUser_id() {
        return user_id;
    }
    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
    public String getSellerName() {
        return sellerName;
    }
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
    public String getDof() {
        return dof;
    }
    public void setDof(String dof) {
        this.dof = dof;
    }
    public String getTelNo() {
        return telNo;
    }
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public long getStateID() {
        return stateID;
    }
    public void setStateID(long stateID) {
        this.stateID = stateID;
    }
    public String getOccupation() {
        return occupation;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public String getExpectedSalary() {
        return expectedSalary;
    }
    public void setExpectedSalary(String expectedSalary) {
        this.expectedSalary = expectedSalary;
    }
    public String getWorkExp() {
        return workExp;
    }
    public void setWorkExp(String workExp) {
        this.workExp = workExp;
    }


    public long getSeller_id() {
        return seller_id;
    }


    public void setSeller_id(long seller_id) {
        this.seller_id = seller_id;
    }

    

    


    

    
}
