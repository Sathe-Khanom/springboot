package com.emranhss.dreamjob.service;


import com.emranhss.dreamjob.dto.ExtracurricularDTO;
import com.emranhss.dreamjob.entity.Extracurricular;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.repository.ExtracurricularRepository;
import com.emranhss.dreamjob.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExtracurricularService {

    @Autowired
    private ExtracurricularRepository extracurricularRepository;

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public List<ExtracurricularDTO> getByJobSeekerId(Long jobSeekerId) {
        List<Extracurricular> extracurriculars = extracurricularRepository.findByJobSeekerId(jobSeekerId);
        return extracurriculars.stream()
                .map(ExtracurricularDTO :: new)
                .collect(Collectors.toList());
    }

    public Extracurricular saveExtracurricular(Extracurricular extracurricular, String email) {
        JobSeeker jobSeeker = jobSeekerRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("JobSeeker not found"));

        extracurricular.setJobSeeker(jobSeeker);

        return extracurricularRepository.save(extracurricular);   }

    public void delete(Long id) {
        extracurricularRepository.deleteById(id);
    }
}
