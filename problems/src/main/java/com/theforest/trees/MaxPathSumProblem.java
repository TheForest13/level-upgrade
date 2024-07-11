package com.theforest.trees;

import com.theforest.trees.model.TreeNode;

public class MaxPathSumProblem {
    public static int maxPathSum(TreeNode node) {
        if(node == null) return 0;

        int leftDepth = maxPathSum(node.getLeft());
        int rightDepth = maxPathSum(node.getRight());

        return Math.max(leftDepth , rightDepth) + node.getVal();
    }
}
