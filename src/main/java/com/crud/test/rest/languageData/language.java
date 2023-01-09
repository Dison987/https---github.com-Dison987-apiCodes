package com.crud.test.rest.languageData;


public class language {
    
    private long language_id;
    private long seller_id;
    private long language_type_id;
    private long language_proficient_id;
    private String language_name;
    private String language_proficient_level;

    public language(long language_id, long seller_id, String language_name, String language_proficient_level) {
        this.language_id = language_id;
        this.seller_id = seller_id;
        this.language_name = language_name;
        this.language_proficient_level = language_proficient_level;
    }

    public language(){

    }

    public long getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(long language_id) {
        this.language_id = language_id;
    }

    public long getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(long seller_id) {
        this.seller_id = seller_id;
    }

    public long getLanguage_type_id() {
        return language_type_id;
    }

    public void setLanguage_type_id(long language_type_id) {
        this.language_type_id = language_type_id;
    }

    public long getLanguage_proficient_id() {
        return language_proficient_id;
    }

    public void setLanguage_proficient_id(long language_proficient_id) {
        this.language_proficient_id = language_proficient_id;
    }

    public String getLanguage_name() {
        return language_name;
    }

    public void setLanguage_name(String language_name) {
        this.language_name = language_name;
    }

    public String getLanguage_proficient_level() {
        return language_proficient_level;
    }

    public void setLanguage_proficient_level(String language_proficient_level) {
        this.language_proficient_level = language_proficient_level;
    }

    
   




    


    

    
}
