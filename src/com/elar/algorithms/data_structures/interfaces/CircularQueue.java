package com.elar.algorithms.data_structures.interfaces;

public interface CircularQueue<E> extends Queue<E> {

  /**
   * Rotates the front element tof the queue to the back of the queue.
   */
  void rotate();
}
