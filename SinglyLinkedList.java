package prj5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Paul Yang (906394368)
/**
 * SinglyLinkedList Class
 * 
 * @param <T>
 *            generic class
 * @author Paul Yang <yangaapaul@vt.edu>
 * @version Nov 18, 2021
 */
public class SinglyLinkedList<T> {

    private Node<T> firstNode;
    private int size;

    /**
     * SinglyLinkedList Constructor
     */
    public SinglyLinkedList() {
        firstNode = null;
        size = 0;
    }


    /**
     * Gets the number of elements in the linked list
     *
     * @return size
     */
    public int size() {
        return size;
    }


    /**
     * @param compare
     *            specific compare used to sort
     *            sorts linked list using specific comparator
     */
    public void sort(Comparator<T> compare) {
        Node<T> unsorted = firstNode.next;
        Node<T> sorted = firstNode;
        sorted.next = null;
        while (unsorted != null) {
            Node<T> temp = unsorted;
            unsorted = unsorted.next;
            insertInOrder(compare, temp);
        }

    }


    /**
     * @param c
     *            compare method used for helper method
     * @param temp
     *            node that is inserted
     */
    private void insertInOrder(Comparator<T> c, Node<T> temp) {
        T item = temp.getData();
        Node<T> prev = null;
        Node<T> curr = firstNode;
        while (curr != null && c.compare(item, curr.getData()) > 0) {
            prev = curr;
            curr = curr.next;
        }
        if (prev != null) {
            prev.next = temp;
            temp.next = curr;
        }
        else {
            temp.next = firstNode;
            firstNode = temp;
        }

    }


    /**
     * Checks if the array is empty
     *
     * @return boolean if the array is empty
     */
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Removes all elements in the linked list
     */
    public void clear() {
        firstNode = null;
        size = 0;
    }


    /**
     * Returns a string representation of the list
     * 
     * @return string of the linked list
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();

        Node<T> current = firstNode;
        while (current != null) {
            sb.append(current.getData());
            sb.append("\n");
            current = current.next;
        }

        return sb.toString();
    }


    /**
     * Returns true if the two linked lists are equal
     * 
     * @param obj
     *            list that is being compared to
     * @return a boolean whether two lists are equals
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            SinglyLinkedList<T> other = ((SinglyLinkedList<T>)obj);
            if (other.size() == this.size()) {
                Node<T> current = firstNode;
                Node<T> otherCurrent = other.firstNode;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }

        return false;
    }


    /**
     * @param entry
     *            item to be added to linked list
     *            adds entry to linked list
     */
    public void add(T entry) {
        if (entry == null) {
            throw new IllegalArgumentException("null entry");
        }
        Node<T> curr = firstNode;

        if (isEmpty()) {
            firstNode = new Node<T>(entry);
        }

        else {
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.setNext(new Node<T>(entry));
        }
        size++;
    }

    /**
     * @param <T>
     *            generic inner class
     *            Inner Node Class
     */
    public static class Node<T> {
        private T data;
        private Node<T> next;

        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(T d) {
            data = d;
        }


        /**
         * Sets the firstNode after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<T> n) {
            next = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<T> next() {
            return next;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public T getData() {
            return data;
        }
    }


    private class SinglyLinkedListIterator<A> implements Iterator<T> {
        private Node<T> curr;

        /**
         * SinglyLinkedListIterator Constructor
         */
        public SinglyLinkedListIterator() {

            curr = firstNode;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return (curr != null);
        }


        /**
         * returns the value of curr and then increments it
         *
         * @return the value of curr
         * @throws NoSuchElementException
         *             if no nodes are left in the linked list
         */
        @Override
        public T next() {
            if (curr == null) {
                throw new NoSuchElementException();
            }
            T data = curr.getData();
            curr = curr.next();
            return data;
        }
    }

    /**
     * method creates an iterator
     *
     * @return new Iterator object
     */
    public Iterator<T> iterator() {
        return new SinglyLinkedListIterator<T>();
    }
}
