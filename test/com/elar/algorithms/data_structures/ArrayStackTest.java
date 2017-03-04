package com.elar.algorithms.data_structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

  @Test
  public void testConstructor() {
    ArrayStack tmp = new ArrayStack();
    assertArrayEquals(new Object[1], tmp.getElements());
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testGrowShrink() {
    ArrayStack s = new ArrayStack();
    s.push(1);
    s.push(2);
    assertEquals("<ArrayStack[1,2]>(Size=2, Cap=2)", s.toString());
    s.push(3);
    assertEquals(4, s.getElements().length);
    s.pop();
    s.pop();
    s.pop();
    assertEquals(2, s.getElements().length);
  }

  @Test
  void push() {
    ArrayStack<Integer> stack = new ArrayStack<>();
    stack.push(1);
    stack.push(2);
    Integer[] ints = {1, 2};
    assertArrayEquals(ints, stack.getElements());
  }

  @Test
  void top() {
    ArrayStack<Integer> stack = new ArrayStack<>();
    stack.push(1);
    stack.push(2);
    assertTrue(stack.peek() == 2);
  }

  @Test
  void pop() {
    ArrayStack<Integer> stack = new ArrayStack<>();
    stack.push(1);
    assertTrue(stack.pop() == 1);
    assertArrayEquals(new Integer[1], stack.getElements());
  }


  @Test
  void size() {
    ArrayStack<Integer> stack = new ArrayStack<>();
    stack.push(1);
    stack.push(2);
    assertTrue(stack.size() == 2);
  }

  @Test
  void isEmpty() {
    ArrayStack<Integer> stack = new ArrayStack<>();
    stack.push(1);
    stack.pop();
    assertTrue(stack.isEmpty());
  }

  @Test
  @SuppressWarnings("unchecked")
  void to_String() {
    ArrayStack s = new ArrayStack();
    s.push(1);
    s.push(2);
    assertEquals("<ArrayStack[1,2]>(Size=2, Cap=2)", s.toString());
  }


}