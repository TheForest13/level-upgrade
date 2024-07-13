package com.theforest.tasks.trees;

import com.theforest.tasks.trees.model.TreeNode;

/**
 * Поиск диаметра дерева
 */
public class DiameterOfBinaryTreeProblem {
    private int maxDiameter = 0;


    /**
     * Поиск диаметра
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }

    public int dfs(TreeNode node) {
        if(node == null) return 0;

        int leftDepth = dfs(node.getLeft());
        int rightDepth = dfs(node.getRight());
        maxDiameter += Math.max(maxDiameter, leftDepth + rightDepth);

        return Math.max(leftDepth , rightDepth);
    }
}
