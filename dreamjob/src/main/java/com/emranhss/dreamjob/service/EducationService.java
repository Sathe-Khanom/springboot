package com.emranhss.dreamjob.service;

import com.emranhss.dreamjob.entity.Education;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.repository.EducationRepository;
import com.emranhss.dreamjob.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public List<Education> getByJobSeekerId(Long jobSeekerId) {
        List<Education> educations = educationRepository.findByJobSeekerId(jobSeekerId);
        return educations.stream()
                .map(Education :: new)
                .collect(Collectors.toList());
    }

    public Education saveEducation(Education education, String email) {
        JobSeeker jobSeeker = jobSeekerRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("JobSeeker not found"));

        education.setJobSeeker(jobSeeker);

        return educationRepository.save(education);
    }

    public void delete(Long id) {
        educationRepository.deleteById(id);
    }


}
