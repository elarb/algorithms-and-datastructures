package com.elar.algorithms.data_structures.interfaces;

import java.util.EmptyStackException;

/**
 * A collection of objects that are inserted and removed according to the last-in, first-out (LIFO) principle.
 */
public interface Stack<E> {

  /**
   * Insert an element at the top of the Stack.
   *
   * @param e the element to be inserted
   */
  void push(E e);

  /**
   * Returns the element at the top of the Stack.
   *
   * @return element at the top of the Stack
   * @throws EmptyStackException if the Stack is empty
   */
  E peek() throws EmptyStackException;

  /**
   * Removes and returns the top element from the Stack.
   *
   * @return element at the top of the Stack
   * @throws EmptyStackException if the Stack is empty
   */
  E pop() throws EmptyStackException;

  /**
   * Returns the number of elements in the Stack.
   *
   * @return number of elements in the Stack
   */
  int size();

  /**
   * Checks whether the Stack is empty.
   *
   * @return true if the Stack is empty, false otherwise
   */
  boolean isEmpty();
}
