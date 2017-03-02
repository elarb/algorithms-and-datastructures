package com.elar.algorithms.data_structures;

import com.elar.algorithms.data_structures.interfaces.Stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {

  private E[] data;
  private int size;
  private int capacity;

  @SuppressWarnings("unchecked")
  public ArrayStack() {
    data = (E[]) new Object[1];
    capacity = 1;
  }

  /**
   * Insert an element at the top of the stack.
   *
   * @param e the element to be inserted
   */
  @Override
  public void push(E e) {
    if (size >= capacity) {
      grow();
    }
    data[size++] = e;
  }

  /**
   * Returns the element at the top of the stack.
   *
   * @return element at the top of the stack (or null if empty)
   */
  @Override
  public E top() throws EmptyStackException {
    if (size <= 0) {
      throw new EmptyStackException();
    }
    return data[size - 1];
  }

  /**
   * Removes and returns the top element from the stack.
   *
   * @return element to be removed (or null if empty)
   */
  @Override
  public E pop() throws EmptyStackException {
    if (size <= 0) {
      throw new EmptyStackException();
    }

    E element = data[--size];
    data[size] = null;

    if (size < capacity / 4) {
      shrink();
    }
    return element;
  }

  /**
   * Returns the number of elements in the stack.
   *
   * @return number of elements in the stack
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Checks whether the stack is empty.
   *
   * @return true if the stack is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns true if capacity is fully used
   *
   * @return true if capacity is fully used, false otherwise.
   */
  private boolean isFull() {
    return capacity == size;
  }

  /**
   * Returns a String representation of the ArrayStack
   */
  public String toString() {
    StringBuilder builder = new StringBuilder();
    String prefix = "";
    for (int i = 0; i < size; i++) {
      builder.append(prefix);
      prefix = ",";
      builder.append(data[i]);
    }
    builder.insert(0, "<ArrayStack[");
    builder.append("]>(Size=").append(size).append(", Cap=").append(capacity).append(")");
    return builder.toString();
  }

  // Grow the array by 50%
  @SuppressWarnings("unchecked")
  private void grow() {
    capacity = 2 * size;
    data = Arrays.copyOf(data, capacity);
  }

  // Shrink the array by 50%
  @SuppressWarnings("unchecked")
  private void shrink() {
    capacity = size == 0 ? 2 : size / 2;
    data = Arrays.copyOf(data, capacity);
  }

  public E[] getElements() {
    return data;
  }

}
