package com.jobfinder.JobFinder.company.impl;

import com.jobfinder.JobFinder.company.Company;
import com.jobfinder.JobFinder.company.CompanyRepository;
import com.jobfinder.JobFinder.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;
    private Long nextId = 1L;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company updateCompany(Company updatedCompany, Long id){
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company company = companyOptional.get();
            company.setName(updatedCompany.getName());
            company.setDescription(updatedCompany.getDescription());
            company.setJobs(updatedCompany.getJobs());
            companyRepository.save(company);
            return company;
        }
        return null;
    }

    @Override
    public void createCompany(Company company){
        company.setId(nextId++);
        companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCompany(Long id){
        companyRepository.deleteById(id);
    }

}
