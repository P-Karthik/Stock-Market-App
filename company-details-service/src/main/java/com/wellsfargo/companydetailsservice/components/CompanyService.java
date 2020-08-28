package com.wellsfargo.companydetailsservice.components;

import com.wellsfargo.companydetailsservice.models.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

        @Autowired
        private CompanyRepository companyRepository;

        List<Company> companies = new ArrayList<>();

        public List<Company> getAllCompanies() {
                companyRepository.findAll().forEach(companies::add);
                return companies;
        }

        public void addcompany(Company company) {
                companyRepository.save(company);
        }

        public void updateCompany(Company company) {
                companyRepository.save(company);
        }

        public Optional<Company> getCompanyById(Integer id) {
		return companyRepository.findById(id);
	}

	public void deleteCompany(Integer id) {
                companyRepository.deleteById(id);
	}

}
