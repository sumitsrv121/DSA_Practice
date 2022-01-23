package com.sumit.srv.linkedlist;

public class PalindromicLinkedList {
    private static Node HEAD = null;
    private static Node left = HEAD;

    public static void main(String[] args) {
        addNodeToLinkedList(new Node(1));
        addNodeToLinkedList(new Node(2));
        addNodeToLinkedList(new Node(2));
        addNodeToLinkedList(new Node(1));
        displayLinkedList();
        System.out.println();
        left = HEAD;
        boolean isPalindrome = isPalindrome(HEAD);
        System.out.println(isPalindrome);
    }

    public static boolean isPalindrome(Node right) {
        if (right == null) {
            return true;
        }

        boolean result = isPalindrome(right.next) && left.data == right.data;
        left = left.next;
        return result;
    }

    public static void addNodeToLinkedList(Node node) {
        if (HEAD == null) {
            HEAD = node;
            return;
        }
        Node ptr = HEAD;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = node;
    }

    public static void displayLinkedList() {
        Node ptr = HEAD;
        while (ptr != null) {
            System.out.print(ptr.data + "--->");
            ptr = ptr.next;
        }
    }
}
