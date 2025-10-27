package com.emranhss.dreamjob.restcontroller;


import com.emranhss.dreamjob.dto.EducationDTO;
import com.emranhss.dreamjob.dto.ExperienceDTO;
import com.emranhss.dreamjob.entity.*;
import com.emranhss.dreamjob.repository.ExperienceRepository;
import com.emranhss.dreamjob.repository.IUserRepo;
import com.emranhss.dreamjob.service.ExperienceService;
import com.emranhss.dreamjob.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/experience/")
public class ExperienceRestController {

 @Autowired
 private ExperienceService experienceService;

 @Autowired
    private JobSeekerService jobSeekerService;
 @Autowired
 private IUserRepo userRepo;


    @PostMapping("add")
    public ResponseEntity<Experience> addExperience(@RequestBody Experience experience, Authentication authentication) {
        String email = authentication.getName();  // Logged-in user's email
        Experience savedExperience = experienceService.saveExperience(experience, email);
        return ResponseEntity.ok(savedExperience);
    }

    @GetMapping("all")
    public ResponseEntity<List<ExperienceDTO>> getEducationsByJobSeeker(Authentication authentication) {
        // Get logged-in user email
        String email = authentication.getName();

        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        JobSeeker jobSeeker = jobSeekerService.getProfileByUserId(user.getId());


        List<ExperienceDTO> educations = experienceService.getByJobSeekerId(jobSeeker.getId());


        return ResponseEntity.ok(educations);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Experience> updateExperience(@PathVariable Long id,
                                                   @RequestBody Experience updatedExperience,
                                                   Authentication authentication) {
        String email = authentication.getName();
        Experience updated = experienceService.updateExperience(id, updatedExperience, email);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Long id) {
        experienceService.delete(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }





}
