package com.jobportal.review.job.service;
import java.util.List;
import com.jobportal.review.job.entity.Job;
public interface JobService {
   List<Job>findAll();
   void createJob(Job job);
   Job findById(Long Id);
   boolean deleteById(Long Id);
   boolean updatedJob(Long id, Job job);
}
