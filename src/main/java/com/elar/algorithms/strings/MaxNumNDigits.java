package com.elar.algorithms.strings;


import java.util.*;

public class MaxNumNDigits {


    /**
     * Returns the maximum possible integer given the string str containing digits, using
     * maximum of n digits. Each digit in str can only be used once.
     **/
    static int maxDigit(String str, int n) {

        if (!str.matches("\\d+$")) {
            throw new IllegalArgumentException("The string should represent a non negative whole number");
        }

        if (n < 1) {
            throw new IllegalArgumentException("n should be 1 or greater");
        }

        char[] string = str.toCharArray();

        if (string.length < n) {
            n = string.length;
        }

        // A map to keep count of how many times a certain character is present in the char array
        Map<Character, Integer> map = new TreeMap<>();

        // For every character in the char array, if the value of the key is null, change it to one.
        // If the value isn't null, add one to it.
        for (char c : string) {
            map.compute(c, (key, value) -> value == null ? 1 : value + 1);
        }

        // The size of the map is the number of distinct characters in input string.
        // We are creating a char array and an int array to keep track of the counts of each character that
        // is being used to create permutations.
        char[] chars = new char[map.size()];
        int[] count = new int[map.size()];

        // Iterate through the map and add the key and value of each entry to the two arrays we use to
        // keep track of the counts of each character
        int i = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            chars[i] = entry.getKey();
            count[i] = entry.getValue();
            i++;
        }
        // Character array we will use for a permutation, has size of n
        char permutation[] = new char[n];

        TreeSet<Integer> result = new TreeSet<>();

        maxDigitHelper(chars, count, permutation, n, 0, result);

        return result.last();
    }

    /**
     * Creates a set of permutations in result based on string str with max n digits.
     */
    private static void maxDigitHelper(char chars[], int[] count, char[] permutation, int n, int level, Set<Integer> result) {

        /*
        Accept: The solution satisfies the property
         */
        // If we are at the level where we should have fully filled the character array that should
        // contain a permutation, add the permutation to the set of results and return.
        if (level == n) {
            String str = new String(permutation);
            result.add(Integer.parseInt(str));
            return;
        }
        /*
        Extend solution in all possible ways, and proceed recursively
         */
        for (int i = 0; i < chars.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            permutation[level] = chars[i];
            count[i]--;
            maxDigitHelper(chars, count, permutation, n, level + 1, result);
            count[i]++;
        }
    }
}
