package com.theforest.tasks.task26;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RemoveDuplicatesFromSortedArrayProblemTest {
    private RemoveDuplicatesFromSortedArrayProblem solution = new RemoveDuplicatesFromSortedArrayProblem();

    @Test
    void case1() {
        int[] input = {1, 1, 2};
        assertThat(solution.removeDuplicates(input))
                .isEqualTo(2);
    }

    @Test
    void case2() {
        int[] input = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        assertThat(solution.removeDuplicates(input))
                .isEqualTo(5);
    }
}