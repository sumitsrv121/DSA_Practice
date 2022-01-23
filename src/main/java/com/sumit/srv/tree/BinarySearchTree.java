package com.sumit.srv.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BinarySearchTree {
    private static Node ROOT = null;

    public static void addNodeToBST(Node node) {
        if (ROOT == null) {
            ROOT = node;
        } else {
            Node ptr = ROOT;
            while (ptr != null) {
                if (ptr.data > node.data) {
                    if (ptr.left == null) {
                        ptr.left = node;
                        break;
                    }
                    ptr = ptr.left;
                } else {
                    if (ptr.right == null) {
                        ptr.right = node;
                        break;
                    }
                    ptr = ptr.right;
                }
            }
        }
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + "--->");
        inOrder(root.right);
    }

    public static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + "--->");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void printLeftView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean isFirstElement = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null) {
                if (isFirstElement) {
                    System.out.print(node.data + "--->");
                    isFirstElement = false;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                queue.add(null);
                isFirstElement = true;
            }

            if (queue.size() == 1 && queue.peek() == null) {
                break;
            }
        }
    }

    public static void pintRightView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null) {
                if (!queue.isEmpty() && queue.peek() == null) {
                    System.out.print(node.data + "--->");
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                queue.add(null);
            }
            if (queue.size() == 1 && queue.peek() == null) {
                break;
            }
        }
    }

    public static int getHeightOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + Math.max(getHeightOfTree(root.left), getHeightOfTree(root.right));
    }

    public static void printTopView(Node root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));
        HashSet<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (!set.contains(pair.key)) {
                System.out.print(pair.node.data + "--->");
                set.add(pair.key);
            }
            if (pair.node.left != null) {
                queue.add(new Pair(pair.key - 1, pair.node.left));
            }
            if (pair.node.right != null) {
                queue.add(new Pair(pair.key + 1, pair.node.right));
            }
        }
    }

    public static void printBottomView(Node root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            map.put(pair.key, pair.node.data);
            if (pair.node.left != null) {
                queue.add(new Pair(pair.key - 1, pair.node.left));
            }
            if (pair.node.right != null) {
                queue.add(new Pair(pair.key + 1, pair.node.right));
            }
        }
        System.out.println();
        System.out.println(map);
    }

    public static void main(String[] args) {
        addNodeToBST(new Node(7));
        addNodeToBST(new Node(5));
        addNodeToBST(new Node(8));
        addNodeToBST(new Node(4));
        addNodeToBST(new Node(6));
        //addNodeToBST(new Node(9));
        //addNodeToBST(new Node(10));

        inOrder(ROOT);
        System.out.println();
        levelOrderTraversal(ROOT);
        System.out.println();
        printLeftView(ROOT);
        System.out.println();
        pintRightView(ROOT);
        System.out.println();
        printTopView(ROOT);
        System.out.println();
        printBottomView(ROOT);
        System.out.println();
        System.out.println(getHeightOfTree(ROOT));
    }

    static class Pair {
        private int key;
        private Node node;

        public Pair(int key, Node node) {
            this.key = key;
            this.node = node;
        }
    }
}
