package com.theforest.practice;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskExample3 {

    /*
        является ли слово аннаграммой другого

        КОТ -> ТОК - true
        КОТ -> КОТЭ - false
        КУКУ -> КУ - false
     */

    public static void main(String[] args) {
        print(true, isAnagramVer2("КОТ", "ТОК"));
        print(false, isAnagramVer2("КОТ", "КОТЭ"));
        print(false, isAnagramVer2("КУКУ", "КУ"));
    }

    private static void print(boolean expectResult, boolean actual) {
        System.out.println(MessageFormat.format("expect {0}, result {1}", expectResult, actual));
    }

    private static boolean isAnagram(String str1, String str2) {
        char[] strMas1 = str1.toLowerCase().toCharArray();
        char[] strMas2 = str2.toLowerCase().toCharArray();
        Arrays.sort(strMas1);
        Arrays.sort(strMas2);
        return new String(strMas1).equals(new String(strMas2));
    }

    private static boolean isAnagramVer2(String str1, String str2) {
        List<Character> chars1 = str1.chars().mapToObj(c -> (char) c)
                .toList();

        List<Character> chars2 = str2.chars().mapToObj(c -> (char) c)
                .toList();

        Set<Character> strSet1 = Set.copyOf(chars1);
        Set<Character> strSet2 = Set.copyOf(chars2);

        return strSet1.size() == strSet2.size() && strSet1.containsAll(strSet2);
    }
}
