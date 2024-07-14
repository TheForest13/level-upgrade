package com.theforest.tasks.task733;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/flood-fill/description/
 */
public class FloodFillProblem {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] image =
                {{1, 1, 1},
                        {1, 1, 0},
                        {1, 0, 1}};

        result(image);
        result(solution.floodFill(image, 1, 1, 2)); // Output: [[2,2,2],[2,2,0],[2,0,1]]
    }

    private static void result(int[][] input) {
        System.out.println("==================================================");
        Arrays.stream(input).map(Arrays::toString).forEach(System.out::println);
        System.out.println("==================================================");
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int x, int y, int newColor) {
        if (image[x][y] == newColor) {
            return image;
        }
        fill(image, x, y, image[x][y], newColor);
        return image;
    }

    public void fill(int[][] image, int x, int y, int color, int colorNew) {
        if (x < 0 || y < 0 ||
                x >= image.length ||
                y >= image[0].length ||
                image[x][y] != color) {
            return;
        }
        image[x][y] = colorNew;
        int topRow = x - 1;
        int bottomRow = x + 1;
        int leftColumn = y - 1;
        int rightColumn = y + 1;
        fill(image, topRow, y, color, colorNew);
        fill(image, bottomRow, y, color, colorNew);
        fill(image, x, leftColumn, color, colorNew);
        fill(image, x, rightColumn, color, colorNew);
    }
}