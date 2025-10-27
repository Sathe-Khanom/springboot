package com.emranhss.dreamjob.dto;

public class ApplyDTO {


    private Long id;
    private Long jobId;
    private String jobTitle;
    private Long employerId;
    private String employerName;
    private Long jobSeekerId;
    private String jobSeekerName;
    private  String phone;
    private  String Email;





    public ApplyDTO() {}


    public ApplyDTO(Long id, Long jobId, String jobTitle, Long employerId, String employerName, Long jobSeekerId, String jobSeekerName, String phone, String email) {
        this.id = id;
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.employerId = employerId;
        this.employerName = employerName;
        this.jobSeekerId = jobSeekerId;
        this.jobSeekerName = jobSeekerName;
        this.phone = phone;
        Email = email;
    }

    public ApplyDTO(Long id, Long jobId, String jobTitle,
                    Long employerId, String employerName,
                    Long jobSeekerId, String jobSeekerName) {
        this.id = id;
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.employerId = employerId;
        this.employerName = employerName;
        this.jobSeekerId = jobSeekerId;
        this.jobSeekerName = jobSeekerName;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getJobId() { return jobId; }
    public void setJobId(Long jobId) { this.jobId = jobId; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public Long getEmployerId() { return employerId; }
    public void setEmployerId(Long employerId) { this.employerId = employerId; }

    public String getEmployerName() { return employerName; }
    public void setEmployerName(String employerName) { this.employerName = employerName; }

    public Long getJobSeekerId() { return jobSeekerId; }
    public void setJobSeekerId(Long jobSeekerId) { this.jobSeekerId = jobSeekerId; }

    public String getJobSeekerName() { return jobSeekerName; }
    public void setJobSeekerName(String jobSeekerName) { this.jobSeekerName = jobSeekerName; }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
