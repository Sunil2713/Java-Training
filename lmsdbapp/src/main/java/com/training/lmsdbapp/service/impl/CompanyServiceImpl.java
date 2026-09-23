package com.training.lmsdbapp.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.training.lmsdbapp.dao.CompanyDao;
import com.training.lmsdbapp.dao.impl.CompanyDaoImpl;
import com.training.lmsdbapp.model.Company;
import com.training.lmsdbapp.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {

    private final CompanyDao companyDao = new CompanyDaoImpl();

    @Override
    public Company getCompanybyId(String id) throws ClassNotFoundException, SQLException {
        return companyDao.findbyId(id);
    }

    @Override
    public void saveCompany(Company company) throws ClassNotFoundException, SQLException {
        companyDao.save(company);
    }

    @Override
    public void updateCompany(Company company) throws ClassNotFoundException, SQLException {
        companyDao.update(company);
    }

    @Override
    public void deleteCompany(Company company) throws ClassNotFoundException, SQLException {
        companyDao.delete(company);
    }

    @Override
    public List<Company> getAllCompany() throws ClassNotFoundException, SQLException {
        return companyDao.findAll();
    }
}
