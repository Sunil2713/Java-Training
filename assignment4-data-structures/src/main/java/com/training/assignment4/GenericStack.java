package com.training.assignment4;

public class GenericStack<T> implements SimpleIterable<T> {
    private final Object[] values;
    private int top = -1;

    public GenericStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
        values = new Object[capacity];
    }

    public void push(T value) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full.");
        }
        values[++top] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        T value = (T) values[top];
        values[top--] = null;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return (T) values[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == values.length - 1;
    }

    @Override
    public SimpleIterator<T> iterator() {
        return new SimpleIterator<T>() {
            private int index = top;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @SuppressWarnings("unchecked")
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more stack values.");
                }
                return (T) values[index--];
            }
        };
    }
}
