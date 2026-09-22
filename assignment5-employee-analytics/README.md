# Assignment 5 — Employee Analytics with Collections and Streams

## Project location

`assignment5-employee-analytics`

## Files

- `Employee.java` — employee model with constructor, getters, setters, and `toString()`.
- `DataProvider.java` — all 15 required sample employees.
- `EmployeeService.java` — Collections, Stream API, grouping, partitioning, Optional, dashboard, and bonus exercises.
- `EmployeeAnalyticsApp.java` — console demonstration.
- `EmployeeServiceTest.java` — JUnit 4 tests for 20 service behaviours.

## Features completed

- List, Set, and Map operations
- Traditional-loop and Stream employee lookup
- Filtering, mapping, sorting, aggregation, grouping, and partitioning
- Optional-based employee lookups
- Highest/lowest/top-three/second-distinct-highest salary analytics
- Department salary summary with `DoubleSummaryStatistics`
- All listed bonus analytics operations
- Employee analytics dashboard

## Run in Eclipse

1. Select **File > Import > Maven > Existing Maven Projects**.
2. Choose `C:\Users\10097441\eclipse-workspace\assignment5-employee-analytics`.
3. Open `EmployeeAnalyticsApp.java`.
4. Right-click it and select **Run As > Java Application**.
5. To run tests: right-click `EmployeeServiceTest.java` and select **Run As > JUnit Test**.

## Expected test result

The test class contains 20 test methods. A successful run shows a green JUnit bar with:

```text
Runs: 20/20
Failures: 0
Errors: 0
```
