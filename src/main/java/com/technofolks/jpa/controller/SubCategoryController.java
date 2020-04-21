package com.technofolks.jpa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.technofolks.jpa.exception.ResourceNotFoundException;
import com.technofolks.jpa.model.SubCategory;
import com.technofolks.jpa.repository.CategoryRepository;
import com.technofolks.jpa.repository.SubCategoryRepository;

@RestController
public class SubCategoryController {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/category/{categoryId}/subcategories")
    public Page<SubCategory> getAllSubCategoriesByCategoryId(@PathVariable (value = "categoryId") Long categoryId,
                                                Pageable pageable) {
        return subCategoryRepository.findByCategoryId(categoryId, pageable);
    }

    @PostMapping("/category/{categoryId}/subcategories")
    public SubCategory createSubCategory(@PathVariable (value = "categoryId") Long categoryId,
                                 @Valid @RequestBody SubCategory subCategory) {
        return categoryRepository.findById(categoryId).map(category -> {
        	subCategory.setCategory(category);
            return subCategoryRepository.save(subCategory);
        }).orElseThrow(() -> new ResourceNotFoundException("CategoryId " + categoryId + " not found"));
    }
}
