package com.jobportal.review.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jobportal.review.company.entity.Company;
import com.jobportal.review.company.repository.CompanyRepository;
@Service
public class CompanyServiceImpl implements CompanyService{
	@Autowired
	private CompanyRepository companyRepository;
	@Override
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}
	@Override
	public boolean updateCompany(Long id, Company updateCompany) {
		Optional<Company> companyOption=companyRepository.findById(id);
		if(companyOption.isPresent()) {
			Company c=companyOption.get();
			c.setName(updateCompany.getName());
			c.setDescription(updateCompany.getDescription());
			c.setJobs(updateCompany.getJobs());
			companyRepository.save(c); 
			return true;
		}
		return false;
	}
	@Override
	public void createCompany(Company company) {
		// TODO Auto-generated method stub
		companyRepository.save(company);
	}
	@Override
	public boolean deleteCompany(Long id) {
		// TODO Auto-generated method stub
		if(companyRepository.existsById(id)) {
			companyRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
}
