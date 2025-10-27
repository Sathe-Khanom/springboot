package com.emranhss.dreamjob.service;

import com.emranhss.dreamjob.dto.SkillDTO;
import com.emranhss.dreamjob.dto.TrainingDTO;
import com.emranhss.dreamjob.entity.Education;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.entity.Skill;
import com.emranhss.dreamjob.entity.Training;
import com.emranhss.dreamjob.repository.JobSeekerRepository;
import com.emranhss.dreamjob.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public List<TrainingDTO> getByJobSeekerId(Long jobSeekerId) {
        List<Training> trainings = trainingRepository.findByJobSeekerId(jobSeekerId);
        return trainings.stream()
                .map(TrainingDTO :: new)
                .collect(Collectors.toList());
    }

    public Training saveTraining(Training training, String email) {
        JobSeeker jobSeeker = jobSeekerRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("JobSeeker not found"));

        training.setJobSeeker(jobSeeker);

        return trainingRepository.save(training);
    }

    public Training updateTraining(Long id, Training updatedTraining, String email) {
        // Get the logged-in job seeker
        JobSeeker jobSeeker = jobSeekerRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("JobSeeker not found"));

        // Fetch existing education
        Training existingTraining = trainingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Training record not found with id: " + id));

        // Optional: Ensure the education belongs to the logged-in job seeker
        if (!existingTraining.getJobSeeker().getId().equals(jobSeeker.getId())) {
            throw new SecurityException("You are not authorized to update this Training record.");
        }

        // Update fields
        existingTraining.setTitle(updatedTraining.getTitle());
        existingTraining.setInstitute(updatedTraining.getInstitute());
        existingTraining.setDuration(updatedTraining.getDuration());
        existingTraining.setDescription(updatedTraining.getDescription());


        // Save updated education
        return trainingRepository.save(existingTraining);
    }


    public void delete(Long id) {
        trainingRepository.deleteById(id);
    }

}
