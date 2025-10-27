package com.emranhss.dreamjob.service;

import com.emranhss.dreamjob.dto.JobSeekerDTO;
import com.emranhss.dreamjob.dto.JobSeekerFullDTO;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerService {

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public List<JobSeeker> getAll() {

        return jobSeekerRepository.findAll();
    }

    public Optional<JobSeeker> getById(Long id) {

        return jobSeekerRepository.findById(id);
    }

    public JobSeeker save(JobSeeker jobSeeker) {

        return jobSeekerRepository.save(jobSeeker);
    }

    public void delete(Long id) {

        jobSeekerRepository.deleteById(id);

    }
    public JobSeeker getProfileByUserId(int userId) {
        return jobSeekerRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Job Seeker not found"));
    }






    public JobSeekerFullDTO getJobSeekerFullData(Long id) {
        Optional<JobSeeker> jobSeekerOpt = jobSeekerRepository.findById(id);

        if (jobSeekerOpt.isPresent()) {
            JobSeeker jobSeeker = jobSeekerOpt.get();
            return new JobSeekerFullDTO(jobSeeker); // You can also map educations, experiences, etc. if needed
        } else {
            throw new RuntimeException("JobSeeker not found with id: " + id);
        }
    }








}
