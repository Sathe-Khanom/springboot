package com.emranhss.dreamjob.restcontroller;

import com.emranhss.dreamjob.dto.ExperienceDTO;
import com.emranhss.dreamjob.dto.SummeryDTO;
import com.emranhss.dreamjob.entity.Experience;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.entity.Summery;
import com.emranhss.dreamjob.entity.User;
import com.emranhss.dreamjob.repository.IUserRepo;
import com.emranhss.dreamjob.service.ExperienceService;
import com.emranhss.dreamjob.service.JobSeekerService;
import com.emranhss.dreamjob.service.SummeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/summery/")
public class SummeryRestController {

    @Autowired
    private SummeryService summeryService;

    @Autowired
    private JobSeekerService jobSeekerService;
    @Autowired
    private IUserRepo userRepo;


    @PostMapping("add")
    public ResponseEntity<Summery> addSummery(@RequestBody Summery summery, Authentication authentication) {
        String email = authentication.getName();  // Logged-in user's email
        Summery savedSummery = summeryService.saveSummery(summery, email);
        return ResponseEntity.ok(savedSummery);
    }

    @GetMapping("all")
    public ResponseEntity<List<SummeryDTO>> getSummeryByJobSeeker(Authentication authentication) {
        // Get logged-in user email
        String email = authentication.getName();

        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        JobSeeker jobSeeker = jobSeekerService.getProfileByUserId(user.getId());


        List<SummeryDTO> educations = summeryService.getByJobSeekerId(jobSeeker.getId());


        return ResponseEntity.ok(educations);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Summery> updateSummery(
            @PathVariable Long id,
            @RequestBody Summery updatedSummery,
            Authentication authentication
    ) {
        String email = authentication.getName();
        Summery updated = summeryService.updateSummery(id, updatedSummery, email);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Long id) {
        summeryService.delete(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }


}
