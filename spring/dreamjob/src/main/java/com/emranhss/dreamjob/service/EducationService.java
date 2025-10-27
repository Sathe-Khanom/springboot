package com.emranhss.dreamjob.service;

import com.emranhss.dreamjob.dto.EducationDTO;
import com.emranhss.dreamjob.entity.Education;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.repository.EducationRepository;
import com.emranhss.dreamjob.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public List<EducationDTO> getByJobSeekerId(Long jobSeekerId) {
        List<Education> educations = educationRepository.findByJobSeekerId(jobSeekerId);
        return educations.stream()
                .map(EducationDTO :: new)
                .collect(Collectors.toList());
    }

    public Education saveEducation(Education education, String email) {
        JobSeeker jobSeeker = jobSeekerRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("JobSeeker not found"));

        education.setJobSeeker(jobSeeker);

        return educationRepository.save(education);
    }

    public Education updateEducation(Long id, Education updatedEducation, String email) {
        // Get the logged-in job seeker
        JobSeeker jobSeeker = jobSeekerRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("JobSeeker not found"));

        // Fetch existing education
        Education existingEducation = educationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Education record not found with id: " + id));

        // Optional: Ensure the education belongs to the logged-in job seeker
        if (!existingEducation.getJobSeeker().getId().equals(jobSeeker.getId())) {
            throw new SecurityException("You are not authorized to update this education record.");
        }

        // Update fields
        existingEducation.setLevel(updatedEducation.getLevel());
        existingEducation.setInstitute(updatedEducation.getInstitute());
        existingEducation.setBoard(updatedEducation.getBoard());
        existingEducation.setResult(updatedEducation.getResult());
        existingEducation.setYear(updatedEducation.getYear());

        // Save updated education
        return educationRepository.save(existingEducation);
    }



    public void delete(Long id) {
        educationRepository.deleteById(id);
    }


}
