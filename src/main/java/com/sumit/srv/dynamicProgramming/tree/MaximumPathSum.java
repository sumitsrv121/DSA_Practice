package com.sumit.srv.dynamicProgramming.tree;

public class MaximumPathSum {
    static int res;

    public static void main(String[] args) {
        // Make a tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(-3);
        root.left.left = new Node(-4);
        root.left.right = new Node(5);
        res = 0;
        // tree done
        solve(root);
        System.out.println(res);
    }

    private static int solve(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = solve(root.left);
        int rightSum = solve(root.right);

        int temp = Math.max(Math.max(leftSum, rightSum) + root.data, root.data);

        int ans = Math.max(temp, leftSum + rightSum + root.data);
        res = Math.max(ans, res);
        return temp;
    }
}
