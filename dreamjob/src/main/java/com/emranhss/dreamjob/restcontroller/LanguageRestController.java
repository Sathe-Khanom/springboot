package com.emranhss.dreamjob.restcontroller;

import com.emranhss.dreamjob.dto.HobbyDTO;
import com.emranhss.dreamjob.dto.LanguageDTO;
import com.emranhss.dreamjob.entity.Hobby;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.entity.Language;
import com.emranhss.dreamjob.entity.User;
import com.emranhss.dreamjob.repository.IUserRepo;
import com.emranhss.dreamjob.service.HobbyService;
import com.emranhss.dreamjob.service.JobSeekerService;
import com.emranhss.dreamjob.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/language/")
public class LanguageRestController {

    @Autowired
    private LanguageService languageService;
    @Autowired
    private JobSeekerService jobSeekerService;
    @Autowired
    private IUserRepo userRepo;

    @PostMapping("add")
    public ResponseEntity<Language> addLanguage(@RequestBody Language language, Authentication authentication) {
        String email = authentication.getName();  // Logged-in user's email
        Language savedLanguage = languageService.saveLanguage(language, email);
        return ResponseEntity.ok(savedLanguage);
    }

    @GetMapping("all")
    public ResponseEntity<List<LanguageDTO>> getLanguageByJobSeeker(Authentication authentication) {
        // Get logged-in user email
        String email = authentication.getName();

        Optional<User> user =userRepo.findByEmail(email);
        JobSeeker jobSeeker = jobSeekerService.getProfileByUserId(user.get().getId());


        List<LanguageDTO> language = languageService.getByJobSeekerId(jobSeeker.getId());


        return ResponseEntity.ok(language);
    }
}
