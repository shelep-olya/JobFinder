package com.jobfinder.JobFinder.job;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job getJobById(Long id);
    boolean deleteJob(Long id);
    Job updateJob(Long id, Job updatedJob);
}
