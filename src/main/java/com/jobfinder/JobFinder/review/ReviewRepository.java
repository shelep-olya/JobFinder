package com.jobfinder.JobFinder.review;

import com.jobfinder.JobFinder.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByCompanyId(Long companyId);
}
