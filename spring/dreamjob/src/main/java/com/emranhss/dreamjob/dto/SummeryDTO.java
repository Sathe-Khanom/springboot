package com.emranhss.dreamjob.dto;

import com.emranhss.dreamjob.entity.Summery;

public class SummeryDTO {

    private Long id;
    private String fatherName;
    private String motherName;
    private String nationality;
    private String religion;
    private String bloodGroup;
    private String height;
    private String weight;
    private String nid;
    private String description;

    public SummeryDTO(Summery summery){
        this.id= summery.getId();
        this.fatherName= summery.getFatherName();
        this.motherName= summery.getMotherName();
        this.nationality= summery.getNationality();
        this.religion= summery.getReligion();
        this.bloodGroup= summery.getBloodGroup();
        this.height= summery.getHeight();
        this.weight= summery.getWeight();
        this.nid= summery.getNid();
        this.description= summery.getDescription();


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
