package com.emranhss.dreamjob.repository;


import com.emranhss.dreamjob.entity.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, Long> {


    List<Apply> findByJobSeeker_Id(Long jobSeekerId);


    // Optional: find by employer and specific job
    @Query("SELECT a FROM Apply a WHERE a.employer.id = :employerId AND a.job.id = :jobId")
    List<Apply> findAllByEmployerAndJob(@Param("employerId") Long employerId, @Param("jobId") Long jobId);

}
