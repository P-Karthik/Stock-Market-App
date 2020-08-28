package com.wellsfargo.companydetailsservice.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.wellsfargo.companydetailsservice.models.Company;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping(value = "/companys")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @PostMapping(value = "/companys")
    public void addcompany(@RequestBody Company company) {
        companyService.addcompany(company);
    }

    @PutMapping(value = "/companys/{id}")
    public void updateCompany(@RequestBody Company company) {
        companyService.updateCompany(company);
    }

    @GetMapping(value = "/companys/{id}")
    public Optional<Company> getCompanyById(@PathVariable("id") Integer id) {
        return companyService.getCompanyById(id);
    }

    @DeleteMapping(value = "/companys/{id}")
    public void deleteCompany(@PathVariable("id") Integer id) {
        companyService.deleteCompany(id);
    }
}