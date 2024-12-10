package com.jobportal.review.company.service;

import java.util.List;

import com.jobportal.review.company.entity.Company;

public interface CompanyService {
 List<Company> getAllCompanies();
 boolean updateCompany(Long id,Company company);
 void createCompany(Company company);
 boolean deleteCompany(Long id);
 Company getCompanyById(Long Id);
} 
