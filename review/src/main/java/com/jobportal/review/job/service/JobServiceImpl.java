package com.jobportal.review.job.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.jobportal.review.job.entity.Job;
@Service
public class JobServiceImpl implements JobService{
	private List<Job> jobs=new ArrayList<>();
	private Long nextId=1L;
	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return jobs;
	}
	@Override
	public void createJob(Job job) {
		// TODO Auto-generated method stub
		job.setId(nextId++);
		jobs.add(job);
	}
	@Override
	public Job findById(Long Id) {
		// TODO Auto-generated method stub
		for(Job job:jobs) {
			if(job.getId()==Id) {
				return job;
			}
		}
		return null;
	}
	@Override
	public void deleteById(Long Id) {
		// TODO Auto-generated method stub
		for(Job job:jobs) {
			if(job.getId()==Id) {
			   jobs.remove(job);
			}
		}
		
	}
}
