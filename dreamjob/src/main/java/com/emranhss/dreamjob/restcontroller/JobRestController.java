package com.emranhss.dreamjob.restcontroller;

import com.emranhss.dreamjob.dto.JobDTO;
import com.emranhss.dreamjob.dto.LanguageDTO;
import com.emranhss.dreamjob.entity.Job;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.entity.Language;
import com.emranhss.dreamjob.entity.User;
import com.emranhss.dreamjob.repository.IUserRepo;
import com.emranhss.dreamjob.service.EmployerService;
import com.emranhss.dreamjob.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs/")


public class JobRestController {
    @Autowired
   private JobService jobService;

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job, Authentication authentication) {
        String email = authentication.getName(); // Get logged-in user's email
        Job savedJob = jobService.saveJob(job, email);
        return ResponseEntity.ok(savedJob);
    }

    // Get all jobs posted by an employer
    @GetMapping("employer/{employerId}")
    public ResponseEntity<List<JobDTO>> getJobsByEmployer(@PathVariable Long employerId) {
        List<JobDTO> jobs = jobService.getJobsByEmployerId(employerId);
        return ResponseEntity.ok(jobs);
    }

    // Delete a job by ID
    @DeleteMapping("/{jobId}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long jobId) {
        jobService.delete(jobId);
        return ResponseEntity.noContent().build();
    }


}
