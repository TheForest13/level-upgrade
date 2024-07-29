package com.theforest.tasks.task57;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InsertIntervalProblemTest {

    InsertIntervalProblem solution = new InsertIntervalProblem();


    @Test
    void case1() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newIntervals = {2, 5};

        int[][] expected = {{1, 5}, {6, 9}};

        assertThat(solution.insert(intervals, newIntervals))
                .isEqualTo(expected);
    }

    @Test
    void case2() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newIntervals = {4, 8};

        int[][] expected = {{1, 2}, {3, 10}, {12, 16}};

        assertThat(solution.insert(intervals, newIntervals))
                .isEqualTo(expected);
    }
}