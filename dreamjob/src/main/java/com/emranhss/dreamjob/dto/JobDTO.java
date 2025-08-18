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


    public JobDTO(Job job){
       this.id = job.getId();
       this.title = job.getTitle();
       this.description = job.getDescription();
       this.location = job.getLocation();
       this.salary = job.getSalary();
       this.jobType = job.getJobType();
       this.postedDate = job.getPostedDate();

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
}
