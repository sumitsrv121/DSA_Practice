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

    public static Node findMiddleElement() {
        Node slow = HEAD;
        Node fast = HEAD;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public static void removeMiddleElementFromLinkedList() {
        Node slow = HEAD;
        Node fast = HEAD;
        Node prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if (prev != null) {
            prev.next = prev.next.next;
            slow.next = null;
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
        Node middleElement = findMiddleElement();
        System.out.println(middleElement.data);
        removeMiddleElementFromLinkedList();
        printLinkedList();
    }
}
