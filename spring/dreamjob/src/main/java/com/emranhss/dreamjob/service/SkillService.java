package com.emranhss.dreamjob.service;


import com.emranhss.dreamjob.dto.RefferenceDTO;
import com.emranhss.dreamjob.dto.SkillDTO;
import com.emranhss.dreamjob.entity.Hobby;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.entity.Refference;
import com.emranhss.dreamjob.entity.Skill;
import com.emranhss.dreamjob.repository.JobSeekerRepository;
import com.emranhss.dreamjob.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public List<SkillDTO> getByJobSeekerId(Long jobSeekerId) {
        List<Skill> skills = skillRepository.findByJobSeekerId(jobSeekerId);
        return skills.stream()
                .map(SkillDTO :: new)
                .collect(Collectors.toList());
    }

    public Skill saveSkill(Skill skill, String email) {
        JobSeeker jobSeeker = jobSeekerRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("JobSeeker not found"));

        skill.setJobSeeker(jobSeeker);

        return skillRepository.save(skill);
    }


    public Skill updateSkill(Long id, Skill updatedSkill, String email) {
        // Get the logged-in job seeker
        JobSeeker jobSeeker = jobSeekerRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("JobSeeker not found"));

        // Fetch existing education
        Skill existingSkill = skillRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Skill record not found with id: " + id));

        // Optional: Ensure the education belongs to the logged-in job seeker
        if (!existingSkill.getJobSeeker().getId().equals(jobSeeker.getId())) {
            throw new SecurityException("You are not authorized to update this Skill record.");
        }

        // Update fields
        existingSkill.setName(updatedSkill.getName());




        // Save updated education
        return skillRepository.save(existingSkill);
    }


    public void delete(Long id) {
        skillRepository.deleteById(id);
    }

}
