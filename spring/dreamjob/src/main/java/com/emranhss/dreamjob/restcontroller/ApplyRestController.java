package com.emranhss.dreamjob.restcontroller;

import com.emranhss.dreamjob.dto.ApplyDTO;
import com.emranhss.dreamjob.entity.Apply;
import com.emranhss.dreamjob.entity.Employer;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.repository.EmployerRepository;
import com.emranhss.dreamjob.repository.JobSeekerRepository;
import com.emranhss.dreamjob.service.ApplyService;
import com.emranhss.dreamjob.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/applications")
public class ApplyRestController {

    @Autowired
    private ApplyService applyService;

    @Autowired
    private JobSeekerService jobSeekerService;

    @Autowired
    private JobSeekerRepository jobSeekerRepository;


    @Autowired
    private EmployerRepository employerRepository;

    // ✅ Create a new application
    @PostMapping
    public ResponseEntity<ApplyDTO> createApplication(@RequestBody Apply apply, Authentication authentication) {

        String JobSeekerEmail = authentication.getName();

        JobSeeker jobSeeker = jobSeekerRepository.findByUserEmail(JobSeekerEmail)
                .orElseThrow(() -> new RuntimeException("Job Seeker Not Found"));


        Apply createdApply = applyService.createApplication(apply, jobSeeker);

        // Convert to DTO before returning
        ApplyDTO dto = applyService.mapToDTO(createdApply);


        return ResponseEntity.ok(dto);
    }


    // ✅ Get all applications
    @GetMapping
    public ResponseEntity<List<Apply>> getAllApplications() {
        List<Apply> applications = applyService.getAllApplications();
        return ResponseEntity.ok(applications);
    }

    // ✅ Get application by ID
    @GetMapping("{id}")
    public ResponseEntity<Apply> getApplicationById(@PathVariable Long id) {
        Optional<Apply> apply = applyService.getApplicationById(id);
        return apply.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Update an application
    @PutMapping("{id}")
    public ResponseEntity<Apply> updateApplication(@PathVariable Long id, @RequestBody Apply updatedApply) {
        try {
            Apply updated = applyService.updateApplication(id, updatedApply);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // ✅ Delete an application
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applyService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/my")
    public List<ApplyDTO> getMyApplies(Authentication authentication) {
        if (authentication == null) {
            throw new RuntimeException("User not authenticated");
        }

        String username = authentication.getName(); // "rahim@gmail.com"
        System.out.println("Logged in as: " + username);

        JobSeeker jobSeeker = jobSeekerRepository.findByUserEmail(username)
                .orElseThrow(() -> new RuntimeException("JobSeeker not found for user " + username));

        return applyService.getAppliesByJobSeeker(jobSeeker.getId());
    }


    @GetMapping("/applicant/{jobId}")
    public ResponseEntity<List<ApplyDTO>> getApplicationsForJob(
            @PathVariable Long jobId,
            Authentication authentication) {

        if (authentication == null) {
            throw new RuntimeException("User not authenticated");
        }

        String email = authentication.getName();
        Employer employer = employerRepository.findByUserEmail(email)
                .orElseThrow(() -> new RuntimeException("Employer not found"));

        List<ApplyDTO> applications = applyService.getApplicationsByJob(employer.getId(), jobId);
        return ResponseEntity.ok(applications);
    }


}
