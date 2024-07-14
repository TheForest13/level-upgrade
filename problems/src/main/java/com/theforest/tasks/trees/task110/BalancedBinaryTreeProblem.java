package com.theforest.tasks.trees.task110;

import lombok.ToString;

/**
 * https://leetcode.com/problems/balanced-binary-tree/description/
 */
public class BalancedBinaryTreeProblem {
    public static void main(String[] args) {
        TreeNode case1 = new TreeNode(3,
                new TreeNode(20, new TreeNode(15), new TreeNode(7)),
                new TreeNode(9));

        TreeNode case2 = new TreeNode(3,
                new TreeNode(20, new TreeNode(15), new TreeNode(7, new TreeNode(3), null)),
                new TreeNode(9));

        TreeNode case3 = new TreeNode(3,
                new TreeNode(20,
                        new TreeNode(7),
                        null
                ),
                null);

        TreeNode case4 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3, new TreeNode(4),
                                null),
                        null
                ),
                new TreeNode(2,
                        null,
                        new TreeNode(3,
                                null,
                                new TreeNode(4))
                ));

        Solution solution = new Solution();
        System.out.println("actual: " + solution.isBalanced(case1) + " expect: true\n"); //true
//        System.out.println("actual: " + solution.isBalanced(case2) + " expect: false\n"); //false
//        System.out.println("actual: " + solution.isBalanced(case3) + " expect: false\n"); //false
//        System.out.println("actual: " + solution.isBalanced(case4) + " expect: false\n"); //false
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return dfs(root) != -1;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        if (leftHeight == -1 || rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
    @ToString
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }