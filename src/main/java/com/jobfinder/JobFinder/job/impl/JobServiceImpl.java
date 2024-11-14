package com.jobfinder.JobFinder.job.impl;

import com.jobfinder.JobFinder.job.Job;
import com.jobfinder.JobFinder.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        for(Job job : jobs){
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJob(Long id){
        for(Job job : jobs){
            if(job.getId().equals(id)){
                jobs.remove(job);
                return true;
            }
        }
        return false;
    }
    @Override
    public Job updateJob(Long id, Job updatedJob){
        for(Job job : jobs){
            if(job.getId().equals(id)){
                job.setDescription(updatedJob.getDescription());
                job.setLocation(updatedJob.getLocation());
                job.setTitle(updatedJob.getTitle());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());
                return job;
            }
        }
        return null;
    }


}
