package com.elar.algorithms.data_structures.interfaces;

/**
 * A queue-like data structure that supports insertion and deletion at both the front and the back of the queue.
 */
public interface Deque<E> {

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
   * Returns the first element of the deque (null if empty).
   *
   * @return first element of the deque
   */
  E first();

  /**
   * Returns the last element of the deque (null if empty).
   *
   * @return last element of the deque
   */
  E last();

  /**
   * Inserts an element at the front of the deque.
   *
   * @param e element to be inserted at the front
   */
  void addFirst(E e);

  /**
   * Inserts an element at the end of the deque.
   *
   * @param e element to be inserted at the end
   */
  void addLast(E e);

  /**
   * Removes and returns the first element of the deque (null if empty).
   *
   * @return first element of the deque
   */
  E removeFirst();

  /**
   * Removes and returns the last element of the deque (null if empty).
   *
   * @return last element of the deque
   */
  E removeLast();
}
