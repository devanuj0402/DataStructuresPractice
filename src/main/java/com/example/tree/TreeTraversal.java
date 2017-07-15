package com.example.tree;

/**
 * Created by Anuj on 16-07-2017.
 */
class Node {
    int key;
    Node left, right;

    Node(int d) {
        key = d;
        left = right = null;
    }
}

public class TreeTraversal {
    // declare root
    Node root;

    TreeTraversal() {
        root = null;
    }

    void inorder(Node current) {
        if (current == null)
            return;
      /*visit the left subtree*/
        inorder(current.left);
        System.out.print(current.key + "  ");
      /*visit the right subtree*/
        inorder(current.right);

    }

    void postOrder(Node current){
        if(current == null){
            return;
        }
        //visit left subtree:
        postOrder(current.left);

        //visit right subtree:
        postOrder(current.right);

        //print the key:
        System.out.print(current.key+"  ");
    }

    void preorder(Node current){
        if(current == null){
            return;
        }
        //traverse root
        System.out.print(current.key+"  ");
        //traverse left subtree:
        preorder(current.left);
        preorder(current.right);
    }

    void inorder() {
        inorder(root);
    }
    void postOrder(){postOrder(root);}
    void preorder(){preorder(root);}

    public static void main(String[] args) {
        TreeTraversal tree = new TreeTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        System.out.println("Inorder traversal: ");
        tree.inorder();
        System.out.println();
        System.out.println("Preorder traversal:");
        tree.postOrder();
        System.out.println();
        System.out.println("Print pre-order");
        tree.preorder();
    }
}
