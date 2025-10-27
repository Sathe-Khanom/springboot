package com.emranhss.dreamjob.service;

import com.emranhss.dreamjob.dto.EducationDTO;
import com.emranhss.dreamjob.dto.ExperienceDTO;
import com.emranhss.dreamjob.entity.Education;
import com.emranhss.dreamjob.entity.Experience;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.entity.Training;
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

    public Experience updateExperience(Long id, Experience updatedExperience, String email) {
        // Get the logged-in job seeker
        JobSeeker jobSeeker = jobSeekerRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("JobSeeker not found"));

        // Fetch existing education
        Experience existingExperience = experienceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Experience record not found with id: " + id));

        // Optional: Ensure the education belongs to the logged-in job seeker
        if (!existingExperience.getJobSeeker().getId().equals(jobSeeker.getId())) {
            throw new SecurityException("You are not authorized to update this Experience record.");
        }

        // Update fields
        existingExperience.setCompany(updatedExperience.getCompany());
        existingExperience.setPosition(updatedExperience.getPosition());
        existingExperience.setFromDate(updatedExperience.getFromDate());
        existingExperience.setToDate(updatedExperience.getToDate());
        existingExperience.setDescription(updatedExperience.getDescription());


        // Save updated education
        return experienceRepository.save(existingExperience);
    }


    public void delete(Long id) {
        experienceRepository.deleteById(id);
    }
}
