package com.emranhss.dreamjob.dto;

import com.emranhss.dreamjob.entity.Job;
import java.util.Date;

public class JobDTO {


    private Long id;
    private String title;
    private String description;
    private Double salary;
    private String jobType;
    private Date postedDate;
    private Date endDate;
    private String keyresponsibility;
    private String edurequirement;
    private String exprequirement;
    private String benefits;

    // Employer info
    private Long employerId;
    private String companyName;
    private String contactPerson;
    private String email;
    private String phone;
    private String companyWebsite;
    private String logo;

    // Category info
    private Long categoryId;
    private String categoryName;

    // Location info
    private Long locationId;
    private String locationName;

    public JobDTO(Job job) {
        this.id = job.getId();
        this.title = job.getTitle();
        this.description = job.getDescription();
        this.salary = job.getSalary();
        this.jobType = job.getJobType();
        this.postedDate = job.getPostedDate();
        this.endDate= job.getEndDate();
        this.keyresponsibility= job.getKeyresponsibility();
        this.edurequirement= job.getEdurequirement();
        this.exprequirement= job.getExprequirement();
        this.benefits = job.getBenefits();

        if (job.getEmployer() != null) {
            this.employerId = job.getEmployer().getId();
            this.companyName = job.getEmployer().getCompanyName();
            this.contactPerson = job.getEmployer().getContactPerson();
            this.email = job.getEmployer().getEmail();
            this.phone = job.getEmployer().getPhone();
            this.companyWebsite = job.getEmployer().getCompanyWebsite();
            this.logo = job.getEmployer().getLogo();
        }

        if (job.getCategory() != null) {
            this.categoryId = job.getCategory().getId();
            this.categoryName = job.getCategory().getName(); // Assuming Category has getName()
        }

        if (job.getLocation() != null) {
            this.locationId = job.getLocation().getId();
            this.locationName = job.getLocation().getName(); // Assuming Location has getName()
        }
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getKeyresponsibility() {
        return keyresponsibility;
    }

    public void setKeyresponsibility(String keyresponsibility) {
        this.keyresponsibility = keyresponsibility;
    }

    public String getEdurequirement() {
        return edurequirement;
    }

    public void setEdurequirement(String edurequirement) {
        this.edurequirement = edurequirement;
    }

    public String getExprequirement() {
        return exprequirement;
    }

    public void setExprequirement(String exprequirement) {
        this.exprequirement = exprequirement;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
