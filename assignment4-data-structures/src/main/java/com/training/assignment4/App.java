package com.training.assignment4;

public class App {
    public static void main(String[] args) {
        IntStack stack = new IntStack(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack peek: " + stack.peek());
        System.out.println("Stack pop: " + stack.pop());
        print("Stack iterator: ", stack.iterator());

        IntQueue queue = new IntQueue(3);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Queue peek: " + queue.peek());
        System.out.println("Queue dequeue: " + queue.dequeue());
        print("Queue iterator: ", queue.iterator());

        LinkedList<String> list = new LinkedList<String>();
        list.addFirst("B");
        list.addFirst("A");
        list.addLast("D");
        list.insert(2, "C");
        list.delete(3);
        print("Linked list iterator: ", list.iterator());

        GenericStack<Employee> employees = new GenericStack<Employee>(2);
        employees.push(new Employee(101, "Ravi"));
        employees.push(new Employee(102, "Priya"));
        System.out.println("Employee stack peek: " + employees.peek());
        print("Employee stack iterator: ", employees.iterator());

        System.out.println("[{a+b} * (c-d)] valid: "
                + BracketValidator.isValid("[{a+b} * (c-d)]"));
        System.out.println("[((a-b} * (c-d)]]] valid: "
                + BracketValidator.isValid("[((a-b} * (c-d)]]]"));
    }

    private static <T> void print(String heading, SimpleIterator<T> iterator) {
        System.out.print(heading);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
