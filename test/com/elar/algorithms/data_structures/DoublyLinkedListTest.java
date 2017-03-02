package com.elar.algorithms.data_structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class DoublyLinkedListTest {

  @Test
  void add() {
    DoublyLinkedList<String> list = new DoublyLinkedList<>();
    list.add("First");
    list.add("Second");
    assertEquals(2, list.size());
  }

  @Test
  void remove() {
    DoublyLinkedList<String> list = new DoublyLinkedList<>();
    list.add("First");
    list.add("Second");
    list.remove("Second");
    assertEquals(1, list.size());
  }

  @Test
  void size_empty() {
    DoublyLinkedList<String> list = new DoublyLinkedList<>();
    assertEquals(0, list.size());
  }

  @Test
  void size_not_empty() {
    DoublyLinkedList<String> list = new DoublyLinkedList<>();
    for (int i = 0; i < 10; i++) {
      list.add("Cat");
    }
    assertEquals(10, list.size());
  }

  @Test
  void isEmpty() {
    DoublyLinkedList<String> list = new DoublyLinkedList<>();
    assertTrue(list.isEmpty());
    list.add("First");
    list.remove("First");
    assertTrue(list.isEmpty());
  }

  @Test
  void contains() {
    DoublyLinkedList<String> list = new DoublyLinkedList<>();
    list.add("Cat");
    list.add("Dog");
    list.add("Chicken");
    assertTrue(list.contains("Dog"));
  }

  @Test
  void contains_not() {
    DoublyLinkedList<String> list = new DoublyLinkedList<>();
    list.add("Cat");
    list.add("Dog");
    assertTrue(!list.contains("Chicken"));
  }

  @Test
  void to_String() {
    DoublyLinkedList<String> list = new DoublyLinkedList<>();
    list.add("First");
    list.add("Second");
    assertEquals("DoublyLinkedList[Node[element=First, previous=NULL, next=Second] --> Node[element=Second, previous=First, next=NULL]]", list.toString());

  }

}