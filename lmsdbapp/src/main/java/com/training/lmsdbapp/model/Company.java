package com.training.lmsdbapp.model;

public class Company {

    private String companyId;
    private String companyName;
    private String companyDescription;

    public Company() {
    }

    public Company(String companyId, String companyName, String companyDescription) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyDescription = companyDescription;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    @Override
    public String toString() {
        return "Company [companyId=" + companyId + ", companyName=" + companyName
                + ", companyDescription=" + companyDescription + "]";
    }
}
