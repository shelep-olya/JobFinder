package com.jobfinder.JobFinder.review;
import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
}
