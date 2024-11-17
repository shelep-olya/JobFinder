package com.jobfinder.JobFinder.company;
import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Company updateCompany(Company company, Long id);
    void createCompany(Company company);
    Company getCompanyById(Long id);
    void deleteCompany(Long id);
}
