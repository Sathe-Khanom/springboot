package com.emranhss.dreamjob.service;

import com.emranhss.dreamjob.entity.Employer;
import com.emranhss.dreamjob.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository  employerRepository;

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
