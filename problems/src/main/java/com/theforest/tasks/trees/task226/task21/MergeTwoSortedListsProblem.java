package com.theforest.tasks.trees.task226.task21;

import lombok.ToString;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/solutions/3177193/simple-java-runtime-1-ms-beats-100/
 */
public class MergeTwoSortedListsProblem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode listNodeOne = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNodeTwo = new ListNode(1, new ListNode(3, new ListNode(4)));

        System.out.println(solution.mergeTwoLists(listNodeOne, listNodeTwo)); // [1,1,2,3,4,4]
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
        if (list1 == null)
            return list2;
        return list1;
    }
}

@ToString
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}