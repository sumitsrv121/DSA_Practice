package com.sumit.srv.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class BinaryTreeFromPreOrderInOrder {
    public static void main(String[] args) {
        int[] inOrder = {4, 2, 1, 7, 5, 8, 3, 6};
        int[] preOrder = {1, 2, 4, 3, 5, 7, 8, 6};

        Map<Integer, Integer> inOrderToIndex = new HashMap<>();
        IntStream.range(0, inOrder.length).forEach(index -> inOrderToIndex.put(inOrder[index], index));
        AtomicInteger pIndex = new AtomicInteger(0);
        Node root = createBinaryTreeFromPreOrderAndInOrder(inOrderToIndex, preOrder, pIndex, 0, preOrder.length - 1);
        inOrderTraversal(root);
    }

    private static Node createBinaryTreeFromPreOrderAndInOrder(Map<Integer, Integer> inOrderToIndex, int[] preOrder, AtomicInteger pIndex, int start, int end) {
        if (start > end) {
            return null;
        }
        Node node = new Node(preOrder[pIndex.getAndIncrement()]);
        int index = inOrderToIndex.get(node.data);

        node.left = createBinaryTreeFromPreOrderAndInOrder(inOrderToIndex, preOrder, pIndex, start, index - 1);
        node.right = createBinaryTreeFromPreOrderAndInOrder(inOrderToIndex, preOrder, pIndex, index + 1, end);
        return node;
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
