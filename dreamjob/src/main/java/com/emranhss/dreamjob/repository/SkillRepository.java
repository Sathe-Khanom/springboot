package com.emranhss.dreamjob.repository;

import com.emranhss.dreamjob.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findByJobSeekerId(Long jobSeekerId);
}
