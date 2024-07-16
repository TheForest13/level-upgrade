package com.theforest.tasks.trees;

import com.theforest.tasks.trees.model.TreeNode;

import java.util.*;

public class SumDfsAndBfs {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3)); // sum = 15

        System.out.println("Sum trees with stack: " + sumWithStack(root));
        System.out.println("Sum trees with queue: " + sumWithQueue(root));
    }

    // найти сумму дерева
    private static int sumWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>(); // DFS (Поиск в глубину)
        stack.push(root);

        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sum += node.getVal();

            System.out.println(node.getVal());

            if (node.getRight() != null) {
                stack.push(node.getRight());
            }

            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
        return sum;
    }

    // найти сумму дерева
    private static int sumWithQueue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>(); // BFS (Поиск в ширину)
        queue.add(root);

        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sum += node.getVal();

            System.out.println(node.getVal());

            if (node.getRight() != null) {
                queue.add(node.getRight());
            }

            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
        }
        return sum;
    }
}
