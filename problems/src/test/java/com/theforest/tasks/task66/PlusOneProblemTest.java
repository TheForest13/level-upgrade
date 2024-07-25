package com.theforest.tasks.task66;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class PlusOneProblemTest {
    PlusOneProblem solution = new PlusOneProblem();

    @Test
    void case1() {
        int[] input = {1, 2, 3};
        int[] expect = {1, 2, 4};
        assertThat(solution.plusOne(input))
                .isEqualTo(expect);
    }

    @Test
    void case2() {
        int[] input = {4, 3, 2, 1};
        int[] expect = {4, 3, 2, 2};
        assertThat(solution.plusOne(input))
                .isEqualTo(expect);
    }

    @Test
    void case3() {
        int[] input = {9};
        int[] expect = {1, 0};
        assertThat(solution.plusOne(input))
                .isEqualTo(expect);
    }

    @Test
    void case4() {
        int[] input = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] expect = {9, 8, 7, 6, 5, 4, 3, 2, 1, 1};
        assertThat(solution.plusOne(input))
                .isEqualTo(expect);
    }

    @Test
    void case5() {
        int[] input = {7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6};
        int[] expect = {7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 7};
        assertThat(solution.plusOne(input))
                .isEqualTo(expect);
    }

    @Test
    void case6() {
        int[] input = {9, 9};
        int[] expect = {1, 0, 0};
        assertThat(solution.plusOne(input))
                .isEqualTo(expect);
    }
}