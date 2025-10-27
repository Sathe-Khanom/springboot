package com.emranhss.dreamjob.repository;

import com.emranhss.dreamjob.entity.Employer;
import com.emranhss.dreamjob.entity.Job;
import com.emranhss.dreamjob.entity.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository <Job, Long> {



    List<Job> findByEmployerId(long employerId);

    // Find all jobs by Employer
    List<Job> findByEmployer(Employer employer);



    @Query("SELECT j FROM Job j WHERE " +
            "(:categoryId IS NULL OR j.category.id = :categoryId) AND " +
            "(:locationId IS NULL OR j.location.id = :locationId)")
    List<Job> filterJobs(
            @Param("categoryId") Long categoryId,
            @Param("locationId") Long locationId
    );





    List<Job> findByLocationId(Long locationId);
    List<Job> findByCategoryId(Long categoryId);
    List<Job> findByLocationIdAndCategoryId(Long locationId, Long categoryId);


    List<Job> findByEmployerCompanyName(String companyName);


}
