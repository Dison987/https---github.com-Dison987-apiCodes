package com.crud.test.rest.profileData;



public class Skill {
    
    private long skill_id;
    private long seller_id;
    private String skill_proficient_type;
    private long skill_proficient_id;
    private String skill_name;


 



    public Skill(long skill_id, long seller_id, String skill_proficient_type, String skill_name) {
        this.skill_id = skill_id;
        this.seller_id = seller_id;
        this.skill_proficient_type = skill_proficient_type;
        this.skill_name = skill_name;
    }

    public Skill(){
        
    }
    
    public long getSkill_id() {
        return skill_id;
    }
    public void setSkill_id(long skill_id) {
        this.skill_id = skill_id;
    }
    public long getSeller_id() {
        return seller_id;
    }
    public void setSeller_id(long seller_id) {
        this.seller_id = seller_id;
    }
    public String getSkill_proficient_type() {
        return skill_proficient_type;
    }
    public void setSkill_proficient_type(String skill_proficient_type) {
        this.skill_proficient_type =skill_proficient_type;
    }
    public long getSkill_proficient_id() {
        return skill_proficient_id;
    }
    public void setSkill_proficient_id(long skill_proficient_id) {
        this.skill_proficient_id = skill_proficient_id;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }
 


 


    

    


    

    
}
