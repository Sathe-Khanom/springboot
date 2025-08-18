package com.emranhss.dreamjob.service;


import com.emranhss.dreamjob.dto.JobDTO;
import com.emranhss.dreamjob.entity.Employer;
import com.emranhss.dreamjob.entity.Job;
import com.emranhss.dreamjob.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;



    public List<Job> getAll() {
        return jobRepository.findAll();
    }

    public Optional<Job> getById(Long id) {
        return jobRepository.findById(id);
    }

    public Job save(Job job) {
        return jobRepository.save(job);
    }

    public void delete(Long id) {
        jobRepository.deleteById(id);
    }

    public List<JobDTO> getProfileByEmployerId(long employerId) {
       List <Job> jobs = jobRepository.findByEmployerId(employerId);
       return jobs.stream()
               .map(JobDTO:: new)
               .collect(Collectors.toList());
    }



}
