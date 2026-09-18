# Assignment 3 — Inheritance and Polymorphism

## Implemented steps

- **Steps 2–7:** `Account` is an abstract parent class. `SavingsAccount`, `CurrentAccount`, and `FixedDepositAccount` extend it and override `withdraw(double amount)`.
- **Step 8:** `App` stores the three required child objects using `Account` references: `account1`, `account2`, and `account3`.
- **Step 9:** `Account[] accounts` processes all account objects in loops without `instanceof` or account-type conditional logic.
- **Step 10:** The required Ravi, Priya, and Amit sample transactions are performed.
- **Step 11:** Calling `withdraw()` through an `Account` reference dynamically executes the method belonging to the actual child object.
- **Step 12:** Shared data belongs only to `Account`; account-specific withdrawal rules are in child classes.
- **Step 14:** `SalaryAccount` extends `Account` and is added to the same `Account[]` without changing either loop.

## Conceptual answers — Step 13

1. **Parent class:** `Account`.
2. **Child classes:** `SavingsAccount`, `CurrentAccount`, `FixedDepositAccount`, and `SalaryAccount`.
3. **Why common properties are in `Account`:** Every account has an account number, holder name, and balance. Defining them once prevents duplicate code.
4. **SavingsAccount-specific properties:** Interest rate and minimum balance.
5. **CurrentAccount-specific property:** Overdraft limit.
6. **FixedDepositAccount-specific properties:** Interest rate and tenure in years.
7. **Overridden method:** `withdraw(double amount)`.
8. **Purpose of `super()`:** It calls the `Account` constructor so the parent fields are initialized.
9. **Runtime polymorphism:** A parent reference holds a child object and the overridden child method runs at runtime.
10. **Dynamic method dispatch:** Java selects the overridden method from the real object type when the method call is made.
11. For `Account account = new SavingsAccount(...);`, the reference type is `Account`, the object type is `SavingsAccount`, and `SavingsAccount.withdraw()` executes because the object is a savings account.

## Run

Run `com.training.bankapp.App` as a Java application in Eclipse.
