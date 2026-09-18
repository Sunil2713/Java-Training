package com.training.bankapp;

public class SalaryAccount extends Account {

    private String companyName;
    private double monthlySalary;

    public SalaryAccount(String accountNumber, String holderName, double balance,
            String companyName, double monthlySalary) {
        super(accountNumber, holderName, balance);
        this.companyName = companyName;
        this.monthlySalary = monthlySalary;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
        } else if (amount > getBalance()) {
            System.out.println("Withdrawal rejected. Insufficient balance.");
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawal successful: " + amount);
        }
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Company Name: " + companyName);
        System.out.println("Monthly Salary: " + monthlySalary);
    }
}
