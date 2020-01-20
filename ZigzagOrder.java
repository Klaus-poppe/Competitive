/***

Given a binary tree, return the list of node values in zigzag order traversal.

# Input:
#         1
#       /   \
#      2     3
#     / \   / \
#    4   5 6   7
#
# Output: [1, 3, 2, 4, 5, 6, 7]

***/


import java.util.*;
import java.io.*;

public class BinaryTree {
  
  
    static List<Integer> zigzag_order(Node root) 
    { 
        int h = height(root); 
        int i; 
   
         List<Integer> ls = new ArrayList<Integer>();
         List<Integer> ls2 = new ArrayList<Integer>();
        for (i=1; i<=h; i++){
         ls = printGivenLevel(root, i,new ArrayList<Integer>());
          if(i%2==0)
               Collections.reverse(ls);
          ls2.addAll(ls);  
        }
        
       return ls2;    
            
    } 
    
    static List<Integer> printGivenLevel (Node root ,int level,List<Integer> arr) 
    { 
        if (root == null) 
            return null; 
        if (level == 1) 
            arr.add(root.value); 
        else if (level > 1) 
        { 
            printGivenLevel(root.left, level-1,arr); 
            printGivenLevel(root.right, level-1,arr); 
        } 
        return arr;
    } 
    
    static int height(Node root) 
    { 
        if (root == null) 
           return 0; 
        else
        { 

            int lheight = height(root.left); 
            int rheight = height(root.right); 
              
         
            if (lheight > rheight) 
                return(lheight+1); 
            else return(rheight+1);  
        } 
    } 

  
    public static void main(String[] args) {
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);
        Node n13 = new Node(13);
        Node n14 = new Node(14);
        Node n15 = new Node(15);
        Node n4 = new Node(4,n8,n9);
        Node n5 = new Node(5,n10,n11);
        Node n6 = new Node(6,n12,n13);
        Node n7 = new Node(7,n14,n15);
        Node n2 = new Node(2,n4,n5);
        Node n3 = new Node(3,n6,n7);
        Node n1 = new Node(1,n2,n3);
        
     
    System.out.println(zigzag_order(n1));
        
        
    }
}

class Node{
  int value;
  Node left;
  Node right;
    Node(int value,Node left,Node right){
      this.value =value;
      this.left = left;
      this.right = right;
    }
    Node (int value){
      this.value = value;
      this.left = null;
      this.right = null;
    }
}
