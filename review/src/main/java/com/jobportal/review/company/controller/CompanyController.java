package com.jobportal.review.company.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.review.company.entity.Company;
import com.jobportal.review.company.service.CompanyService;
@RestController
@RequestMapping("/companies")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	@GetMapping
	public ResponseEntity<List<Company>> getAllCompanies(){
		return new ResponseEntity<>(companyService.getAllCompanies(),HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompanies(@PathVariable Long id,@RequestBody Company updateCompany){
		companyService.updateCompany(id, updateCompany); 
		return new ResponseEntity<>("updated Successfully",HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<String> addCompany(@RequestBody Company company) {
		companyService.createCompany(company);
		return new ResponseEntity<>("Company added Successfully",HttpStatus.CREATED);
	}
}
