package com.elar.algorithms.data_structures.interfaces;

public interface PositionalList<E> {


  /**
   * Returns the number of elements in the list.
   *
   * @return the number of elements in the list
   */
  int size();

  /**
   * Checks whether the list is empty.
   *
   * @return true if the list is empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Returns the first Position in the list (or null, if empty).
   *
   * @return the first position in the list
   */
  Position<E> first();

  /**
   * Returns the last Position in the list (or null, if empty).
   *
   * @return the last position in the list
   */
  Position<E> last();

  /**
   * Returns the Position immediately before Position p (or null, if p is first).
   *
   * @return the position immediately before position p
   * @throws IllegalArgumentException if no such position exists
   */
  Position<E> before(Position<E> p) throws IllegalArgumentException;

  /**
   * Returns the Position immediately after Position p (or null, if p is last).
   *
   * @return the position immediately after position p
   * @throws IllegalArgumentException if no such position exists
   */
  Position<E> after(Position<E> p) throws IllegalArgumentException;


  /**
   * Inserts element e at the front of the list and returns its new Position.
   *
   * @param e element to be inserted
   * @return the position of the
   */
  Position<E> addFirst(E e);

  /**
   * Inserts element e at the back of the list and returns its new Position.
   *
   * @param e
   * @return
   */
  Position<E> addLast(E e);

  /**
   * Inserts element e immediately before Position p and returns its new Position.
   *
   * @param p
   * @param e
   * @return
   * @throws IllegalArgumentException
   */
  Position<E> addBefore(Position<E> p, E e)
      throws IllegalArgumentException;

  /**
   * Inserts element e immediately after Position p and returns its new Position.
   *
   * @param p
   * @param e
   * @return
   * @throws IllegalArgumentException
   */
  Position<E> addAfter(Position<E> p, E e)
      throws IllegalArgumentException;

  /**
   * Replaces the element stored at Position p and returns the replaced element.
   *
   * @param p
   * @param e
   * @return
   * @throws IllegalArgumentException
   */
  E set(Position<E> p, E e) throws IllegalArgumentException;

  /**
   * Removes the element stored at Position p and returns it (invalidating p).
   *
   * @param p
   * @return
   * @throws IllegalArgumentException
   */
  E remove(Position<E> p) throws IllegalArgumentException;
}
