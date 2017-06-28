package com.elar.algorithms.strings;

import java.util.*;

public class Permutation {

  static Set<String> permuteString(String s) {

    char[] string = s.toCharArray();

    // A map to keep count of the number of characters present in the char array
    Map<Character, Integer> map = new TreeMap<>();

    // For every character in the string, if the value of the key is null, change it to one.
    // If the value isn't null, add one to it.
    for (char c : string) {
      //map.compute(c, (key, value) -> value == null ? 1 : value + 1);
      if (map.containsKey(c)) {
        int value = map.get(c);
        map.put(c, value + 1);
      } else {
        map.put(c, 1);
      }
    }

    // The size of the map is the number of distinct characters in input string.
    // We are creating a char array and an int array to keep track of the counts of each character that
    // is being used to create permutations.
    char chars[] = new char[map.size()];
    int count[] = new int[map.size()];

    // Iterate through the map and add the key and value of each entry to the two arrays we use to
    // keep track of the counts of each character
    int i = 0;
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      chars[i] = entry.getKey();
      count[i] = entry.getValue();
      i++;
    }
    // Character array we will use for a permutation, has the same size as the input string
    char permutation[] = new char[string.length];

    Set<String> result = new TreeSet<>();

    findPermutations(chars, count, permutation, 0, result);

    return result;
  }

  private static void findPermutations(char chars[], int[] count, char[] permutation, int level, Set<String> result) {
        /*
        Accept: The solution satisfies the property
         */
    // If we are at the level where we should have fully filled the character array that should
    // contain a permutation, add the permutation to the set of results and return.
    if (level == permutation.length) {
      result.add(new String(permutation));
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
      findPermutations(chars, count, permutation, level + 1, result);
      count[i]++;
    }
  }
}
