package com.training.bankapp;

public class App {

    public static void main(String[] args) {
        // Step 8: parent references holding child objects.
        SavingsAccount raviSavings = new SavingsAccount("S101", "Ravi", 10000, 6.5, 2000);
        CurrentAccount priyaCurrent = new CurrentAccount("C101", "Priya", 5000, 10000);
        FixedDepositAccount amitFixedDeposit = new FixedDepositAccount("F101", "Amit", 50000, 7.5, 3);
        SalaryAccount nehaSalary = new SalaryAccount("SA101", "Neha", 25000, "Dover", 50000);

        Account account1 = raviSavings;
        Account account2 = priyaCurrent;
        Account account3 = amitFixedDeposit;
        Account account4 = nehaSalary;

        // Step 9: one collection processes every account through the parent type.
        Account[] accounts = { account1, account2, account3, account4 };

        System.out.println("----- INITIAL ACCOUNT DETAILS -----");
        for (Account account : accounts) {
            account.displayAccountDetails();
            System.out.println();
        }

        // Step 10: required sample transactions, called through Account references.
        System.out.println("----- TRANSACTIONS -----");
        account1.deposit(2000);
        account1.withdraw(3000);

        account2.deposit(5000);
        account2.withdraw(12000);

        account3.withdraw(10000);

        // Step 14: SalaryAccount also works without changing the collection loop.
        account4.deposit(5000);
        account4.withdraw(10000);

        System.out.println("\nRavi savings interest: " + raviSavings.calculateInterest());
        System.out.println("Amit fixed-deposit maturity amount: "
                + amitFixedDeposit.calculateMaturityAmount());

        System.out.println("\n----- FINAL ACCOUNT DETAILS -----");
        for (Account account : accounts) {
            account.displayAccountDetails();
            System.out.println();
        }
    }
}
