package com.sumit.srv.linkedlist;

public class SinglyLinkedList {
    private static Node HEAD = null;
    private static Node END = null;

    public static void addNodeToLinkedList(Node newNode) {
        if (HEAD == null) {
            HEAD = newNode;
            END = newNode;
            return;
        }
        END.next = newNode;
        END = newNode;
    }

    public static void printLinkedList() {
        Node ptr = HEAD;
        while (ptr != null) {
            System.out.print(ptr.data + "--->");
            ptr = ptr.next;
        }
    }

    public static void main(String[] args) {
        addNodeToLinkedList(new Node(1));
        addNodeToLinkedList(new Node(2));
        addNodeToLinkedList(new Node(3));
        addNodeToLinkedList(new Node(4));
        addNodeToLinkedList(new Node(5));
        addNodeToLinkedList(new Node(6));

        printLinkedList();
        System.out.println();
    }
}
