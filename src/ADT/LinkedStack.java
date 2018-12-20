/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author asus
 */
public class LinkedStack<T> implements StackInterface<T>{
    private int n;          // size of the stack
    private Node first;     // top of stack

    // helper linked list class
    private class Node {
        private T item;
        private Node next;
    }

    /**
     * Initializes an empty stack.
     */
    public LinkedStack() {
        first = null;
        n = 0;
        assert check();
    }

    /**
     * Is this stack empty?
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in the stack.
     * @return the number of items in the stack
     */
    public int size() {
        return n;
    }

    /**
     * Adds the item to this stack.
     * @param item the item to add
     */
    public void push(T item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
        assert check();
    }

    /**
     * Removes and returns the item most recently added to this stack.
     * @return the item most recently added
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        T item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        assert check();
        return item;                   // return the saved item
    }


    /**
     * Returns (but does not remove) the item most recently added to this stack.
     * @return the item most recently added to this stack
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }
 

    // check internal invariants
    private boolean check() {

        // check a few properties of instance variable 'first'
        if (n < 0) {
            return false;
        }
        if (n == 0) {
            if (first != null) return false;
        }
        else if (n == 1) {
            if (first == null)      return false;
            if (first.next != null) return false;
        }
        else {
            if (first == null)      return false;
            if (first.next == null) return false;
        }

        // check internal consistency of instance variable n
        int numberOfNodes = 0;
        for (Node x = first; x != null && numberOfNodes <= n; x = x.next) {
            numberOfNodes++;
        }
        if (numberOfNodes != n) return false;

        return true;
    }
}