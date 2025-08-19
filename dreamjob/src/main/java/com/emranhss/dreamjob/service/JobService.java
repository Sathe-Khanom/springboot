package com.emranhss.dreamjob.service;


import com.emranhss.dreamjob.dto.JobDTO;
import com.emranhss.dreamjob.entity.Employer;
import com.emranhss.dreamjob.entity.Job;
import com.emranhss.dreamjob.repository.EmployerRepository;
import com.emranhss.dreamjob.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private EmployerRepository employerRepository;

    public List<JobDTO> getJobsByEmployerId(long employerId) {
       List <Job> jobs = jobRepository.findByEmployerId(employerId);
       return jobs.stream()
               .map(JobDTO:: new)
               .collect(Collectors.toList());
    }


    public Job saveJob(Job job, String email) {
        Employer employer = employerRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Employer not found"));

        job.setEmployer(employer);

        return jobRepository.save(job);
    }

    public void delete(Long id) {
        jobRepository.deleteById(id);
    }

}




