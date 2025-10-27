package com.emranhss.dreamjob.restcontroller;

import com.emranhss.dreamjob.dto.ExtracurricularDTO;
import com.emranhss.dreamjob.dto.HobbyDTO;
import com.emranhss.dreamjob.entity.*;
import com.emranhss.dreamjob.repository.IUserRepo;
import com.emranhss.dreamjob.service.HobbyService;
import com.emranhss.dreamjob.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hobby/")
public class HobbyRestController {

 @Autowired
    private HobbyService hobbyService;
 @Autowired
    private JobSeekerService jobSeekerService;
 @Autowired
    private IUserRepo userRepo;

    @PostMapping("add")
    public ResponseEntity<Hobby> addHobby(@RequestBody Hobby hobby, Authentication authentication) {
        String email = authentication.getName();  // Logged-in user's email
        Hobby savedHobby = hobbyService.saveHobby(hobby, email);
        return ResponseEntity.ok(savedHobby);
    }

    @GetMapping("all")
    public ResponseEntity<List<HobbyDTO>> getHobbiesByJobSeeker(Authentication authentication) {
        String email = authentication.getName();

        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        JobSeeker jobSeeker = jobSeekerService.getProfileByUserId(user.getId());

        List<HobbyDTO> hobbies = hobbyService.getByJobSeekerId(jobSeeker.getId());

        return ResponseEntity.ok(hobbies);}

    @PutMapping("update/{id}")
    public ResponseEntity<Hobby> updateHobby(@PathVariable Long id,
                                                       @RequestBody Hobby updatedHobby,
                                                       Authentication authentication) {
        String email = authentication.getName();
        Hobby updated = hobbyService.updateHobby(id, updatedHobby, email);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteHobby(@PathVariable Long id) {
        hobbyService.delete(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }

}
