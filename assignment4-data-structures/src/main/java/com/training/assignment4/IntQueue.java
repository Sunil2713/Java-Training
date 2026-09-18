package com.training.assignment4;

public class IntQueue implements SimpleIterable<Integer> {
    private final int[] values;
    private int front;
    private int rear = -1;
    private int size;

    public IntQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
        values = new int[capacity];
    }

    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full.");
        }
        rear = (rear + 1) % values.length;
        values[rear] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        int value = values[front];
        front = (front + 1) % values.length;
        size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return values[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == values.length;
    }

    @Override
    public SimpleIterator<Integer> iterator() {
        return new SimpleIterator<Integer>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more queue values.");
                }
                return values[(front + index++) % values.length];
            }
        };
    }
}
