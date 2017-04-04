package com.elar.algorithms.strings;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import static com.elar.algorithms.strings.Permutation.permuteString;
import static org.junit.jupiter.api.Assertions.*;


class PermutationTest {

    @Test
    void test_empty_string() {
        Set<String> expected = new TreeSet<>();
        expected.add("");
        assertEquals(expected, permuteString(""));
    }

    @Test
    void test_one_letter() {
        Set<String> expected = new TreeSet<>();
        expected.add("a");
        assertEquals(expected, permuteString("a"));
    }

    @Test
    void test_two_letters() {
        Set<String> expected = new TreeSet<>();
        Collections.addAll(expected, "ab", "ba");
        assertEquals(expected, permuteString("ab"));
    }

    @Test
    void test_three_letters() {
        Set<String> expected = new TreeSet<>();
        Collections.addAll(expected, "abc", "acb", "bac", "bca", "cab", "cba");
        assertEquals(expected, permuteString("abc"));
    }

    @Test
    void test_four_letters() {
        Set<String> expected = new TreeSet<>();
        Collections.addAll(expected,
                "abcd", "abdc", "acbd", "acdb", "adbc", "adcb",
                "bacd", "badc", "bcad", "bcda", "bdac", "bdca",
                "cabd", "cadb", "cbad", "cbda", "cdab", "cdba",
                "dabc", "dacb", "dbac", "dbca", "dcab", "dcba");

        assertEquals(expected, permuteString("abcd"));
    }

    @Test
    void test_one_repeating() {
        Set<String> expected = new TreeSet<>();
        expected.add("aaaa");
        assertEquals(expected, permuteString("aaaa"));
    }

    @Test
    void test_multiple_repeating() {
        Set<String> expected = new TreeSet<>();
        Collections.addAll(expected, "aabb", "abab", "abba", "baab", "baba", "bbaa");
        assertEquals(expected, permuteString("aabb"));
    }

}