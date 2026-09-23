package com.training.lmsdbapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.lmsdbapp.dao.CompanyDao;
import com.training.lmsdbapp.model.Company;
import com.training.lmsdbapp.util.DBConnection;

public class CompanyDaoImpl implements CompanyDao {

    @Override
    public List<Company> findAll() throws ClassNotFoundException, SQLException {
        List<Company> list = new ArrayList<>();
        String selectSql = "SELECT company_id, company_name, description FROM company";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(selectSql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Company company = new Company();
                company.setCompanyId(rs.getString("company_id"));
                company.setCompanyName(rs.getString("company_name"));
                company.setCompanyDescription(rs.getString("description"));
                list.add(company);
            }
        }
        return list;
    }

    @Override
    public Company findbyId(String id) throws ClassNotFoundException, SQLException {
        String selectSql = "SELECT company_id, company_name, description FROM company WHERE company_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(selectSql)) {

            ps.setString(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }

                Company company = new Company();
                company.setCompanyId(rs.getString("company_id"));
                company.setCompanyName(rs.getString("company_name"));
                company.setCompanyDescription(rs.getString("description"));
                return company;
            }
        }
    }

    @Override
    public void save(Company company) throws ClassNotFoundException, SQLException {
        String insertSql = "INSERT INTO company (company_id, company_name, description) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(insertSql)) {

            ps.setString(1, company.getCompanyId());
            ps.setString(2, company.getCompanyName());
            ps.setString(3, company.getCompanyDescription());
            ps.executeUpdate();
        }
    }

    @Override
    public void update(Company company) throws ClassNotFoundException, SQLException {
        String updateSql = "UPDATE company SET company_name = ?, description = ? WHERE company_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(updateSql)) {

            ps.setString(1, company.getCompanyName());
            ps.setString(2, company.getCompanyDescription());
            ps.setString(3, company.getCompanyId());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(Company company) throws ClassNotFoundException, SQLException {
        String deleteSql = "DELETE FROM company WHERE company_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(deleteSql)) {

            ps.setString(1, company.getCompanyId());
            ps.executeUpdate();
        }
    }
}
