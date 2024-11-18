package com.jobfinder.JobFinder.review.impl;

import com.jobfinder.JobFinder.review.Review;
import com.jobfinder.JobFinder.review.ReviewRepository;
import com.jobfinder.JobFinder.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    ReviewRepository reviewRepository;
    private Long nextId = 1L;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findAllByCompanyId(companyId);
    }


}
