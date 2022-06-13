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
   
  	public static void preOrder( Node root ) {
      
    	if( root == null)
        	return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

	public static Node insert(Node root,int data) {
        
        if(root==null){
            Node toReturn = new Node(data);
            return toReturn;
        }
        
    	Node myNode = new Node(data);
        Node rootSaved = root;
        insertRec(root, data, myNode);
        return rootSaved;
    }
    
    private static void insertRec(Node node, int data, Node toAdd){
        if(node!=null){
            if(node.data>=data){
                if(node.left!=null){
                    insertRec(node.left, data, toAdd);  
                }
                else{
                    node.left = toAdd;
                    return;
                }
            }
            else{
                if(node.right!=null){
                    insertRec(node.right, data, toAdd);
                }
                else {
                    node.right=toAdd;
                    return;    
                }
            }
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
      	preOrder(root);
    }	
}