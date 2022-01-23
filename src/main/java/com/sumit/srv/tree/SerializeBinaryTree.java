package com.sumit.srv.tree;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SerializeBinaryTree {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Node root = new Node(7);
        root.left = new Node(2);
        root.right = new Node(8);
        root.left.left = new Node(1);
        root.left.right = new Node(5);

        serializeBinaryTree(root);
    }

    private static void serializeBinaryTree(Node root) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("abc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        List<Integer> preOrderTraversal = new LinkedList<>();
        storePreOrderInFile(root, preOrderTraversal);
        oos.writeObject(preOrderTraversal);
        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Integer> al = (List<Integer>) ois.readObject();
        System.out.println(al);
        fis.close();
        ois.close();
        AtomicInteger index = new AtomicInteger(0);
        Node root1 = deserializeBinaryTree(al, index);
        preOrder(root1);
    }

    private static Node deserializeBinaryTree(List<Integer> al, AtomicInteger index) {
        if (al.size() < index.get() || al.get(index.get()) == -1) {
            return null;
        }
        Node root = new Node(al.get(index.getAndIncrement()));
        root.left = deserializeBinaryTree(al, index);
        index.getAndIncrement();
        root.right = deserializeBinaryTree(al, index);
        return root;
    }

    private static void storePreOrderInFile(Node root, List<Integer> preOrderTraversalList) {
        if (root == null) {
            preOrderTraversalList.add(-1);
            return;
        }
        preOrderTraversalList.add(root.data);
        storePreOrderInFile(root.left, preOrderTraversalList);
        storePreOrderInFile(root.right, preOrderTraversalList);
    }

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + "--->");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
