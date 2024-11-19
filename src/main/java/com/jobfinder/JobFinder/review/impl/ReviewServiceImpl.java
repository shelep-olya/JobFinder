package com.jobfinder.JobFinder.review.impl;

import com.jobfinder.JobFinder.company.Company;
import com.jobfinder.JobFinder.company.CompanyRepository;
import com.jobfinder.JobFinder.company.CompanyService;
import com.jobfinder.JobFinder.review.Review;
import com.jobfinder.JobFinder.review.ReviewRepository;
import com.jobfinder.JobFinder.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    CompanyService companyService;
    ReviewRepository reviewRepository;
    private Long nextId = 1L;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findAllByCompanyId(companyId);
    }

    @Override
    public void createReview(Long companyId, Review review) {
        review.setId(nextId++);
        review.setCompany(companyService.getCompanyById(companyId));
        reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(Long companyId, Long reviewId){
        List<Review> reviews = reviewRepository.findAllByCompanyId(companyId);
        return reviews.stream().filter((review) -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public void updateReview(Long companyId, Long reviewId, Review reviewData) {
        Company company = companyService.getCompanyById(companyId);
       if(company != null){
           reviewData.setCompany(company);
           reviewData.setId(reviewId);
           reviewRepository.save(reviewData);
       }
    }

    @Override
    public void deleteReview(Long companyId, Long reviewId) {
        Company company = companyService.getCompanyById(companyId);
       if(company != null && reviewRepository.existsById(reviewId)){
           Review review = reviewRepository.findById(reviewId).orElse(null);
           company.getReviews().remove(review);
           review.setCompany(null);
           companyService.updateCompany(company,companyId);
           reviewRepository.deleteById(reviewId);
       }
    }


}
