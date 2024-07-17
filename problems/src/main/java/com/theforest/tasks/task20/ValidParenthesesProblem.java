package com.theforest.tasks.task20;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParenthesesProblem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isValid("()"));     //true
        System.out.println(solution.isValid("()[]{}")); //true
        System.out.println(solution.isValid("(]"));     //false
        System.out.println(solution.isValid("([)]"));   //false
        System.out.println(solution.isValid("{[]}"));   //true
    }
}

class Solution {

    public boolean isValid(String input) {
        while (input.contains("()") || input.contains("[]") || input.contains("{}")) {
            input = input.replace("()", "");
            input = input.replace("[]", "");
            input = input.replace("{}", "");
        }
        return input.isEmpty();
    }
}