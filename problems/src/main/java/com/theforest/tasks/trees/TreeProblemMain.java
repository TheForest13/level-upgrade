package com.theforest.tasks.trees;

import com.theforest.tasks.trees.model.TreeNode;

public class TreeProblemMain {
    public static void main(String[] args) {
        TreeNode nodes = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3));

        TreeNode nodeOther = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3));
    }
}