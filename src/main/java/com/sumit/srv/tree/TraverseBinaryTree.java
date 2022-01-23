package com.sumit.srv.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TraverseBinaryTree {
    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + "--->");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + "---->");
        }
    }

    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + "--->");
            inOrder(root.right);
        }
    }

    public static void printLeafNode(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.print(root.data + "--->");
        } else {
            printLeafNode(root.left);
            printLeafNode(root.right);
        }
    }

    public static void printNonLeafNode(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null || root.right != null) {
            System.out.print(root.data + "--->");
        }
        printNonLeafNode(root.left);
        printNonLeafNode(root.right);
    }

    public static int countNoOfLeafNodes(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countNoOfLeafNodes(root.left) + countNoOfLeafNodes(root.right);
    }

    public static int countNoOfNonLeafNodes(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null || root.right != null) {
            return 1 + countNoOfNonLeafNodes(root.left) + countNoOfNonLeafNodes(root.right);
        } else {
            return 0;
        }
    }

    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + "---->");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);

        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        levelOrder(root);
        System.out.println();
        printLeafNode(root);
        System.out.println();
        printNonLeafNode(root);
        System.out.println();
        System.out.print(countNoOfLeafNodes(root));
        System.out.println();
        System.out.println(countNoOfNonLeafNodes(root));
    }
}
