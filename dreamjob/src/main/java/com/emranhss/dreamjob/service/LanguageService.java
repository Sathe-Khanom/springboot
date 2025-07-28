package com.emranhss.dreamjob.service;

import com.emranhss.dreamjob.entity.Language;
import com.emranhss.dreamjob.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public List<Language> getByJobSeekerId(Long jobSeekerId) {
        return languageRepository.findByJobSeekerId(jobSeekerId);
    }

    public Language save(Language language) {
        return languageRepository.save(language);
    }

    public void delete(Long id) {
        languageRepository.deleteById(id);
    }

}
