package com.emranhss.dreamjob.dto;

import com.emranhss.dreamjob.entity.Employer;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.entity.User;

public class EmployerDTO {

    private Long id;
    private String companyName;
    private String contactPerson;
    private String email;
    private String password;
    private String phoneNumber;
    private String companyAddress;
    private String companyWebsite;
    private String industryType;
    private String logo;


    public EmployerDTO(Employer employer) {

        this.id = employer.getId();
        this.companyName = employer.getCompanyName();
        this.contactPerson = employer.getContactPerson();
        this.email = employer.getEmail();
        this.password = employer.getPassword();
        this.phoneNumber = employer.getPhone();
        this.companyAddress = employer.getCompanyAddress();
        this.companyWebsite = employer.getCompanyWebsite();
        this.industryType = employer.getIndustryType();
        this.logo = employer.getLogo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
