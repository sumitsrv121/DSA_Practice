package com.sumit.srv.tree;

public class IdenticalTree {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.right.left = new Node(6);
        root2.right.right = new Node(7);

        boolean val = isTreeIdentical(root1, root2);
        System.out.println(val);
    }

    private static boolean isTreeIdentical(Node root1, Node root2) {
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }

        if (root1 == null) {
            return true;
        }

        if (root1.data == root2.data) {
            return isTreeIdentical(root1.left, root2.left) && isTreeIdentical(root1.right, root2.right);
        } else {
            return false;
        }
    }
}
