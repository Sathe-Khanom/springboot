package com.emranhss.dreamjob.repository;


import com.emranhss.dreamjob.entity.Summery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SummeryRepository extends JpaRepository<Summery, Long> {

    List<Summery> findByJobSeekerId(Long jobSeekerId);
}
