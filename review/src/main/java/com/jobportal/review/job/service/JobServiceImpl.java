package com.jobportal.review.job.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jobportal.review.job.entity.Job;
import com.jobportal.review.job.repository.JobRepository;
@Service
public class JobServiceImpl implements JobService{
	@Autowired
	private JobRepository jobRepository;
	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return jobRepository.findAll();
	}
	@Override
	public void createJob(Job job) {
		jobRepository.save(job);
	}
	@Override
	public Job findById(Long Id) {
		// TODO Auto-generated method stub
		return jobRepository.findById(Id).orElse(null);
	}
	@Override
	public boolean deleteById(Long Id) {
		// TODO Auto-generated method stub
		if(jobRepository.existsById(Id)) {
			jobRepository.deleteById(Id);
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean updatedJob(Long id, Job updatedJobs) {
		// TODO Auto-generated method stub
		Optional<Job> jobOption=jobRepository.findById(id);
			if(jobOption.isPresent()) {
				Job j=jobOption.get();
				j.setTitle(updatedJobs.getTitle());
				j.setDescription(updatedJobs.getDescription());
				j.setMinSalary(updatedJobs.getMinSalary());
				j.setMaxSalary(updatedJobs.getMaxSalary());
				j.setLocation(updatedJobs.getLocation());
				jobRepository.save(j); 
				return true;
			}
		return false;
	}
}
