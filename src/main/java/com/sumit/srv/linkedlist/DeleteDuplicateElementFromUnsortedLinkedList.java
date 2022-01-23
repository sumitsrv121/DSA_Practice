package com.sumit.srv.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicateElementFromUnsortedLinkedList {
    private static Node HEAD = null;

    public static void main(String[] args) {
        addNodeToLinkedList(new Node(10));
        addNodeToLinkedList(new Node(12));
        addNodeToLinkedList(new Node(11));
        addNodeToLinkedList(new Node(11));
        addNodeToLinkedList(new Node(12));
        addNodeToLinkedList(new Node(11));
        addNodeToLinkedList(new Node(10));

        displayLinkedList();
        System.out.println();
        deleteDuplicate();
        displayLinkedList();
        System.out.println();
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

    public static void deleteDuplicate() {
        Set<Integer> set = new HashSet<>();
        Node curr = HEAD;
        Node prev = null;

        while (curr != null) {
            if (!set.contains(curr.data)) {
                set.add(curr.data);
                prev = curr;
            } else {
                //delete it
                prev.next = curr.next;
            }
            curr = curr.next;
        }
    }
}
