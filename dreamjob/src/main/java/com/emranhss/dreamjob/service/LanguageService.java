package com.emranhss.dreamjob.service;

import com.emranhss.dreamjob.dto.EducationDTO;
import com.emranhss.dreamjob.dto.LanguageDTO;
import com.emranhss.dreamjob.entity.Education;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.entity.Language;
import com.emranhss.dreamjob.repository.JobSeekerRepository;
import com.emranhss.dreamjob.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public List<LanguageDTO> getByJobSeekerId(Long jobSeekerId) {
        List<Language> languages = languageRepository.findByJobSeekerId(jobSeekerId);
        return languages.stream()
                .map(LanguageDTO :: new)
                .collect(Collectors.toList());
    }

    public Language saveLanguage(Language language, String email) {
        JobSeeker jobSeeker = jobSeekerRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("JobSeeker not found"));

        language.setJobSeeker(jobSeeker);

        return languageRepository.save(language);
    }

    public void delete(Long id) {
        languageRepository.deleteById(id);
    }

}
