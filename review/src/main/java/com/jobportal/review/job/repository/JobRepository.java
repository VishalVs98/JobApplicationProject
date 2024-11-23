package com.jobportal.review.job.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jobportal.review.job.entity.Job;
public interface JobRepository extends JpaRepository<Job,Long>{

}
