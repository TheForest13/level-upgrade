package com.theforest.trees;

import com.theforest.trees.model.TreeNode;

public class MergeBinaryTreeProblem {
    public TreeNode mergeBinaryTree(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            return new TreeNode(root1.getVal() + root2.getVal(),
                    mergeBinaryTree(root1.getLeft(), root2.getRight()),
                    mergeBinaryTree(root1.getLeft(), root2.getRight()));
        } else {
            return root1 != null ? root1 : root2;
        }
    }
}
