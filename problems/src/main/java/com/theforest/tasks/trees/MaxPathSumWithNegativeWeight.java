package com.theforest.tasks.trees;

import com.theforest.tasks.trees.model.TreeNode;

public class MaxPathSumWithNegativeWeight {
    private int answer = 0;

    /**
     * поиск наибольшей суммы с отрицательными весами
     * @param node
     * @return
     */
    public int maxPathSumVer2(TreeNode node) {
        if (node.getLeft() == null && node.getRight() == null) {
            answer = node.getVal();
        } else {
            answer = 0;
        }
        helper(node);
        return answer;
    }

    private int helper(TreeNode node) {
        if(node == null) return 0;

        int maxLeftDepth = Math.max(helper(node.getLeft()), 0);
        int maxRightDepth = Math.max(helper(node.getRight()), 0);
        answer = Math.max(answer, maxLeftDepth + maxRightDepth + node.getVal());

        return Math.max(maxLeftDepth, maxRightDepth) + node.getVal();
    }

    public static void main(String[] args) {

        TreeNode nodes = new TreeNode(-3);

        MaxPathSumWithNegativeWeight solution = new MaxPathSumWithNegativeWeight();
        System.out.println("result: " + solution.maxPathSumVer2(nodes));
    }
}
