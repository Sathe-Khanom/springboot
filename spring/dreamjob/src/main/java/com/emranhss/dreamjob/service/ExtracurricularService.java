package com.emranhss.dreamjob.service;


import com.emranhss.dreamjob.dto.ExtracurricularDTO;
import com.emranhss.dreamjob.entity.Experience;
import com.emranhss.dreamjob.entity.Extracurricular;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.repository.ExtracurricularRepository;
import com.emranhss.dreamjob.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExtracurricularService {

    @Autowired
    private ExtracurricularRepository extracurricularRepository;

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public List<ExtracurricularDTO> getByJobSeekerId(Long jobSeekerId) {
        List<Extracurricular> extracurriculars = extracurricularRepository.findByJobSeekerId(jobSeekerId);
        return extracurriculars.stream()
                .map(ExtracurricularDTO :: new)
                .collect(Collectors.toList());
    }

    public Extracurricular saveExtracurricular(Extracurricular extracurricular, String email) {
        JobSeeker jobSeeker = jobSeekerRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("JobSeeker not found"));

        extracurricular.setJobSeeker(jobSeeker);

        return extracurricularRepository.save(extracurricular);   }

    public Extracurricular updateExtracurricular(Long id, Extracurricular updatedExtracurricular, String email) {
        // Get the logged-in job seeker
        JobSeeker jobSeeker = jobSeekerRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("JobSeeker not found"));

        // Fetch existing education
        Extracurricular existingExtracurricular = extracurricularRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Experience record not found with id: " + id));

        // Optional: Ensure the education belongs to the logged-in job seeker
        if (!existingExtracurricular.getJobSeeker().getId().equals(jobSeeker.getId())) {
            throw new SecurityException("You are not authorized to update this Experience record.");
        }

        // Update fields
        existingExtracurricular.setTitle(updatedExtracurricular.getTitle());
        existingExtracurricular.setRole(updatedExtracurricular.getRole());
        existingExtracurricular.setDescription(updatedExtracurricular.getDescription());



        // Save updated education
        return extracurricularRepository.save(existingExtracurricular);
    }

    public void delete(Long id) {
        extracurricularRepository.deleteById(id);
    }
}
