package com.training.assignment4;

public class IntStack implements SimpleIterable<Integer> {
    private final int[] values;
    private int top = -1;

    public IntStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
        values = new int[capacity];
    }

    public void push(int value) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full.");
        }
        values[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return values[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return values[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == values.length - 1;
    }

    @Override
    public SimpleIterator<Integer> iterator() {
        return new SimpleIterator<Integer>() {
            private int index = top;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more stack values.");
                }
                return values[index--];
            }
        };
    }
}
