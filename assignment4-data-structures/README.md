# Assignment 4 — Data Structures, Iterator, Generics, and JUnit

## Implemented requirements

1. `IntStack` — `push`, `pop`, `peek`, `isEmpty`, and `isFull`.
2. `IntQueue` — `enqueue`, `dequeue`, `peek`, `isEmpty`, and `isFull`.
3. Custom iterator pattern — `SimpleIterator<T>` and `SimpleIterable<T>`.
4. `LinkedList<T>` — add front/end, insert by position, delete first/last/by position, and traverse with the custom iterator.
5. `GenericStack<T>` — works for any type; `App` stores `Employee` objects.
6. `BracketValidator` — validates matching `()`, `[]`, and `{}` brackets using `GenericStack<Character>`.
7. JUnit 4 tests — `DataStructureTest` covers all required classes.

## Run in Eclipse

1. Import `assignment4` as an **Existing Maven Project**.
2. Run `com.training.assignment4.App` as a Java Application.
3. Right-click the project and select **Run As → Maven test** after Maven is configured in Eclipse.

## Expected bracket validation

```text
[{a+b} * (c-d)]              -> true
[((a-b} * (c-d)]]]           -> false
```
