package com.emranhss.dreamjob.restcontroller;


import com.emranhss.dreamjob.entity.Employer;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.entity.User;
import com.emranhss.dreamjob.repository.EmployerRepository;
import com.emranhss.dreamjob.repository.IUserRepo;
import com.emranhss.dreamjob.service.AuthService;
import com.emranhss.dreamjob.service.EmployerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employer/")
public class EmployerRestController {
    @Autowired
    private AuthService authService;

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private EmployerService employerService;

    @PostMapping("")
    public ResponseEntity<Map<String, String>> registerEmployer(
            @RequestPart(value = "user") String userJson,
            @RequestPart(value = "employer") String employerJson,
            @RequestParam(value = "logo") MultipartFile file
    ) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(userJson, User.class);
        Employer employer = objectMapper.readValue(employerJson, Employer.class);

        try {
            authService.registerEmployer(user, file, employer);
            Map<String, String> response = new HashMap<>();
            response.put("Message", "User Added Successfully ");

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {

            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("Message", "User Add Failed " + e);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping("all")
    public ResponseEntity<List<Employer>> getAllUsers() {
        List<Employer> employerList = employerService.getAll();
        return ResponseEntity.ok(employerList);

    }


    @GetMapping("profile")
    public ResponseEntity<?> getProfile(Authentication authentication) {
        System.out.println("Authenticated User: " + authentication.getName());
        System.out.println("Authorities: " + authentication.getAuthorities());
        String email = authentication.getName();
        Optional<User> user =userRepo.findByEmail(email);
        Employer employer = employerService.getProfileByUserId(user.get().getId());
        return ResponseEntity.ok(employer);

    }

    @GetMapping("allemp")
    public ResponseEntity<List<Employer>> getAllEmployers() {
        List<Employer> employers = employerService.getAll();
        return ResponseEntity.ok(employers);
    }

    // 🔹 Delete employer by ID
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteEmployer(@PathVariable Long id) {
        Optional<Employer> employer = employerService.getById(id);
        if (employer.isPresent()) {
            employerService.delete(id);
            return ResponseEntity.ok("Employer deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
