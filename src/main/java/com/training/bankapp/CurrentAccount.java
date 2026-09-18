package com.training.bankapp;

public class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName,
            double balance, double overdraftLimit) {

        super(accountNumber, holderName, balance);

        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
        } else if (getBalance() - amount < -overdraftLimit) {
            System.out.println("Withdrawal rejected. Overdraft limit exceeded.");
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawal successful: " + amount);
        }
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}