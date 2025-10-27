package com.emranhss.dreamjob.dto;

import com.emranhss.dreamjob.entity.JobSeeker;

import java.util.Date;

public class JobSeekerDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private String address;
    private Date dateOfBirth;
    private String photo;

    // Constructor
    public JobSeekerDTO(JobSeeker jobSeeker) {
        this.id = jobSeeker.getId();
        this.name = jobSeeker.getName();
        this.email = jobSeeker.getEmail();
        this.phone = jobSeeker.getPhone();
        this.gender = jobSeeker.getGender();
        this.address = jobSeeker.getAddress();
        this.dateOfBirth = jobSeeker.getDateOfBirth();
        this.photo = jobSeeker.getPhoto();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
