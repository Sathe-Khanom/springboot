package com.emranhss.dreamjob.service;

import com.emranhss.dreamjob.dto.EducationDTO;
import com.emranhss.dreamjob.dto.ExperienceDTO;
import com.emranhss.dreamjob.entity.Education;
import com.emranhss.dreamjob.entity.Experience;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.repository.ExperienceRepository;
import com.emranhss.dreamjob.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public List<ExperienceDTO> getByJobSeekerId(Long jobSeekerId) {
        List<Experience> experiences = experienceRepository.findByJobSeekerId(jobSeekerId);
        return experiences.stream()
                .map(ExperienceDTO :: new)
                .collect(Collectors.toList());
    }

    public Experience saveExperience(Experience experience, String email) {
        JobSeeker jobSeeker = jobSeekerRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("JobSeeker not found"));

        experience.setJobSeeker(jobSeeker);

        return experienceRepository.save(experience);
    }

    public void delete(Long id) {
        experienceRepository.deleteById(id);
    }
}
