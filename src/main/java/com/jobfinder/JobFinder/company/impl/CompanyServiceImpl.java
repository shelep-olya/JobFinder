package com.jobfinder.JobFinder.company.impl;

import com.jobfinder.JobFinder.company.Company;
import com.jobfinder.JobFinder.company.CompanyRepository;
import com.jobfinder.JobFinder.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
