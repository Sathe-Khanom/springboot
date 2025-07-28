package com.emranhss.dreamjob.service;

import com.emranhss.dreamjob.entity.Refference;
import com.emranhss.dreamjob.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferenceService {

    @Autowired
    private ReferenceRepository referenceRepository;

    public List<Refference> getByJobSeekerId(Long jobSeekerId) {
        return referenceRepository.findByJobSeekerId(jobSeekerId);
    }

    public Refference save(Refference reference) {
        return referenceRepository.save(reference);
    }

    public void delete(Long id) {
        referenceRepository.deleteById(id);
    }
}
