package com.theforest.tasks.task3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LengthOfLongestSubstringTest {
    private LengthOfLongestSubstring solution = new LengthOfLongestSubstring();

    @ParameterizedTest
    @CsvSource({
            "abcabcbb, 3",
            "bbbbb, 1",
            "pwwkew, 3",
            "au, 2",
            "bwf, 3",
            "dvdf, 3"
    })
    @DisplayName("LengthOfLongestSubstring")
    void case1(String input, Integer actual) {
        Assertions.assertThat(solution.lengthOfLongestSubstring(input))
                .isEqualTo(actual);
    }

    @Test
    @DisplayName("Support test")
    void caseTest() {
        Assertions.assertThat(solution.lengthOfLongestSubstring("dvdf"))
                .isEqualTo(3);
    }
}