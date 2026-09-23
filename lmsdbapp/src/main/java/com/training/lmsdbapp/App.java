package com.training.lmsdbapp;

import java.sql.SQLException;
import java.util.List;

import com.training.lmsdbapp.model.Company;
import com.training.lmsdbapp.service.CompanyService;
import com.training.lmsdbapp.service.impl.CompanyServiceImpl;

public class App {

    public static void main(String[] args) {
        CompanyService companyService = new CompanyServiceImpl();
        String companyId = "C009";

        try {
            Company company = new Company(companyId, "Dover", "Industrial Products Company");

            // Insert only if this demonstration company does not already exist.
            if (companyService.getCompanybyId(companyId) == null) {
                companyService.saveCompany(company);
                System.out.println("Company saved successfully.");
            } else {
                System.out.println("Company " + companyId + " already exists. Continuing with it.");
            }

            System.out.println("\n--- Find Company By ID ---");
            System.out.println(companyService.getCompanybyId(companyId));

            System.out.println("\n--- All Companies ---");
            List<Company> companies = companyService.getAllCompany();
            for (Company currentCompany : companies) {
                System.out.println(currentCompany);
            }

            Company updatedCompany = new Company(companyId, "Dover Corporation",
                    "Updated industrial solutions company");
            companyService.updateCompany(updatedCompany);
            System.out.println("\nUpdated company: " + companyService.getCompanybyId(companyId));

            companyService.deleteCompany(updatedCompany);
            System.out.println("Company deleted: " + (companyService.getCompanybyId(companyId) == null));

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver was not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database operation failed.");
            e.printStackTrace();
        }
    }
}
