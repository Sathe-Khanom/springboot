package com.emranhss.dreamjob.dto;

import com.emranhss.dreamjob.entity.Job;
import java.util.Date;

public class JobDTO {

    private Long id;
    private String title;
    private String description;
    private String location;
    private Double salary;
    private String jobType;
    private Date postedDate;

    // Employer info
    private Long employerId;
    private String companyName;
    private String contactPerson;
    private String email;
    private String phone;
    private String companyWebsite;
    private String logo;


    public JobDTO(Job job) {
        this.id = job.getId();
        this.title = job.getTitle();
        this.description = job.getDescription();
        this.location = job.getLocation();
        this.salary = job.getSalary();
        this.jobType = job.getJobType();
        this.postedDate = job.getPostedDate();

        if (job.getEmployer() != null) {
            this.employerId = job.getEmployer().getId();
            this.companyName = job.getEmployer().getCompanyName();
            this.contactPerson = job.getEmployer().getContactPerson();
            this.email = job.getEmployer().getEmail();
            this.phone = job.getEmployer().getPhone();
            this.companyWebsite = job.getEmployer().getCompanyWebsite();
            this.logo = job.getEmployer().getLogo();

        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Long getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Long employerId) {
        this.employerId = employerId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
