package com.elar.algorithms.data_structures;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> list;
    private SinglyLinkedList<Integer> list2;

    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList<>();
        list2 = new SinglyLinkedList<>();
    }

    @Test
    void add() {
        list.add(10);
        assertThat(list.contains(10)).isTrue();
    }

    @Test
    void size() {
        list.add(10);
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    void isEmpty() {
        list.add(10);
        list.remove(10);
        assertThat(list.isEmpty()).isTrue();
    }

    @Test
    void contains() {
        list.add(10);
        assertThat(list.contains(10)).isTrue();
        assertThat(list.contains(0)).isFalse();
    }

    @Test
    void merge() {
        list.add(10);
        list2.add(20);
        list.merge(list2);
        assertThat(list.contains(20)).isTrue();
        assertThat(list.size()).isEqualTo(2);
    }

    @AfterEach
    void tearDown() {
        list = null;
    }

}