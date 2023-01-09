package com.crud.test.rest.educationData;

import java.sql.Date;

public class Edu {
    
    private long education_id;
    private long seller_id;
    private long qualification_id;
    private String qualification_type;
    private String university;
    private Date graduation_date;
    private String field_of_study;
    private long cgpa;


    public Edu(long education_id, long seller_id, String qualification_type, String university, Date graduation_date,
            String field_of_study, long cgpa) {
        this.education_id = education_id;
        this.seller_id = seller_id;
        this.qualification_type = qualification_type;
        this.university = university;
        this.graduation_date = graduation_date;
        this.field_of_study = field_of_study;
        this.cgpa = cgpa;
    }

 public Edu(){

 }

public long getEducation_id() {
    return education_id;
}

public void setEducation_id(long education_id) {
    this.education_id = education_id;
}

public long getSeller_id() {
    return seller_id;
}

public void setSeller_id(long seller_id) {
    this.seller_id = seller_id;
}

public long getQualification_id() {
    return qualification_id;
}

public void setQualification_id(long qualification_id) {
    this.qualification_id = qualification_id;
}

public String getUniversity() {
    return university;
}

public void setUniversity(String university) {
    this.university = university;
}

public Date getGraduation_date() {
    return graduation_date;
}

public void setGraduation_date(Date graduation_date) {
    this.graduation_date = graduation_date;
}

public String getField_of_study() {
    return field_of_study;
}

public void setField_of_study(String field_of_study) {
    this.field_of_study = field_of_study;
}

public long getCgpa() {
    return cgpa;
}

public void setCgpa(long cgpa) {
    this.cgpa = cgpa;
}

public String getQualification_type() {
    return qualification_type;
}

public void setQualification_type(String qualification_type) {
    this.qualification_type = qualification_type;
}
 
 



   

 


    

    


    

    
}
