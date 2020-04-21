package com.technofolks.jpa.repository;

import com.technofolks.jpa.model.SubCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    Page<SubCategory> findByCategoryId(Long categroyId, Pageable pageable);
    Optional<SubCategory> findByIdAndCategoryId(Long id, Long categroyId);
}
