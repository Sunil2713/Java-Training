package com.training.assignment4;

public class LinkedList<T> implements SimpleIterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void addFirst(T value) {
        Node<T> node = new Node<T>(value);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = node;
        }
        size++;
    }

    public void addLast(T value) {
        Node<T> node = new Node<T>(value);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void insert(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }

        Node<T> previous = nodeAt(index - 1);
        Node<T> node = new Node<T>(value);
        node.next = previous.next;
        previous.next = node;
        size++;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty.");
        }
        T value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public T deleteLast() {
        if (head == null) {
            throw new IllegalStateException("List is empty.");
        }
        if (head == tail) {
            return deleteFirst();
        }
        Node<T> previous = nodeAt(size - 2);
        T value = tail.value;
        previous.next = null;
        tail = previous;
        size--;
        return value;
    }

    public T delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        Node<T> previous = nodeAt(index - 1);
        T value = previous.next.value;
        previous.next = previous.next.next;
        size--;
        return value;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return nodeAt(index).value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node<T> nodeAt(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public SimpleIterator<T> iterator() {
        return new SimpleIterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more list values.");
                }
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        private Node(T value) {
            this.value = value;
        }
    }
}
