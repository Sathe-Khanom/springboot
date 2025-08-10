package com.emranhss.dreamjob.restcontroller;

import com.emranhss.dreamjob.dto.RefferenceDTO;
import com.emranhss.dreamjob.dto.SkillDTO;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.entity.Refference;
import com.emranhss.dreamjob.entity.Skill;
import com.emranhss.dreamjob.entity.User;
import com.emranhss.dreamjob.repository.IUserRepo;
import com.emranhss.dreamjob.service.JobSeekerService;
import com.emranhss.dreamjob.service.ReferenceService;
import com.emranhss.dreamjob.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/skill/")
public class SkillRestController {

    @Autowired
    private SkillService skillService;
    @Autowired
    private JobSeekerService jobSeekerService;
    @Autowired
    private IUserRepo userRepo;

    @PostMapping("add")
    public ResponseEntity<Skill> addSkill(@RequestBody Skill skill, Authentication authentication) {
        String email = authentication.getName();  // Logged-in user's email
        Skill savedSkill = skillService.saveSkill(skill, email);
        return ResponseEntity.ok(savedSkill);
    }

    @GetMapping("all")
    public ResponseEntity<List<SkillDTO>> getSkillByJobSeeker(Authentication authentication) {
        // Get logged-in user email
        String email = authentication.getName();

        Optional<User> user =userRepo.findByEmail(email);
        JobSeeker jobSeeker = jobSeekerService.getProfileByUserId(user.get().getId());


        List<SkillDTO> skill = skillService.getByJobSeekerId(jobSeeker.getId());


        return ResponseEntity.ok(skill);
    }
}
