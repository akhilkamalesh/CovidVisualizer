package prj5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class that
 * 
 * @author Zachary Gaydos (zachg), Roshan Sanyal (roshans19), Akhil Kamalesh
 *         (akhilk24)
 * @version 2020.11.21
 * 
 * @param <T>
 *
 */
public class DLList<T> implements Iterable<T> {

    private static class Node<T> {

        private T data;
        private Node<T> previous;
        private Node<T> next;

        /**
         * Constructor for node that takes data input can be linked to other
         * nodes.
         * 
         * @param previous
         *            The previous node to the current node.
         * @param data
         *            Data contained in the node.
         * @param next
         *            The next node to the current node.
         */
        public Node(Node<T> previous, T data, Node<T> next) {
            this.previous = previous;
            this.data = data;
            this.next = next;
        }


        /**
         * Sets the next node that comes after the current node.
         * 
         * @param next
         *            The node you want to set as next.
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }


        /**
         * Sets the previous node that comes before the current node.
         * 
         * @param previous
         *            The node you want to set as previous.
         */
        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }


        /**
         * Gets the next node that comes after the current node.
         * 
         * @return The next node.
         */
        public Node<T> next() {
            return next;
        }


        /**
         * Gets the previous node that comes before the current node.
         * 
         * @return The previous node.
         */
        public Node<T> previous() {
            return previous;
        }


        /**
         * Gets the data contained in the node.
         * 
         * @return The data in the node.
         */
        public T getData() {
            return data;
        }


