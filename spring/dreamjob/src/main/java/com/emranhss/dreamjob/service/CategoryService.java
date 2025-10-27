package com.emranhss.dreamjob.service;

import com.emranhss.dreamjob.dto.CategoryDTO;
import com.emranhss.dreamjob.entity.Category;
import com.emranhss.dreamjob.entity.JobSeeker;
import com.emranhss.dreamjob.entity.Training;
import com.emranhss.dreamjob.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


//    public List<LocationDTO> getAllLocations() {
//        return locationRepository.findAll()
//                .stream()
//                .map(LocationDTO::new)   // uses constructor
//                .toList();
//    }
//
//    public Optional<LocationDTO> getLocationById(Long id) {
//        return locationRepository.findById(id)
//                .map(LocationDTO::new);
//    }


    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryDTO::new)
                .toList();

    }

    public Optional<CategoryDTO> getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(CategoryDTO::new);
    }




    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }





    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
