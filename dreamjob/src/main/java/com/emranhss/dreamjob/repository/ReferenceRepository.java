package com.emranhss.dreamjob.repository;


import com.emranhss.dreamjob.entity.Refference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReferenceRepository extends JpaRepository<Refference,Long> {
    List<Refference> findByJobSeekerId(Long jobSeekerId);


}
