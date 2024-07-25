package com.theforest.tasks.task26;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class RemoveDuplicatesFromSortedArrayProblem {
    public int removeDuplicates(int[] nums) {
        Set<Integer> uniqNums = new TreeSet<>();
        for (int num : nums) {
            if (!uniqNums.contains(num)) {
                uniqNums.add(num);
            }
        }
        int index = 0;
        Iterator<Integer> iterator = uniqNums.iterator();
        while (iterator.hasNext()) {
            nums[index] = iterator.next();
            index++;
        }

        return uniqNums.size();
    }
}
