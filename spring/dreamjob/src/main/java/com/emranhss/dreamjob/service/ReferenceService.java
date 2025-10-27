package com.emranhss.dreamjob.service;

import com.emranhss.dreamjob.dto.RefferenceDTO;
import com.emranhss.dreamjob.entity.Hobby;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.entity.Refference;
import com.emranhss.dreamjob.repository.JobSeekerRepository;
import com.emranhss.dreamjob.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReferenceService {

    @Autowired
    private ReferenceRepository referenceRepository;

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public List<RefferenceDTO> getByJobSeekerId(Long jobSeekerId) {
        List<Refference> refferences = referenceRepository.findByJobSeekerId(jobSeekerId);
        return refferences.stream()
                .map(RefferenceDTO :: new)
                .collect(Collectors.toList());
    }

    public Refference saveRefference(Refference refference, String email) {
        JobSeeker jobSeeker = jobSeekerRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("JobSeeker not found"));

        refference.setJobSeeker(jobSeeker);

        return referenceRepository.save(refference);
    }

    public Refference updateRefference(Long id, Refference updatedRefference, String email) {
        // Get the logged-in job seeker
        JobSeeker jobSeeker = jobSeekerRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("JobSeeker not found"));

        // Fetch existing education
        Refference existingRefference = referenceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Refference record not found with id: " + id));

        // Optional: Ensure the education belongs to the logged-in job seeker
        if (!existingRefference.getJobSeeker().getId().equals(jobSeeker.getId())) {
            throw new SecurityException("You are not authorized to update this Refference record.");
        }

        // Update fields
        existingRefference.setName(updatedRefference.getName());

        // Save updated education
        return referenceRepository.save(existingRefference);
    }


    public void delete(Long id) {
        referenceRepository.deleteById(id);
    }
}
