package com.jobportal.review.job.service;
import java.util.ArrayList;
import java.util.Iterator;
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
	public boolean deleteById(Long Id) {
		// TODO Auto-generated method stub
		Iterator<Job> itr=jobs.iterator();
		while(itr.hasNext()) {
			Job job=itr.next();
			if(job.getId().equals(Id)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean updatedJob(Long id, Job updatedJobs) {
		// TODO Auto-generated method stub
		for(Job j:jobs) {
			if(j.getId().equals(id)) {
				j.setTitle(updatedJobs.getTitle());
				j.setDescription(updatedJobs.getDescription());
				j.setMinSalary(updatedJobs.getMinSalary());
				j.setMaxSalary(updatedJobs.getMaxSalary());
				j.setLocation(updatedJobs.getLocation());
				return true;
			}
		}
		return false;
	}
}
