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


  /**
   * Returns the number of elements in the stack.
   *
   * @return number of elements in the stack
   */
  @Override
  public int size() {
    return 0;
  }

  /**
   * Checks whether the stack is empty.
   *
   * @return true if the stack is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return false;
  }

  /**
   * Returns the element at index i.
   *
   * @param i index of the element
   * @return element at index i
   * @throws IndexOutOfBoundsException if no such index exists
   */
  @Override
  public E get(int i) throws IndexOutOfBoundsException {
    return null;
  }

  /**
   * Replaces the element at index i with e and returns the replaced element.
   *
   * @param i index to be replaced by e
   * @param e element to be inserted at index i
   * @return the replaced element
   * @throws IndexOutOfBoundsException if no such index exists
   */
  @Override
  public E set(int i, E e) throws IndexOutOfBoundsException {
    return null;
  }

  /**
   * Inserts element e to the end of the list.
   *
   * @param e element to be added.
   */
  @Override
  public void add(E e) {

  }

  /**
   * Removes the element from the list and returns true if the element has been removed, false otherwise.
   *
   * @param e element to be removed.
   * @return True of removed, false otherwise
   */
  @Override
  public boolean remove(E e) {
    return false;
  }

  /**
   * Returns true if the list contains the element, false otherwise
   *
   * @param e element to be searched for.
   * @return True if the list contains the element.
   */
  @Override
  public boolean contains(E e) {
    return false;
  }

  private static class Node<E> {

    private E element = null;
    private Node<E> next = null;

    private Node() {
    }

    private Node(E element) {
      this.element = element;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
      return "value=" + element + " next=" + ((next != null) ? next.element : "NULL");
    }
  }

}

