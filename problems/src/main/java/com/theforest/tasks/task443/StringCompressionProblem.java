package com.theforest.tasks.task443;

import java.util.*;

/**
 * 443. String Compression
 */
public class StringCompressionProblem {
    public static void main(String[] args) {

       String[] case1 =   {"a","a","b","b","c","c","c"};
        Solution solution = new Solution();
        System.out.println("Result: " + solution.compress(case1)); // 6 -> ["a","2","b","2","c","3"]
    }
}
class Solution {


//    public int compress(char[] chars) {
//        int left =0;
//        int right = 0;
//        int k=0;
//        int n= chars.length;
//        while(right<n){
//            while(right<n && chars[right]==chars[left] ) {
//                right++;
//            }
//            chars[k++]=chars[left];
//            int num=  right-left;
//            if (num > 1) {
//                String countStr = Integer.toString(num);
//                for (char c : countStr.toCharArray()) {
//                    chars[k++] = c;
//                }
//            }
//            left=right;
//
//        }
//        return k;
//    }

    public int compress(String[] chars) {
        Map<String, Integer> charToCount = new LinkedHashMap<>();
        for (String element : chars) {
            if (charToCount.containsKey(element)) {
                Integer count = charToCount.get(element) + 1;
                charToCount.put(element, count);
            } else {
                charToCount.put(element, 1);
            }
        }

        StringBuilder result = charToCount.values()
                .stream()
                .map(it -> it > 1 ? new StringBuilder("1").append(it) : new StringBuilder("1"))
                .reduce(StringBuilder::append)
                .orElseThrow();

        System.out.println(charToCount);
        System.out.println(result);

        Iterator<String> iterator = charToCount.keySet().iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            String currentChar = iterator.next();
            chars[i] = currentChar;
            String value = charToCount.get(currentChar).toString();
            chars[i+1] = value;
            i++;
            System.out.println("currentChar - " + currentChar);
            System.out.println("value - " + value);
        }

        System.out.println("CHARS:");
        Arrays.stream(chars).forEach(System.out::println);

        return result.length();
    }
}