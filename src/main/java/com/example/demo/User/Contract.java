package com.example.demo.User;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String name = "";

    @Column(length = 20, nullable = false, columnDefinition = "1")
    public String ip = "";

    private String telephone = "";

    private String company = "";

    private String building_type = "";

    private String description = "";

    public String getName() {
        return name;
    }

    // public String getCompany() {
    //     return name;
    // }

    // Contract() {
    //     this.name = "";
    //     this.telephone = "";
    //     this.company = "";
    //     this.building_type = "";
    //     this.description = "";
    // } 

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setcompany(String company) {
        this.company = company;
    }

    public void setBuildingType(String building_type) {
        this.building_type = building_type;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}