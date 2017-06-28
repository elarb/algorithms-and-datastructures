package com.elar.algorithms.data_structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

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

    @ParameterizedTest
    @MethodSource(names = "testDataProvider")
    void test_contains(String word) {
        assertThat(trie.search(word)).isTrue();
    }

    @Test
    void test_does_not_contain() {
        assertThat(trie.search("b")).isFalse();
    }

    @Test
    void test_correct_size() {
        assertThat(trie.size()).isEqualTo(5);
    }

    @Test
    void test_prefix_single() {
        assertThat(trie.countWithPrefix("a")).isEqualTo(1);
    }

    @Test
    void test_prefix_multiple() {
        assertThat(trie.countWithPrefix("Hack")).isEqualTo(3);
    }

    @Test
    void test_prefix_count_none() {
        assertThat(trie.countWithPrefix("none")).isEqualTo(0);
    }

    static Stream<String> testDataProvider() {
        return testData.stream();
    }
}