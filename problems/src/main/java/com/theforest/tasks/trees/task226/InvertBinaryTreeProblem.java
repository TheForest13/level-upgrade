package com.theforest.tasks.trees.task226;

import lombok.ToString;

/**
 * https://leetcode.com/problems/invert-binary-tree/submissions/1320107959/
 */
public class InvertBinaryTreeProblem {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode nodes = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));

        System.out.println(nodes);
        System.out.println(solution.invertTree(nodes));
    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
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