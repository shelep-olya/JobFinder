package com.jobfinder.JobFinder.review;
import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    void createReview(Long companyId, Review review);
    Review getReviewById(Long companyId, Long reviewId);
    void updateReview(Long companyId, Long reviewId, Review reviewData);
    void deleteReview(Long companyId, Long reviewId);
}
