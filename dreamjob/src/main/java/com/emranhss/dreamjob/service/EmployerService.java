package com.emranhss.dreamjob.service;

import com.emranhss.dreamjob.entity.Employer;
import com.emranhss.dreamjob.jwt.JwtService;
import com.emranhss.dreamjob.repository.EmployerRepository;
import com.emranhss.dreamjob.repository.ITokenRepository;
import com.emranhss.dreamjob.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository  employerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUserRepo userRepo;
    @Autowired
    private ITokenRepository tokenRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private JobSeekerService jobSeekerService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    @Lazy
    private AuthenticationManager authenticationManager;

    @Value("src/main/resources/static/images")
    private String uploadDir;

    public List<Employer> getAll() {

        return employerRepository.findAll();
    }

    public Optional<Employer> getById(Long id) {

        return employerRepository.findById(id);
    }

    public Employer save(Employer employer) {

        return employerRepository.save(employer);
    }

    public void delete(Long id) {

        employerRepository.deleteById(id);

    }
    public Employer getProfileByUserId(int userId) {
        return employerRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Employer not found"));
    }
}
