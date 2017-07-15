package com.tree.examples;

/**
 * Created by Anuj on 15-07-2017.
 * Common functions of Binary search tree
 */
/* Class containing left and right child of current
   node and key value*/
class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int d) {
        key = d;
        left = right = null;
    }
}

public class BinaryTree {
    TreeNode root; // Root of the node;

    BinaryTree(int key) {
        root = new TreeNode(key);
    }

    BinaryTree() {
        root = null;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.right = new TreeNode(4);
        tree.root.left.left = new TreeNode(5);

    }
}
