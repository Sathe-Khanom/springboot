package com.emranhss.dreamjob.restcontroller;

import com.emranhss.dreamjob.dto.ExperienceDTO;
import com.emranhss.dreamjob.dto.ExtracurricularDTO;
import com.emranhss.dreamjob.entity.Experience;
import com.emranhss.dreamjob.entity.Extracurricular;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.entity.User;
import com.emranhss.dreamjob.repository.ExtracurricularRepository;
import com.emranhss.dreamjob.repository.IUserRepo;
import com.emranhss.dreamjob.service.ExtracurricularService;
import com.emranhss.dreamjob.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/extracurricular/")
public class ExtracurricularRestController {
    @Autowired
   private ExtracurricularService extracurricularService;
    @Autowired
    private JobSeekerService jobSeekerService;
    @Autowired
    private IUserRepo userRepo;

    @PostMapping("add")
    public ResponseEntity<Extracurricular> addExtracurricular(@RequestBody Extracurricular extracurricular, Authentication authentication) {
        String email = authentication.getName();  // Logged-in user's email
        Extracurricular savedExtracurricular = extracurricularService.saveExtracurricular(extracurricular, email);
        return ResponseEntity.ok(savedExtracurricular);
    }

    @GetMapping("all")
    public ResponseEntity<List<ExtracurricularDTO>> getExtracurricularByJobSeeker(Authentication authentication) {
        // Get logged-in user email
        String email = authentication.getName();

        Optional<User> user =userRepo.findByEmail(email);
        JobSeeker jobSeeker = jobSeekerService.getProfileByUserId(user.get().getId());


        List<ExtracurricularDTO> extracurricular = extracurricularService.getByJobSeekerId(jobSeeker.getId());


        return ResponseEntity.ok(extracurricular);
    }
}
