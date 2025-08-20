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
import java.util.Optional;
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





}




