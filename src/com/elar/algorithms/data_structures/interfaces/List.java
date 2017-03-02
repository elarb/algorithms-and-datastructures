package com.elar.algorithms.data_structures.interfaces;

public interface List<E> {

  /**
   * Returns the number of elements in the stack.
   *
   * @return number of elements in the stack
   */
  public int size();

  /**
   * Checks whether the stack is empty.
   *
   * @return true if the stack is empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Returns the element at index i.
   *
   * @param i index of the element
   * @return element at index i
   * @throws IndexOutOfBoundsException if no such index exists
   */
  E get(int i) throws IndexOutOfBoundsException;

  /**
   * Replaces the element at index i with e and returns the replaced element.
   *
   * @param i index to be replaced by e
   * @param e element to be inserted at index i
   * @return the replaced element
   * @throws IndexOutOfBoundsException if no such index exists
   */
  E set(int i, E e) throws IndexOutOfBoundsException;

  /**
   * Inserts element e to the end of the list.
   *
   * @param e element to be added.
   */
  void add(E e);

  /**
   * Removes the element from the list and returns true if the element has been removed, false otherwise.
   *
   * @param e element to be removed.
   * @return True of removed, false otherwise
   */
  boolean remove(E e);

  /**
   * Returns true if the list contains the element, false otherwise
   *
   * @param e element to be searched for.
   * @return True if the list contains the element.
   */
  boolean contains(E e);

}
