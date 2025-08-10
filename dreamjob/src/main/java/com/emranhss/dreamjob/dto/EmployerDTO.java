package com.emranhss.dreamjob.dto;

import com.emranhss.dreamjob.entity.Employer;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.entity.User;

public class EmployerDTO {

    private Long id;
    private String companyName;
    private String companyAddress;


    public EmployerDTO(Employer employer) {
        this.id = employer.getId();
        this.companyName = employer.getCompanyName();
        this.companyAddress = employer.getCompanyAddress();


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

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }
}
