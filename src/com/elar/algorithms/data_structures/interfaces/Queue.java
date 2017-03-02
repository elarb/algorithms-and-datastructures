package com.elar.algorithms.data_structures.interfaces;

public interface Queue<E> {

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
   * Inserts an element at the rear of the queue.
   *
   * @param e element to be inserted
   */
  void enqueue(E e);

  /**
   * Returns the first element of the queue (null if empty).
   *
   * @return first element of the queue
   */
  E first();

  /**
   * Removes and returns the first element of the queue (or null if empty).
   *
   * @return first element of the queues
   */
  E dequeue();

  /**
   * Add an element to the beginning of the queue.
   *
   * @param element to add to queue.
   * @return True if added to queue.
   */
  public boolean offer(E element);

  /**
   * Remove a value from the tail of the queue.
   *
   * @return value from the tail of the queue.
   */
  public E poll();

  /**
   * Get but do not remove tail of the queue.
   *
   * @return value from the tail of the queue.
   */
  public E peek();
}
