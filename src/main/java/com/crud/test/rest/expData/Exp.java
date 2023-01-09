package com.crud.test.rest.expData;

import java.sql.Date;

public class Exp {
    
    private long experience_id;
    private String job;
    private Date joined_start;
    private Date joined_end;
    private String description;
    private String company_name;
    private long seller_id;
    private long industry_id;
    private String industry_type;




    
    public Exp(long experience_id, String job, Date joined_start, Date joined_end, String description,
            String company_name, long seller_id, String industry_type) {
        this.experience_id = experience_id;
        this.job = job;
        this.joined_start = joined_start;
        this.joined_end = joined_end;
        this.description = description;
        this.company_name = company_name;
        this.seller_id = seller_id;
        this.industry_type = industry_type;
    }
    public Exp(){

    }

    public long getExperience_id() {
        return experience_id;
    }
    public void setExperience_id(long experience_id) {
        this.experience_id = experience_id;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public Date getJoined_start() {
        return joined_start;
    }
    public void setJoined_start(Date joined_start) {
        this.joined_start = joined_start;
    }
    public Date getJoined_end() {
        return joined_end;
    }
    public void setJoined_end(Date joined_end) {
        this.joined_end = joined_end;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCompany_name() {
        return company_name;
    }
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
    public long getSeller_id() {
        return seller_id;
    }
    public void setSeller_id(long seller_id) {
        this.seller_id = seller_id;
    }
    public long getIndustry_id() {
        return industry_id;
    }
    public void setIndustry_id(long industry_id) {
        this.industry_id = industry_id;
    }
    public String getIndustry_type() {
        return industry_type;
    }
    public void setIndustry_type(String industry_type) {
        this.industry_type = industry_type;
    }


   


    

    
}
