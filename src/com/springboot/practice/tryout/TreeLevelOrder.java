package com.springboot.practice.tryout;

import java.util.*;

public class TreeLevelOrder {

    static class Node{
        Node left;
        Node right;
        int data;

        Node(int data){
            this.data=data;
        }
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
        levelOrder(root);
    }

    private static void levelOrder(Node root) {
        Queue<Node> levOrder = new LinkedList<>();
        levOrder.add(root);
        while (!levOrder.isEmpty()){
            Node tmp = levOrder.poll();
            System.out.print(tmp.data);
            if(tmp.left!=null){
                levOrder.add(tmp.left);
            }
    List a = new ArrayList();
            if(tmp.right!=null){
                levOrder.add(tmp.right);
            }

        }


    }
}
