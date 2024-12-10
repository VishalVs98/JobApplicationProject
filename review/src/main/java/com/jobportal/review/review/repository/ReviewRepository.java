package com.jobportal.review.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.review.review.entity.Review;

public interface ReviewRepository extends JpaRepository<Review,Long>{

	List<Review> findByCompanyId(Long id);

}
