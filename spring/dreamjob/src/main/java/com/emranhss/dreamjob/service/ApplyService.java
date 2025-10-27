package com.emranhss.dreamjob.service;


import com.emranhss.dreamjob.dto.ApplyDTO;
import com.emranhss.dreamjob.entity.Apply;
import com.emranhss.dreamjob.entity.Employer;
import com.emranhss.dreamjob.entity.Job;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.repository.ApplyRepository;
import com.emranhss.dreamjob.repository.EmployerRepository;
import com.emranhss.dreamjob.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplyService {

    @Autowired
    ApplyRepository applyRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private EmployerRepository employerRepository;

    public Apply createApplication(Apply apply, JobSeeker jobSeeker) {



        Job job = jobRepository.findById(apply.getJob().getId())
                .orElseThrow(()-> new RuntimeException("Job Not Found"));

        Employer employer= employerRepository.findById(apply.getEmployer().getId())
                .orElseThrow(()-> new RuntimeException("Employeer Not Found"));

        apply.setJob(job);
        apply.setEmployer(employer);

        apply.setJobSeeker(jobSeeker);

        return applyRepository.save(apply);
    }





    // Get all applications
    public List<Apply> getAllApplications() {
        return applyRepository.findAll();
    }

    // Get application by ID
    public Optional<Apply> getApplicationById(Long id) {
        return applyRepository.findById(id);
    }

    // Update an application
    public Apply updateApplication(Long id, Apply updatedApply) {
        return applyRepository.findById(id)
                .map(existingApply -> {
                    existingApply.setJob(updatedApply.getJob());
                    existingApply.setJobSeeker(updatedApply.getJobSeeker());
                    existingApply.setEmployer(updatedApply.getEmployer());
                    return applyRepository.save(existingApply);
                })
                .orElseThrow(() -> new RuntimeException("Application not found with ID: " + id));
    }

    // Delete an application
    public void deleteApplication(Long id) {
        applyRepository.deleteById(id);
    }





    public ApplyDTO mapToDTO(Apply apply) {
        return new ApplyDTO(
                apply.getId(),
                apply.getJob().getId(),
                apply.getJob().getTitle(),
                apply.getEmployer().getId(),
                apply.getEmployer().getCompanyName(),
                apply.getJobSeeker().getId(),
                apply.getJobSeeker().getName()
        );
    }





    public List<ApplyDTO> getAppliesByJobSeeker(Long jobSeekerId) {
        return applyRepository.findByJobSeeker_Id(jobSeekerId)
                .stream()
                .map(apply -> new ApplyDTO(
                        apply.getId(),
                        apply.getJob().getId(),
                        apply.getJob().getTitle(),
                        apply.getEmployer().getId(),
                        apply.getEmployer().getCompanyName(),
                        apply.getJobSeeker().getId(),
                        apply.getJobSeeker().getName()
                ))
                .collect(Collectors.toList());
    }




    public List<ApplyDTO> getApplicationsByJob(Long employerId, Long jobId) {
        List<Apply> applies = applyRepository.findAllByEmployerAndJob(employerId, jobId);
        return applies.stream().map(this::mapToDTO1).collect(Collectors.toList());
    }




    public ApplyDTO mapToDTO1(Apply apply) {
        return new ApplyDTO(
                apply.getId(),
                apply.getJob().getId(),
                apply.getJob().getTitle(),
                apply.getEmployer().getId(),
                apply.getEmployer().getCompanyName(),
                apply.getJobSeeker().getId(),
                apply.getJobSeeker().getName(),
                apply.getJobSeeker().getPhone(),
                apply.getJobSeeker().getEmail()

        );
    }


}
