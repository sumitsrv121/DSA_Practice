package com.sumit.srv.linkedlist;

public class DetectLoopInLinkedList {
    private static Node HEAD = null;

    public static void main(String[] args) {
        addNodeToLinkedList(new Node(1));
        Node node = new Node(2);
        addNodeToLinkedList(node);
        addNodeToLinkedList(new Node(3));
        addNodeToLinkedList(new Node(4));
        addNodeToLinkedList(new Node(5));
        Node node1 = new Node(6);
        addNodeToLinkedList(node1);
        node1.next = node;
        boolean loopPresentInLinkedList = isLoopPresentInLinkedList();
        System.out.println(loopPresentInLinkedList);
        if (loopPresentInLinkedList) {
            removeLoopFromLinkedList();
        }

    }

    private static void removeLoopFromLinkedList() {
        Node slow = HEAD;
        Node fast = HEAD;
        while (fast != null && fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast != null && slow == fast) {
            fast.next = null;
        }
        displayLinkedList();
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

    public static boolean isLoopPresentInLinkedList() {
        Node slow = HEAD;
        Node fast = HEAD;
        while (fast != null && slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        return slow == fast;
    }

    public static void displayLinkedList() {
        Node ptr = HEAD;
        while (ptr != null) {
            System.out.print(ptr.data + "--->");
            ptr = ptr.next;
        }
    }
}
