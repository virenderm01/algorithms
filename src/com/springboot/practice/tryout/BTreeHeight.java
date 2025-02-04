package com.springboot.practice.tryout;

import java.util.Scanner;

public class BTreeHeight {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static int height(Node root) {
        // Write your code here.
        int lHeight =0;
        int rHeight = 0;
        if(root!=null){
            if(root.left!=null){
                lHeight = 1+height(root.left);
            }

            if(root.right!=null){
                rHeight = 1+height(root.right);
            }
        }
        return lHeight>rHeight?lHeight:rHeight;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}
