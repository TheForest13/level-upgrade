package com.theforest.other;


import java.util.Arrays;

// Дан массив целых чисел х длиной N. Массив упорядочен
// по возрастанию. Написать функцию, которая из этого
// массива
// получит массив квадратов чисел, упорядоченный по
// возрастанию.
// [-3, 2, 4] -> [4, 9, 16]
public class SquareAndSortArray {

    public static void main(String[] args) {
        SquareAndSortArray solution = new SquareAndSortArray();

        int[] input = {-3, 2, 4, 8}; // output [4, 9, 16, 64]
        int[] input2 = {-3, 2, 4, 8, 11}; // output [4, 9, 16, 64, 121]
        int[] input3 = {-7, -3, 2, 4, 8, 11}; // output [4, 9, 16, 16, 64, 121]
        result(solution.squareAndSort(input));
        result(solution.squareAndSort(input));
        result(solution.squareAndSortVer3(input2));
        result(solution.squareAndSortVer3(input3));
    }

    private int[] squareAndSort(int[] input) {
        int length = input.length;
        if (input == null || length == 0) {
            return input;
        }

        return Arrays.stream(input)
                .map(it -> Math.abs(it) * Math.abs(it))
                .sorted()
                .toArray();
    }

    private int[] squareAndSortVer3(int[] input) {
        if (input == null || input.length == 0) {
            return input;
        }

        int[] output = new int[input.length];

        int left = 0;
        int right = input.length - 1;
        int count = input.length - 1;

        while (left <= right) {
            if (Math.abs(input[left]) < Math.abs(input[right])) {
                output[count] = input[right] * input[right];
                right--;
            } else {
                output[count] = input[left] * input[left];
                left++;
            }
            count--;
        }

        return output;
    }

    private int square(int input) {
        return input * input;
    }

    private static void result(int[] input) {
        System.out.println("==================================================");
        Arrays.stream(input).forEach(System.out::println);
        System.out.println("==================================================");
    }
}
