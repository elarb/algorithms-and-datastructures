package com.elar.algorithms.data_structures.interfaces;

public interface Position<E> {

  /**
   * Returns the element stored at this position.
   *
   * @return the element
   * @throws IllegalStateException if position no longer valid
   **/

  E getElement() throws IllegalStateException;
}
