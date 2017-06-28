package com.elar.algorithms.data_structures;

import com.elar.algorithms.data_structures.interfaces.List;

/**
 * Linked List (doubly link). A linked list is a data structure consisting
 * of a group of nodes which together represent a sequence.
 * http://en.wikipedia.org/wiki/Linked_list
 *
 * @author Elias
 */
public class DoublyLinkedList<E> implements List<E> {

    private int size = 0;
    private Node<E> head = null;
    private Node<E> tail = null;

    /**
     * Inserts element e to the end of the list.
     *
     * @param e element to be added.
     */
    @Override
    public void add(E e) {
        addLast(new Node<>(e));
    }

    /**
     * Adds a new node to the front of the list.
     *
     * @param node node to be added to the front of the list.
     */
    public void addFirst(Node<E> node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            Node<E> first = head;
            first.prev = node;
            node.next = first;
            head = node;
        }
        size++;
    }

    /**
     * Adds a new node to the end of the list.
     *
     * @param node node to be added to the end of the list.
     */
    public void addLast(Node<E> node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            Node<E> last = tail;
            last.next = node;
            node.prev = last;
            tail = node;
        }
        size++;
    }

    /**
     * Removes the element from the list and returns true if the element has been removed, false otherwise.
     *
     * @param e element to be removed.
     * @return True of removed, false otherwise
     */
    @Override
    public boolean remove(E e) {

        Node<E> current = head;
        while (current != null && (!current.element.equals(e))) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }

        if (current.equals(tail)) {
            tail = current.prev;
        }

        Node<E> previous = current.prev;
        Node<E> next = current.next;
        if (previous != null && next != null) {
            previous.next = next;
            next.prev = previous;
        } else if (previous != null) {
            // current is tail
            previous.next = null;
        } else if (next != null) {
            // current is head
            head = next;
            head.prev = null;
        } else {
            head = null;
        }
        size--;
        return true;
    }

    public void removeFirst() {
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void removeLast() {
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = head.prev;
            tail.next = null;
        }
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks whether the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns true if the list contains the element, false otherwise
     *
     * @param e element to be searched for.
     * @return True if the list contains the element.
     */
    @Override
    public boolean contains(E e) {
        Node<E> current = head;
        while (current != null && (!current.element.equals(e))) {
            current = current.next;
        }
        return current != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<E> current = head;
        String prefix = "";
        while (current != null) {
            builder.append(prefix);
            prefix = " --> ";
            builder.append(current);
            current = current.next;
        }
        builder.insert(0, "DoublyLinkedList[");
        builder.append("]");
        return builder.toString();
    }

    private class Node<T> {
        private T element = null;
        private Node<T> prev = null;
        private Node<T> next = null;

        private Node(T element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return "Node[element=" + element + ", previous=" + ((prev != null) ? prev.element : "NULL")
                    + ", next=" + ((next != null) ? next.element + "]" : "NULL]");
        }
    }
}
