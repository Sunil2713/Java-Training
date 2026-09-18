package com.training.assignment4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DataStructureTest {

    @Test
    public void intStackPushPopPeekAndStatus() {
        IntStack stack = new IntStack(2);
        assertTrue(stack.isEmpty());
        stack.push(10);
        stack.push(20);
        assertTrue(stack.isFull());
        assertEquals(20, stack.peek());
        assertEquals(20, stack.pop());
        assertFalse(stack.isFull());
        assertEquals(10, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void intQueueEnqueueDequeuePeekAndCircularReuse() {
        IntQueue queue = new IntQueue(2);
        queue.enqueue(10);
        queue.enqueue(20);
        assertTrue(queue.isFull());
        assertEquals(10, queue.peek());
        assertEquals(10, queue.dequeue());
        queue.enqueue(30);
        assertEquals(20, queue.dequeue());
        assertEquals(30, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void linkedListCanAddInsertDeleteAndIterate() {
        LinkedList<String> list = new LinkedList<String>();
        list.addFirst("B");
        list.addFirst("A");
        list.addLast("D");
        list.insert(2, "C");
        assertEquals(4, list.size());
        assertEquals("C", list.get(2));
        assertEquals("D", list.deleteLast());
        assertEquals("A", list.deleteFirst());
        assertEquals("C", list.delete(1));
        assertEquals(1, list.size());
        assertEquals("B", list.get(0));

        SimpleIterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void genericStackStoresEmployeeObjects() {
        GenericStack<Employee> stack = new GenericStack<Employee>(2);
        Employee ravi = new Employee(101, "Ravi");
        Employee priya = new Employee(102, "Priya");
        stack.push(ravi);
        stack.push(priya);
        assertEquals(priya, stack.peek());
        assertEquals(priya, stack.pop());
        assertEquals(ravi, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void bracketValidatorChecksValidAndInvalidExpressions() {
        assertTrue(BracketValidator.isValid("[{a+b} * (c-d)]"));
        assertFalse(BracketValidator.isValid("[((a-b} * (c-d)]]]"));
        assertFalse(BracketValidator.isValid("([)]"));
        assertTrue(BracketValidator.isValid(""));
    }
}
