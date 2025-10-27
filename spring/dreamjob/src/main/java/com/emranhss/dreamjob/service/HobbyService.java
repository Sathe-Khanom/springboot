package com.emranhss.dreamjob.service;

import com.emranhss.dreamjob.dto.ExtracurricularDTO;
import com.emranhss.dreamjob.dto.HobbyDTO;
import com.emranhss.dreamjob.entity.Extracurricular;
import com.emranhss.dreamjob.entity.Hobby;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.repository.HobbyRepository;
import com.emranhss.dreamjob.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HobbyService {

    @Autowired
    private HobbyRepository hobbyRepository;

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public List<HobbyDTO> getByJobSeekerId(Long jobSeekerId) {
        List<Hobby> hobbies = hobbyRepository.findByJobSeekerId(jobSeekerId);
        return hobbies.stream()
                .map(HobbyDTO :: new)
                .collect(Collectors.toList());
    }

    public Hobby saveHobby(Hobby hobby, String email) {
        JobSeeker jobSeeker = jobSeekerRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("JobSeeker not found"));

        hobby.setJobSeeker(jobSeeker);

        return hobbyRepository.save(hobby);   }


    public Hobby updateHobby(Long id, Hobby updatedHobby, String email) {
        // Get the logged-in job seeker
        JobSeeker jobSeeker = jobSeekerRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("JobSeeker not found"));

        // Fetch existing education
        Hobby existingHobby = hobbyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Hobby record not found with id: " + id));

        // Optional: Ensure the education belongs to the logged-in job seeker
        if (!existingHobby.getJobSeeker().getId().equals(jobSeeker.getId())) {
            throw new SecurityException("You are not authorized to update this Hobby record.");
        }

        // Update fields
        existingHobby.setName(updatedHobby.getName());




        // Save updated education
        return hobbyRepository.save(existingHobby);
    }

    public void delete(Long id) {
        hobbyRepository.deleteById(id);
    }
}
