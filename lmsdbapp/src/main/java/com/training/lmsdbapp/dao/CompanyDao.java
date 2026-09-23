package com.training.lmsdbapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.training.lmsdbapp.model.Company;

public interface CompanyDao {

    List<Company> findAll() throws ClassNotFoundException, SQLException;

    Company findbyId(String id) throws ClassNotFoundException, SQLException;

    void save(Company company) throws ClassNotFoundException, SQLException;

    void update(Company company) throws ClassNotFoundException, SQLException;

    void delete(Company company) throws ClassNotFoundException, SQLException;
}
