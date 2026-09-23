package com.training.lmsdbapp.service;

import java.sql.SQLException;
import java.util.List;

import com.training.lmsdbapp.model.Company;

public interface CompanyService {

    List<Company> getAllCompany() throws ClassNotFoundException, SQLException;

    Company getCompanybyId(String id) throws ClassNotFoundException, SQLException;

    void saveCompany(Company company) throws ClassNotFoundException, SQLException;

    void updateCompany(Company company) throws ClassNotFoundException, SQLException;

    void deleteCompany(Company company) throws ClassNotFoundException, SQLException;
}
