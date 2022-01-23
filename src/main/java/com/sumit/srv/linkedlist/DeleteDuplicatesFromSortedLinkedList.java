package com.sumit.srv.linkedlist;

public class DeleteDuplicatesFromSortedLinkedList {
    private static Node HEAD = null;

    public static void main(String[] args) {
        addNodeToLinkedList(new Node(1));
        addNodeToLinkedList(new Node(1));
        addNodeToLinkedList(new Node(1));
        addNodeToLinkedList(new Node(1));
        addNodeToLinkedList(new Node(1));
        addNodeToLinkedList(new Node(1));
        addNodeToLinkedList(new Node(2));
        addNodeToLinkedList(new Node(2));
        addNodeToLinkedList(new Node(2));
        addNodeToLinkedList(new Node(2));
        addNodeToLinkedList(new Node(2));
        addNodeToLinkedList(new Node(2));
        addNodeToLinkedList(new Node(3));
        addNodeToLinkedList(new Node(3));
        addNodeToLinkedList(new Node(3));
        addNodeToLinkedList(new Node(3));
        addNodeToLinkedList(new Node(3));
        addNodeToLinkedList(new Node(3));
        addNodeToLinkedList(new Node(3));
        addNodeToLinkedList(new Node(3));
        addNodeToLinkedList(new Node(3));
        addNodeToLinkedList(new Node(3));
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
        Node curr = HEAD != null ? HEAD.next : null;
        Node prev = HEAD;
        while (curr != null) {
            if (curr.data == prev.data) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
    }
}
