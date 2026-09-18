package com.training.bankapp;

public class App {

    public static void main(String[] args) {

        // Savings Account
        SavingsAccount savings = new SavingsAccount(
                "S101",
                "Ravi",
                10000,
                6.5,
                2000
        );

        System.out.println("----- SAVINGS ACCOUNT -----");
        savings.displayAccountDetails();

        savings.deposit(2000);
        savings.withdraw(3000);

        System.out.println("Interest: " + savings.calculateInterest());
        System.out.println("Final Balance: " + savings.getBalance());


        // Current Account
        CurrentAccount current = new CurrentAccount(
                "C101",
                "Priya",
                5000,
                10000
        );

        System.out.println("\n----- CURRENT ACCOUNT -----");
        current.displayAccountDetails();

        current.deposit(5000);
        current.withdraw(12000);

        System.out.println("Final Balance: " + current.getBalance());


        // Fixed Deposit Account
        FixedDepositAccount fixedDeposit = new FixedDepositAccount(
                "F101",
                "Amit",
                50000,
                7.5,
                3
        );

        System.out.println("\n----- FIXED DEPOSIT ACCOUNT -----");
        fixedDeposit.displayAccountDetails();

        fixedDeposit.withdraw(10000);

        System.out.println("Maturity Amount: "
                + fixedDeposit.calculateMaturityAmount());
    }
}