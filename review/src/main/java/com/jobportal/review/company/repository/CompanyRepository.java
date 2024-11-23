package com.jobportal.review.company.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jobportal.review.company.entity.Company;
public interface CompanyRepository extends JpaRepository<Company,Long>{

}
