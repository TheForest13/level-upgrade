package com.theforest.tasks.trees.model;

import lombok.Getter;

import java.text.MessageFormat;

@Getter
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return MessageFormat.format("TreeNode(val: {0}, left: {1}, right: {2})", val, left, right);
    }
}
