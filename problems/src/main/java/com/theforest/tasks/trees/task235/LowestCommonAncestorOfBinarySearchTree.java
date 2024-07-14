package com.theforest.tasks.trees.task235;

import lombok.ToString;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 * <p>
 * Учитывая двоичное дерево поиска (BST), найдите узел наименьшего общего предка (LCA) из двух заданных узлов в BST.
 * <p>
 * Согласно определению LCA в Википедии:
 * "Наименьший общий предок определяется между двумя узлами p и q как самый нижний узел в T,
 * который имеет как p, так и q в качестве потомков (где мы позволяем узлу быть потомком самого себя)."
 */
public class LowestCommonAncestorOfBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6,
                new TreeNode(2,
                        new TreeNode(0),
                        new TreeNode(4,
                                new TreeNode(3),
                                new TreeNode(5))),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(9)));

        Solution solution = new Solution();
        System.out.println(solution.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8)));
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;

        if (p.val > current.val && q.val > current.val) {
            current = current.right;
        } else if (p.val < current.val && q.val < current.val) {
            current = current.left;
        } else {
             return current;
        }

        TreeNode treeNode = lowestCommonAncestor(current, p, q);

        return treeNode;
    }
}

@ToString
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
