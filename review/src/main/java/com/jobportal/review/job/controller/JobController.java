package com.jobportal.review.job.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jobportal.review.job.entity.Job;
import com.jobportal.review.job.service.JobService;
@RestController
public class JobController {
	@Autowired
	private JobService jobService;  	
	@GetMapping("/jobs")
	public ResponseEntity<List<Job>> findAll(){ 
		return  ResponseEntity.ok(jobService.findAll());
	}
	@PostMapping("/jobs")
	public ResponseEntity<String> createJobs(@RequestBody Job job){ 
		jobService.createJob(job);
		return new ResponseEntity<>("job added successfully",HttpStatus.OK);
	}
	@GetMapping("/jobs/{id}")
	public ResponseEntity<Job> findById(@PathVariable("id") Long Id){ 
		Job job= jobService.findById(Id);
		if(job!=null) {
			return new ResponseEntity<>(job,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/jobs/{id}")
	public String deleteById(@PathVariable("id") Long Id){ 
		 jobService.deleteById(Id);
		 return Id+" "+ " deletedsuccessfully";
	}
}