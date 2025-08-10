package com.emranhss.dreamjob.restcontroller;

import com.emranhss.dreamjob.dto.LanguageDTO;
import com.emranhss.dreamjob.dto.RefferenceDTO;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.entity.Language;
import com.emranhss.dreamjob.entity.Refference;
import com.emranhss.dreamjob.entity.User;
import com.emranhss.dreamjob.repository.IUserRepo;
import com.emranhss.dreamjob.service.JobSeekerService;
import com.emranhss.dreamjob.service.LanguageService;
import com.emranhss.dreamjob.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/refference/")
public class RefferenceRestController {

    @Autowired
    private ReferenceService referenceService;
    @Autowired
    private JobSeekerService jobSeekerService;
    @Autowired
    private IUserRepo userRepo;

    @PostMapping("add")
    public ResponseEntity<Refference> addRefference(@RequestBody Refference refference, Authentication authentication) {
        String email = authentication.getName();  // Logged-in user's email
        Refference savedRefference = referenceService.saveRefference(refference, email);
        return ResponseEntity.ok(savedRefference);
    }

    @GetMapping("all")
    public ResponseEntity<List<RefferenceDTO>> getRefferenceByJobSeeker(Authentication authentication) {
        // Get logged-in user email
        String email = authentication.getName();

        Optional<User> user =userRepo.findByEmail(email);
        JobSeeker jobSeeker = jobSeekerService.getProfileByUserId(user.get().getId());


        List<RefferenceDTO> refference = referenceService.getByJobSeekerId(jobSeeker.getId());


        return ResponseEntity.ok(refference);
    }
}
