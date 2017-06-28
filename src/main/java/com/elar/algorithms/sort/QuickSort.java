package com.elar.algorithms.sort;


public class QuickSort {

    static void sort(int[] elements) {
        helper(elements, 0, elements.length - 1);
    }

    private static void helper(int[] elements, int small, int large) {
        if (elements == null || elements.length == 0 || small >= large) {
            return;
        }

        int i = small;
        int j = large;
        int pivot = elements[small + (large - small) / 2]; // select element in the middle as pivot

        while (i <= j) {
            while (elements[i] < pivot) {
                i++;
            }
            while (elements[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = elements[i];
                elements[i] = elements[j];
                elements[j] = temp;
                i++;
                j--;
            }
        }

        if (small < j) {
            helper(elements, small, j);
        }
        if (i < large) {
            helper(elements, i, large);
        }

    }

}
