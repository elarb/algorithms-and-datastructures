package com.elar.algorithms.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaxNumNDigitsTest {

    @ParameterizedTest(name = "Original number: {0}. Max only using {1} digit(s): {2}")
    @CsvSource({
            "21, 1, 2",
            "12, 1, 2",
            "21, 2, 21",
            "12, 3, 21"})
    public void test_max_num_digits(String number, int max, int expected) {
        assertThat(MaxNumNDigits.maxDigit(number, max)).isEqualTo(expected);
    }
}