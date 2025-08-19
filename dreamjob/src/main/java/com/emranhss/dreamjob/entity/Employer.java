package com.emranhss.dreamjob.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(nullable = false, length = 150)
    private String companyName;

    @Column(length = 50)
    private String contactPerson;

    @Column(length = 100)
    private String email;

    private String password;

    @Column(length = 50)
    private String phone;

    @Column(length = 200)
    private String companyAddress;

    @Column(length = 200)
    private String companyWebsite;

    private String industryType;
    private String logo;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Job> jobs = new ArrayList<>();


    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)

    private User user;

    public Employer() {
    }


    public Employer(Long id, String companyName, String contactPerson, String email, String password, String phone, String companyAddress, String companyWebsite, String industryType, String logo, List<Job> jobs, User user) {
        this.id = id;
        this.companyName = companyName;
        this.contactPerson = contactPerson;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.companyAddress = companyAddress;
        this.companyWebsite = companyWebsite;
        this.industryType = industryType;
        this.logo = logo;
        this.jobs = jobs;
        this.user = user;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
