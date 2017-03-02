package com.elar.algorithms.data_structures.interfaces;

public interface Stack<E> {

  /**
   * Returns the number of elements in the stack.
   *
   * @return number of elements in the stack
   */
  int size();

  /**
   * Checks whether the stack is empty.
   *
   * @return true if the stack is empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Insert an element at the top of the stack.
   *
   * @param e the element to be inserted
   */
  void push(E e);

  /**
   * Returns the element at the top of the stack.
   *
   * @return element at the top of the stack (or null if empty)
   */
  E top();

  /**
   * Removes and returns the top element from the stack.
   *
   * @return element to be removed (or null if empty)
   */
  E pop();
}
