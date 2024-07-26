package com.theforest.tasks.task1385;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindTheDistanceValueBetweenTwoArraysProblemTest {

    FindTheDistanceValueBetweenTwoArraysProblem solution = new FindTheDistanceValueBetweenTwoArraysProblem();

    @Test
    void case1() {
        int[] input1 = {4, 5, 8};
        int[] input2 = {10, 9, 1, 8};
        int distance = 2;
        assertThat(solution.findTheDistanceValue(input1, input2, distance))
                .isEqualTo(2);
    }

    @Test
    void case2() {
        int[] input1 = {1, 4, 2, 3};
        int[] input2 = {-4, -3, 6, 10, 20, 30};
        int distance = 3;
        assertThat(solution.findTheDistanceValue(input1, input2, distance))
                .isEqualTo(2);
    }

    @Test
    void case3() {
        int[] input1 = {2, 1, 100, 3};
        int[] input2 = {-5, -2, 10, -3, 7};
        int distance = 6;
        assertThat(solution.findTheDistanceValue(input1, input2, distance))
                .isEqualTo(1);
    }
}