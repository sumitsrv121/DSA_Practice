package com.sumit.srv.tree;

public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int start = 0;
        int end = arr.length - 1;
        Node ROOT = addNodeToBST(arr, start, end);
        inOrderTraversal(ROOT);
    }

    public static Node addNodeToBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = addNodeToBST(arr, start, mid - 1);
        root.right = addNodeToBST(arr, mid + 1, end);
        return root;
    }

    public static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + "--->");
        inOrderTraversal(root.right);
    }
}
