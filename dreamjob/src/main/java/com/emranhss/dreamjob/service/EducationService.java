package com.emranhss.dreamjob.service;

import com.emranhss.dreamjob.entity.Education;
import com.emranhss.dreamjob.repository.EducationRepository;
import com.emranhss.dreamjob.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public List<Education> getByJobSeekerId(Long jobSeekerId) {
        return educationRepository.findByJobSeekerId(jobSeekerId);
    }

    public Education save(Education education) {
        return educationRepository.save(education);
    }

    public void delete(Long id) {
        educationRepository.deleteById(id);
    }

}
