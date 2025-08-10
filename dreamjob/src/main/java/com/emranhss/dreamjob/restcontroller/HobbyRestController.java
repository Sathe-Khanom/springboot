package com.emranhss.dreamjob.restcontroller;

import com.emranhss.dreamjob.dto.ExtracurricularDTO;
import com.emranhss.dreamjob.dto.HobbyDTO;
import com.emranhss.dreamjob.entity.Extracurricular;
import com.emranhss.dreamjob.entity.Hobby;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.entity.User;
import com.emranhss.dreamjob.repository.IUserRepo;
import com.emranhss.dreamjob.service.HobbyService;
import com.emranhss.dreamjob.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
    public ResponseEntity<List<HobbyDTO>> getHobbyByJobSeeker(Authentication authentication) {
        // Get logged-in user email
        String email = authentication.getName();

        Optional<User> user =userRepo.findByEmail(email);
        JobSeeker jobSeeker = jobSeekerService.getProfileByUserId(user.get().getId());


        List<HobbyDTO> hobby = hobbyService.getByJobSeekerId(jobSeeker.getId());


        return ResponseEntity.ok(hobby);
    }





}
