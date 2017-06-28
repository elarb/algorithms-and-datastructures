package com.elar.algorithms.data_structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    private Trie trie;
    private static List<String> testData = Arrays.asList(
            "Hackerrank",
            "test",
            "Hackerrrank",
            "Hackerrankk",
            "a");

    @BeforeEach
    void setUp() {
        trie = new Trie();
        for (String str : testData) {
            trie.insert(str);
        }
    }

    //Todo: Need newer version of Junit5
//    @ParameterizedTest
//    @MethodSource(names = "testDataProvider")
//    void test_contains(String word) {
//        assertTrue(trie.search(word));
//    }

    @Test
    void test_does_not_contain() {
        assertFalse(trie.search("b"));
    }

    @Test
    void test_correct_size() {
        assertEquals(5, trie.size());
    }

    @Test
    void test_prefix_single() {
        assertEquals(0, trie.countWithPrefix("none"));
    }

    @Test
    void test_prefix_multiple() {
        assertEquals(3, trie.countWithPrefix("Hack"));
    }

    @Test
    void test_prefix_count_none() {
        assertEquals(1, trie.countWithPrefix("a"));
    }

    static Stream<String> testDataProvider() {
        return testData.stream();
    }
}