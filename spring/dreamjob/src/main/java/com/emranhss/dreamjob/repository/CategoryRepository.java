package com.emranhss.dreamjob.repository;

import com.emranhss.dreamjob.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c.name AS name, COUNT(j.id) AS count FROM Category c LEFT JOIN Job j ON c.id = j.category.id GROUP BY c.name")
    List<Map<String, Object>> findCategoryCounts();
}
