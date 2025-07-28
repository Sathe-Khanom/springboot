package com.emranhss.dreamjob.repository;

import com.emranhss.dreamjob.entity.Extracurricular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtracurricularRepository extends JpaRepository<Extracurricular,Long> {
    List<Extracurricular> findByJobSeekerId(Long jobSeekerId);
}
