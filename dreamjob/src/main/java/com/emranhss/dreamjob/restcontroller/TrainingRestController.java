package com.emranhss.dreamjob.restcontroller;

import com.emranhss.dreamjob.dto.SkillDTO;
import com.emranhss.dreamjob.dto.TrainingDTO;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.entity.Skill;
import com.emranhss.dreamjob.entity.Training;
import com.emranhss.dreamjob.entity.User;
import com.emranhss.dreamjob.repository.IUserRepo;
import com.emranhss.dreamjob.service.JobSeekerService;
import com.emranhss.dreamjob.service.SkillService;
import com.emranhss.dreamjob.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/training/")
public class TrainingRestController {

    @Autowired
    private TrainingService trainingService;
    @Autowired
    private JobSeekerService jobSeekerService;
    @Autowired
    private IUserRepo userRepo;

    @PostMapping("add")
    public ResponseEntity<Training> addTraining(@RequestBody Training training, Authentication authentication) {
        String email = authentication.getName();  // Logged-in user's email
        Training savedTraining = trainingService.saveTraining(training, email);
        return ResponseEntity.ok(savedTraining);
    }

    @GetMapping("all")
    public ResponseEntity<List<TrainingDTO>> getTrainingByJobSeeker(Authentication authentication) {
        // Get logged-in user email
        String email = authentication.getName();

        Optional<User> user =userRepo.findByEmail(email);
        JobSeeker jobSeeker = jobSeekerService.getProfileByUserId(user.get().getId());


        List<TrainingDTO> training = trainingService.getByJobSeekerId(jobSeeker.getId());


        return ResponseEntity.ok(training);
    }
}
