/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edwin
 */
import java.util.NoSuchElementException;

public class LinkedList<T> implements ListInterface<T> {

    private Node firstNode;
    private Node lastNode;
    private int count;

    public LinkedList() {
        firstNode = null;
        lastNode = null;
        count = 0;
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);

        if (!isEmpty()) {
            newNode.prev = lastNode;
            lastNode.next = newNode;
        } else {
            firstNode = newNode;
        }

        lastNode = newNode;
        count++;
        return true;
    }

    @Override
    public boolean add(int givenPosition, T newEntry) {
        Node tempNode;

        if (givenPosition > count || givenPosition < 0) {
            throw new NoSuchElementException("No such things!!!");
        }

        Node newNode = new Node(newEntry);
        if (!isEmpty()) {

            tempNode = firstNode;
            int i = givenPosition;
            while (i != 0) {
                tempNode = tempNode.next;
                i--;
            }

            if (givenPosition == 0) {
                tempNode = firstNode;

                firstNode = newNode;
                newNode.prev = firstNode;
                newNode.next = tempNode;
                tempNode.prev = newNode;

            } else if (givenPosition == count) {
                tempNode = lastNode;

                lastNode = newNode;
                newNode.next = lastNode;
                newNode.prev = tempNode;
                tempNode.next = newNode;
            } else {
                newNode.prev = tempNode.prev;
                newNode.next = tempNode;

                tempNode.prev.next = newNode;
                tempNode.prev = newNode;
            }
        } else {
            firstNode = newNode;
            lastNode = newNode;
        }
        count++;
        return true;
    }

    @Override
    public T remove(int givenPosition) {
        T element;
        Node tempNode;

        if (givenPosition > count - 1) {
            throw new NoSuchElementException("No such things!!!");
        }

        tempNode = firstNode;
        int i = givenPosition;
        while (i != 0) {
            tempNode = tempNode.next;
            i--;
        }
        element = tempNode.data;

        // adjust here
        // if remove last one, need to adjust lastNode
        // let's do general first
        // if remove first one, need to adjust firstNode
        if (givenPosition == 0) {
            firstNode = firstNode.next;
            if (count != 1) {
                firstNode.prev = null;
            }
        } else if (givenPosition == count - 1) {
            lastNode = lastNode.prev;
            if (count != 1) {
                lastNode.next = null;
            }
        } else {
            tempNode.prev.next = tempNode.next;
            tempNode.next.prev = tempNode.prev;
            // Above code is equal to:
//        tempNode1 = tempNode.prev;
//        tempNode2 = tempNode.next;
//        
//        tempNode1.next = tempNode2;
//        tempNode2.prev = tempNode1;
            /////////////////////////////
        }

        count--;
        return element;
    }

    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
    }
    
    @Override
  public boolean set(int givenPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= count)) {
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition - 1; ++i) {
        // System.out.println("Trace| currentNode.data = " + currentNode.data + "\t, i = " + i);
        currentNode = currentNode.next;		// advance currentNode to next node
      }
      currentNode.data = newEntry;	// currentNode is pointing to the node at givenPosition
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }
    
    @Override
    public T get(int givenPosition) {
        if (givenPosition < 0 || givenPosition >= count) {
            throw new IndexOutOfBoundsException();
        } else {
            Node current = firstNode;
            for (int i = 0; i < givenPosition; i++) {
                current = current.next;
            }
            return current.data;
        }
    }
    
    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        Node tempNode;
        String str = "";

        if (count != 0) {
            tempNode = firstNode;

            for (int i = 0; i < count; i++) {

                str += tempNode.data;
                str += ", ";

                tempNode = tempNode.next;
            }

            str += "\b\b"; //remove last comma
        }

        return str;
    }

    @Override
    public boolean addToLast(T newEntry) {
        Node newNode = new Node(newEntry);

        if (!isEmpty()) {  // if the list got data
            lastNode.next = newNode; 
            newNode.prev = lastNode;

            lastNode = newNode;
            newNode.next = lastNode;
            count++;
        } else {
            add(newEntry);
        }
        return true;
    }

    @Override
    public boolean addToFirst(T newEntry) {
        Node newNode = new Node(newEntry);
        Node tempNode;
        if (!isEmpty()) {

            tempNode = firstNode;

            firstNode = newNode;
            newNode.prev = firstNode;
            newNode.next = tempNode;
            tempNode.prev = newNode;
            count++;
        } else {
            add(newEntry);
        }
        return true;
    }

    @Override
    public T removeFront() {
        T element;
        Node tempNode;
        tempNode = firstNode;
        tempNode = tempNode.next;
        element = tempNode.data;
        firstNode = firstNode.next;
        firstNode.prev = null;
        count--;
        return element;
    }

    @Override
    public T removeBack() {
        T element;
        Node tempNode;
        tempNode = firstNode;    // 
        tempNode = tempNode.next; // 
        element = tempNode.data; // 
        lastNode = lastNode.prev;
        lastNode.next = null;
        count--;
        return element;
    } // remove the last 

    // inner class node
    class Node {

        private Node next;
        private Node prev;
        private T data;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(T data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    } // like pointer select the thing u want
}