        /**
         * Sets the data contained in the node.
         * 
         * @param data
         *            The data you want the node to contain.
         */
        public void setData(T data) {
            this.data = data;
        }
    }


    /**
     * DLListIterator<T> class implements the Iterator<T> interface and this
     * class
     * is used to iterate through the DLList class
     * 
     * @author akhilkamalesh
     * @version 11/15/2020
     * @param <T>
     */
    private class DLListIterator<A> implements Iterator<T> {

        /**
         * private variables used to create the DLListIterator<T>
         */
        private Node<T> nodeIter;
        private boolean callNext;

        /**
         * Constructor for the DLListIterator.
         */
        public DLListIterator() {
            nodeIter = first;
            callNext = false;
        }


        @Override
        public boolean hasNext() {
            return nodeIter != null;
        }


        @Override
        public T next() {
            if (hasNext()) {
                callNext = true;
                T value = nodeIter.getData();
                nodeIter = nodeIter.next();
                return value;
            }
            else {
                throw new NoSuchElementException("At the end of the list");
            }
        }


        /**
         * remove() removes the last object called by the next field
         */
        public void remove() {
            if (callNext) {
                nodeIter.next.setPrevious(nodeIter.previous());
                nodeIter.previous.setNext(nodeIter.next());
                size--;
                callNext = false;
            }
            else {
                throw new IllegalArgumentException(
                    "next() has not been called");
            }
        }

    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    /**
     * 
     */
    public DLList() {
        first = null;
        last = null;
        size = 0;
    }


    /**
     * 
     * @param anEntry
     *            1
     */
    public void add(T anEntry) {
        if (anEntry == null) {
            throw new IllegalArgumentException();
        }
        if (size == 0) {
            first = new Node<T>(null, anEntry, null);
            last = first;
            size++;
        }
        else {
            last = new Node<T>(last, anEntry, null);
            last.previous().setNext(last);
            size++;
        }
    }


    /**
     * 
     * @param index
     *            1
     * @param anEntry
     *            1
     */
    public void add(int index, T anEntry) {
        if (anEntry == null || index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
        if (size == 0 || index == size) {
            add(anEntry);
        }
        else if (index == 0) {
            first = new Node<T>(null, anEntry, first);
            first.next().setPrevious(first);
            size++;
        }
        else {
            Node<T> current = first;
            for (int i = 0; i < index; i++) {
                current = current.next();
            }
            current.previous().setNext(new Node<T>(current.previous(), anEntry,
                current));
            current.setPrevious(current.previous().next());
            size++;
        }

    }


    /**
     * 
     * @return 1
     */
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        if (size == 0) {
            return null;
        }
        T[] temp = (T[])new Object[size];
        int i = 0;

        for (T item : this) {
            temp[i] = item;
            i++;
        }
        return temp;
    }


    /**
     * 
     * @param anEntry
     *            1
     */
    public void remove(T anEntry) {
        if (anEntry == null) {
            throw new IllegalArgumentException();
        }
        else if (size == 0) {
            return;
        }
        if (first.getData().equals(anEntry)) {

            first = first.next();
            if (first == null) {
                last = null;
            }
            else {
                first.setPrevious(null);
            }
            size--;
            return;
        }

        Node<T> current = first;
        for (; current != last; current = current.next()) {
            if (current.getData().equals(anEntry)) {
                current.previous().setNext(current.next());
                current.next().setPrevious(current.previous());
                size--;
                return;
            }
        }

        last = last.previous();
        last.setNext(null);
        size--;
    }


    /**
     * 
     * @param index
     *            1
     * @return 1
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            T val = first.getData();
            first = first.next();
            if (first == null) {
                last = null;
            }
            else {
                first.setPrevious(null);
            }
            size--;
            return val;
        }

        Node<T> current = first;
        for (int i = 0; current != last; current = current.next(), i++) {
            if (i == index) {
                T val = current.getData();
                current.previous().setNext(current.next());
                current.next().setPrevious(current.previous());
                size--;
                return val;
            }
        }

        T val = last.getData();
        last = last.previous();
        last.setNext(null);
        size--;
        return val;
    }


    /**
     * 
     * @return 1
     */
    public int getSize() {
        return size;
    }


    /**
     * 
     * @param anEntry
     *            1
     * @return 1
     */
    public int getPosition(T anEntry) {
        int i = 0;
        for (T item : this) {
            if (item.equals(anEntry)) {
                return i;
            }
            i++;
        }
        return -1;
    }


    /**
     * 
     * @param index
     *            1
     * @return 1
     */
    public T getAnEntry(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }

        if (index == 0) {
            return first.getData();
        }

        Node<T> current = first;
        for (int i = 0; current != last; current = current.next(), i++) {
            if (i == index) {
                return current.getData();
            }
        }

        return last.getData();

    }


    /**
     * 
     * @param anEntry
     *            1
     * @return 1
     */
    public T getAnEntry(T anEntry) {
        if (anEntry == null) {
            throw new IllegalArgumentException();
        }
        if (size == 0) {
            return null;
        }

        if (first.getData().equals(anEntry)) {
            T val = first.getData();
            return val;
        }

        Node<T> current = first;
        for (; current != last; current = current.next()) {
            if (current.getData().equals(anEntry)) {
                T val = current.getData();
                return val;
            }
        }

        if (last.getData().equals(anEntry)) {
            T val = last.getData();
            return val;
        }
        return null;
    }


    /**
     * 
     * @return 1
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 
     * @param anEntry
     *            1
     * @return 1
     */
    public boolean contains(T anEntry) {
        return getPosition(anEntry) >= 0;
    }


    /**
     * 
     * @param comparator
     *            1
     */
    public void sort(Comparator<T> comparator) {
        if (size < 2) {
            return;
        }
        Node<T> sortedPointer = first.next();
        while (sortedPointer != null) {
            T val = sortedPointer.getData();
            Node<T> current = sortedPointer.previous();
            for (; current != null && comparator.compare(val, current
                .getData()) <= 0; current = current.previous()) {
                current.next().setData(current.getData());
            }
            if (current == null) {
                first.setData(val);
            }
            else {
                current.next().setData(val);
            }
            sortedPointer = sortedPointer.next();
        }

    }

// public void sort(Comparator<T> comparator) {
// if (size <= 1) { // if the array is empty or 1 element
// return;
// }
//
// Node<T> movingNode = first.next();
//
// // Create a new chain of nodes
// Node<T> firstNode = new Node<T>(null, first.getData(), null);
// Node<T> lastNode = firstNode;
//
// while (movingNode != null) { // ends when reaches the last node
// Node<T> currentNode = firstNode;
//
// while (currentNode != null && comparator.compare(movingNode
// .getData(), currentNode.getData()) > 0) {
// currentNode = currentNode.next();
// }
//
// // create new node
// Node<T> newNode = new Node<T>(null, movingNode.getData(), null);
//
// if (currentNode == null) {
// newNode.setPrevious(lastNode);
// lastNode.setNext(newNode);
// lastNode = newNode;
// }
// else { // current is not null
// newNode.setNext(currentNode);
// newNode.setPrevious(currentNode.previous());
// currentNode.setPrevious(newNode);
// if (currentNode == firstNode) {
// firstNode = newNode;
// }
// else {
// newNode.previous().setNext(newNode);
// }
// }
//
// movingNode = movingNode.next();
// }
//
// first = firstNode;
// last = lastNode;
// }


    @Override
    public Iterator<T> iterator() {
        return new DLListIterator<T>();
    }
}
