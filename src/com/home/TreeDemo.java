package com.home;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class TreeDemo {

    /*
    *                     10
    *              8              12
    *           5    9         11     15
    * */
    public static void main(String[] args) {
        TreeNode root = initTree();
        recursiveDepthPrintTree(root);
        System.out.println("----------------------");
        iterativeDepthPrintTree(root);
        System.out.println("----------------------");
        iterativeWidthPrintTree(root);
    }

    private static class TreeNode {
        Integer value;
        TreeNode left;
        TreeNode right;

        public TreeNode(Integer value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private static TreeNode initTree() {
        TreeNode leaf1 = new TreeNode(5, null, null);
        TreeNode leaf2 = new TreeNode(9, null, null);
        TreeNode leaf3 = new TreeNode(11, null, null);
        TreeNode leaf4 = new TreeNode(15, null, null);

        TreeNode node1 = new TreeNode(8, leaf1, leaf2);
        TreeNode node2 = new TreeNode(12, leaf3, leaf4);

        return new TreeNode(10, node1, node2);
    }

    private static void recursiveDepthPrintTree(TreeNode root) {
        if(root.left != null) {
            recursiveDepthPrintTree(root.left);
        }

        if(root.right != null) {
            recursiveDepthPrintTree(root.right);
        }

        System.out.println(root.value);
    }

    private static void iterativeDepthPrintTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.value);
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
    }

    private static void iterativeWidthPrintTree(TreeNode root) {
        Queue<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            System.out.println(node.value);
            if(node.left != null) {
                stack.add(node.left);
            }
            if(node.right != null) {
                stack.add(node.right);
            }
        }
    }
}
