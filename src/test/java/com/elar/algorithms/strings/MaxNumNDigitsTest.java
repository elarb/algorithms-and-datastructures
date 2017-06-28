package com.elar.algorithms.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxNumNDigitsTest {

    //Todo: use parameterized tests here

    @Test
    public void test_max_with_one() {
        assertEquals(2, MaxNumNDigits.maxDigit("21", 1));
    }

    @Test
    public void test_max_with_one_reversed() {
        assertEquals(2, MaxNumNDigits.maxDigit("12", 1));
    }

    @Test
    public void test_max_with_two() {
        assertEquals(21, MaxNumNDigits.maxDigit("21", 2));
    }

    @Test
    public void test_max_with_three() {
        assertEquals(21, MaxNumNDigits.maxDigit("12", 3));
    }
}