package com.emranhss.dreamjob.service;

import com.emranhss.dreamjob.dto.RefferenceDTO;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.entity.Refference;
import com.emranhss.dreamjob.repository.JobSeekerRepository;
import com.emranhss.dreamjob.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReferenceService {

    @Autowired
    private ReferenceRepository referenceRepository;

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public List<RefferenceDTO> getByJobSeekerId(Long jobSeekerId) {
        List<Refference> refferences = referenceRepository.findByJobSeekerId(jobSeekerId);
        return refferences.stream()
                .map(RefferenceDTO :: new)
                .collect(Collectors.toList());
    }

    public Refference saveRefference(Refference refference, String email) {
        JobSeeker jobSeeker = jobSeekerRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("JobSeeker not found"));

        refference.setJobSeeker(jobSeeker);

        return referenceRepository.save(refference);
    }

    public void delete(Long id) {
        referenceRepository.deleteById(id);
    }
}
