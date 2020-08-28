package com.wellsfargo.companydetailsservice.components;

import com.wellsfargo.companydetailsservice.models.Company;

import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Integer>{
    
}