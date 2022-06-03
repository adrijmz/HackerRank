package ProblemSolving.Trees;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/

    private static int leftHight(Node root){
        if(root == null) return 0;
        return 1+leftHight(root.left);
    }
    private static int rightHeight(Node root){
        if(root==null) return 0;
        return 1+rightHeight(root.right);
    }
    private static void printLeft(Node root){
        if(root==null) return;
        System.out.print(root.data + " ");
        printLeft(root.left);
    }
    private static void printRight(Node root){
        if(root==null) return;
        System.out.print(root.data + " ");
        printRight(root.right);
    }

	public static void topView(Node root) {
      if(leftHight(root.left)>rightHeight(root.right)){
        printLeft(root);
      }
      else printRight(root);
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
        topView(root);
    }	
}