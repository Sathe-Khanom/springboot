package com.emranhss.dreamjob.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Double salary;

    @Column(length = 50)
    private String jobType; // Full-time, Part-time, Contract

    private Date postedDate;

    private Date endDate;

    @Column(length = 2000)
    private String keyresponsibility;

    @Column(length = 2000)
    private String edurequirement;

    @Column(length = 2000)
    private String exprequirement;

    @Column(length = 2000)
    private String benefits;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id", nullable = false)
    private Employer employer;



    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Job() {
    }

    public Job(Long id, String title, String description, Double salary, String jobType, Date postedDate, Date endDate, String keyresponsibility, String edurequirement, String exprequirement, String benefits) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.jobType = jobType;
        this.postedDate = postedDate;
        this.endDate = endDate;
        this.keyresponsibility = keyresponsibility;
        this.edurequirement = edurequirement;
        this.exprequirement = exprequirement;
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

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
