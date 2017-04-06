package com.elar.algorithms.sort;

public class SelectionSort {

    static void sort(int[] unsorted) {
        for (int i = 0; i < unsorted.length ; i++) {
            int min = i;
            // iterate through the array starting from `i` and search for an integer smaller than the integer at index `i`
            for (int j = i; j < unsorted.length; j++) {
                if (unsorted[j] < unsorted[min]) {
                    min = j;
                }
            }
            // swap if we found an integer smaller than `i`
            if (unsorted[min] != i) {
                int temp = unsorted[min];
                unsorted[min] = unsorted[i];
                unsorted[i] = temp;
            }
        }
    }

}
