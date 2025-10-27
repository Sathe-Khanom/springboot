package com.emranhss.dreamjob.service;


import com.emranhss.dreamjob.dto.JobDTO;
import com.emranhss.dreamjob.entity.*;
import com.emranhss.dreamjob.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;


    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public List<JobDTO> getJobsByEmployerEmail(String email) {
        Employer employer = employerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employer not found"));

        List<Job> jobs = jobRepository.findByEmployer(employer);

        return jobs.stream()
                .map(JobDTO::new)
                .collect(Collectors.toList());
    }





    public Job saveJob(Job job, String email) {
        Employer employer = employerRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Employer not found"));

        job.setEmployer(employer);

       Location location= locationRepository.findById(job.getLocation().getId())
                .orElseThrow(() -> new UsernameNotFoundException("Location not found"));

        Category category = categoryRepository.findById(job.getCategory().getId())
                .orElseThrow(() -> new UsernameNotFoundException("Category not found"));

        return jobRepository.save(job);
    }



    public void delete(Long id) {
        jobRepository.deleteById(id);
    }


    public List<JobDTO> getJobs() {
        List<Job> jobs = jobRepository.findAll(); // fetch all Job entities
        return jobs.stream()                     // create a Stream<Job>
                .map(JobDTO::new)            // convert each Job to JobDTO via constructor
                .collect(Collectors.toList());// collect back to a List<JobDTO>
    }


    public JobDTO getJobById(Long id) {
        Optional<Job> jobOpt = jobRepository.findById(id);
        if (jobOpt.isPresent()) {
            return new JobDTO(jobOpt.get()); // convert Job entity to JobDTO
        } else {
            return null; // or throw an exception if you prefer
        }
    }


    public List<JobDTO> searchJobs(Long locationId, Long categoryId) {
        List<Job> jobs;

        if (locationId != null && categoryId != null) {
            jobs = jobRepository.findByLocationIdAndCategoryId(locationId, categoryId);
        } else if (locationId != null) {
            jobs = jobRepository.findByLocationId(locationId);
        } else if (categoryId != null) {
            jobs = jobRepository.findByCategoryId(categoryId);
        } else {
            jobs = jobRepository.findAll();
        }

        return jobs.stream().map(JobDTO::new).toList();
    }

//    // Fetch jobs by company name
//    public List<Job> getJobsByCompanyName(String companyName) {
//        return jobRepository.findByEmployerCompanyName(companyName);
//    }


    public List<JobDTO> getJobsByCompanyName(String companyName) {
        List<Job> jobs = jobRepository.findByEmployerCompanyName(companyName);
        return jobs.stream().map(JobDTO::new).toList();
    }






}




