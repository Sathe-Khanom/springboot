package com.emranhss.dreamjob.entity;


import jakarta.persistence.*;

@Entity
public class Employer {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String companyName;
    private String contactPerson;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String website;
    private String industryType;
    private String logo;


    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)

    private User user;

    public Employer() {
    }

    public Employer(Long id, String companyName, String contactPerson, String email, String password, String phoneNumber, String address, String website, String industryType, String logo, User user) {
        this.id = id;
        this.companyName = companyName;
        this.contactPerson = contactPerson;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.website = website;
        this.industryType = industryType;
        this.logo = logo;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
