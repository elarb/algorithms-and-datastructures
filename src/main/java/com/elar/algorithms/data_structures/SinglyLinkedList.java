package com.elar.algorithms.data_structures;

import com.elar.algorithms.data_structures.interfaces.List;

/**
 * Linked List (Singly link). A linked list is a data structure consisting
 * of a group of nodes which together represent a sequence.
 * <p>
 * http://en.wikipedia.org/wiki/Linked_list
 *
 * @author Elias
 */
public class SinglyLinkedList<E> implements List<E> {

    private Node<E> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Inserts element e to the end of the list.
     *
     * @param e element to be added.
     */
    @Override
    public void add(E e) {
        addLast(new Node<>(e));
    }

    public void addFirst(Node<E> n) {
        n.next = head;
        head = n;
        size++;
    }

    /**
     * Adds a node at the given position, or throws an exception if no such position exists.
     *
     * @param n   node to be added
     * @param pos position where the node should be added
     * @throws IllegalArgumentException if the position doesn't exist
     */
    public void addAtPosition(Node<E> n, int pos) throws IllegalArgumentException {
        if (pos < 0 || pos > size) {
            throw new IllegalArgumentException("The position does not exist ");
        } else if (pos == 0) {
            addFirst(n);
        } else {
            Node<E> current = head;
            for (int i = 0; i < pos - 1; i++) {
                current = current.next;
            }
            n.next = current.next;
            current.next = n;
            size++;
        }
    }

    public void addLast(Node<E> n) {
        if (isEmpty()) {
            head = n;
            size++;
        } else {
            addAtPosition(n, size);
        }

    }

    /**
     * Removes and returns the node at the given position, or throws an exception if no such position exists.
     *
     * @param pos position of the node to be removed
     * @return node to be removed
     * @throws IllegalArgumentException if the position doesn't exist
     */
    public Node<E> removeFromPosition(int pos) throws IllegalArgumentException {
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("The position does not exist ");
        } else if (pos == 0) {
            return removeFirst();
        } else if (pos == size - 1) {
            return removeLast();
        } else {
            Node<E> current = head;
            Node<E> before = null;
            for (int i = 0; i < pos - 1; i++) {
                before = current;
                current = current.next;
            }
            assert before != null;
            before.next = current.next;
            return current;
        }
    }

    /**
     * Removes the element from the list and returns true if the element has been removed, false otherwise.
     *
     * @param e element to be removed.
     * @return True of removed, false otherwise
     */
    @Override
    public boolean remove(E e) {
        Node current = head;

        if (current.element.equals(e)) {
            head = null;
            --size;
            return true;
        }
        Node next = head.next;
        while (next != null) {
            if (next.element.equals(e)) {
                current.next = next.next;
                --size;
                return true;
            }
            current = next;
            next = next.next;
        }
        return false;
    }

    /**
     * Removes and returns the first node of the list.
     *
     * @return first node of the list
     */
    public Node<E> removeFirst() {
        if (head == null) {
            return null;
        }
        Node<E> first = head;
        head = head.next;
        size--;
        return first;
    }

    /**
     * Removes and returns the last node of the list.
     *
     * @return last node of the list
     * @throws IllegalStateException if the list is empty
     */
    public Node<E> removeLast() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        Node<E> current = head;
        if (head.next == null) {
            head = null;
        } else {
            Node<E> before = null;
            while (current.next != null) {
                before = current;
                current = current.next;
            }
            assert before != null;
            before.next = null;
        }
        size--;
        return current;
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

    public void merge(SinglyLinkedList<E> that) {
        while (!that.isEmpty()) {
            addLast(that.removeFirst());
        }
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
        builder.insert(0, "SinglyLinkedList[");
        builder.append("]");
        return builder.toString();
    }

    private static class Node<E> {

        private E element = null;
        private Node<E> next = null;

        private Node(E element) {
            this.element = element;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "Node[element=" + element + ", next=" + ((next != null) ? next.element + "]" : "NULL]");
        }
    }

}

