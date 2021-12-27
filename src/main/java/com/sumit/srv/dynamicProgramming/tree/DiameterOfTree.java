package com.sumit.srv.dynamicProgramming.tree;

public class DiameterOfTree {
    static int res;

    public static void main(String[] args) {
        // Make a tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        // tree done
        res = 0;
        solve(root);
        System.out.println(res);
    }

    private static int solve(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = solve(root.left);
        int rightHeight = solve(root.right);

        // consider root as the answer
        int ans = 1 + leftHeight + rightHeight;

        // consider not as temp
        int temp = 1 + Math.max(leftHeight, rightHeight);
        res = Math.max(ans, res);
        return temp;
    }

}
