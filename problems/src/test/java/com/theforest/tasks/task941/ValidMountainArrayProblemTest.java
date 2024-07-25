package com.theforest.tasks.task941;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidMountainArrayProblemTest {

    private ValidMountainArrayProblem solution = new ValidMountainArrayProblem();

    @Test
    void case1() {
        int[] input = {2, 1};
        assertThat(solution.validMountainArray(input))
                .isEqualTo(false);
    }

    @Test
    void case2() {
        int[] input = {3, 5, 5};
        assertThat(solution.validMountainArray(input))
                .isEqualTo(false);
    }

    @Test
    void case3() {
        int[] input = {0, 3, 2, 1};
        assertThat(solution.validMountainArray(input))
                .isEqualTo(true);
    }
}