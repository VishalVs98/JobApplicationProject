package com.jobportal.review.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.review.company.entity.Company;
import com.jobportal.review.company.service.CompanyService;
import com.jobportal.review.review.entity.Review;
import com.jobportal.review.review.repository.ReviewRepository;
@Service
public class ReviewServiceImpl implements ReviewService{
   
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private CompanyService companyService;
	@Override
	public List<Review> getAllReviews(Long id) {
		List<Review> reviews= reviewRepository.findByCompanyId(id);
		return reviews;
	}
	@Override
	public boolean addReview(Long companyId, Review review) {
		Company company=companyService.getCompanyById(companyId);
		if(company!=null) {
			review.setCompany(company);
			reviewRepository.save(review);
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public Review getReview(Long companyId, Long reviewId) {
		List<Review> reviews=reviewRepository.findByCompanyId(companyId);
		return reviews.stream()
				.filter(review->review.getId().equals(reviewId))
				.findFirst()
				.orElse(null);
	}
	@Override
	public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
		// TODO Auto-generated method stub
		if(companyService.getCompanyById(companyId)!=null) {
			updatedReview.setCompany(companyService.getCompanyById(companyId));
			updatedReview.setId(reviewId);
			reviewRepository.save(updatedReview);
			return true;
		}else {
			return false;
		}
		
	}
	@Override
	public boolean deleteReview(Long companyId, Long reviewId) {
		// TODO Auto-generated method stub
		if(companyService.getCompanyById(companyId)!=null && reviewRepository.existsById(reviewId)) {
			Review review=reviewRepository.findById(reviewId).orElse(null);
			Company company=review.getCompany();
			company.getReview().remove(review);
			companyService.updateCompany(reviewId, company);
			reviewRepository.deleteById(reviewId);
			return true;
		}
		return false;
	}

}
