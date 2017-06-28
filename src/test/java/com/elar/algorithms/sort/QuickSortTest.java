package com.elar.algorithms.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sort_normal() {
        int[] integers = {11, 90, 33, 71, 24, 50, 35, 30, 15, 21};
        int[] sorted = {11, 15, 21, 24, 30, 33, 35, 50, 71, 90};
        QuickSort.sort(integers);
        assertArrayEquals(sorted, integers);
    }

    @Test
    void sort_random() {
        int[] integers = {1, 6, 5, 4, 4, 8, 9, -100, 3, -34, 0};
        int[] sorted = {-100, -34, 0, 1, 3, 4, 4, 5, 6, 8, 9};
        QuickSort.sort(integers);
        assertArrayEquals(sorted, integers);
    }

}