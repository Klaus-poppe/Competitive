/***
Given a binary tree and a given node value, return all of the node's cousins.
Two nodes are considered cousins if they are on the same level of the tree with different parents. 
You can assume that all nodes will have their own unique value.

Input: [5]
#     1
#    / \
#   2   3
#  / \   \
# 4   6   5

Output: [4, 6]

***/

import java.io.*; 
import java.util.*; 

public class BinaryTree {
 
    Node root;

private Node addRecursive(Node current, int value) {
    if (current == null) {
        return new Node(value);
    }
 
    if (value < current.value) {
        current.left = addRecursive(current.left, value);
    } else if (value > current.value) {
        current.right = addRecursive(current.right, value);
    } else {
        return current;
    }
 
    return current;
}

public void add(int value) {
    root = addRecursive(root, value);
}



private BinaryTree createBinaryTree(List arr) {
    BinaryTree bt = new BinaryTree();
    int i;
    for(i=0;i<arr.size();i++){
      bt.add((Integer)arr.get(i));
    }
    return bt;
}

private static int getHeight(Node current, int value, int height) throws  Exception {
    if (current == null) {
        throw new Exception();
    } 
    if (value == current.value) {
        return 1;
    } 
    
    if(value < current.value){
      height += getHeight(current.left, value,height);
    }else{
      height += getHeight(current.right, value,height);
    }
  
  return height;
}


public static void findCousins(BinaryTree bt, int value,List arr){
  int height;
  try{
  height = getHeight(bt.root, value , 1);
  }catch(Exception e){
    height = 0;
  }
  
  if(height == 1){
    System.out.println("its the root node it has no cousins");
    return;
  }
  
     List cousins = new ArrayList();
     printGivenLevel(bt.root,height,cousins);
     cousins.remove((Integer)value);
  
  if(cousins.isEmpty())
    System.out.println("No cousins found");
  if(!cousins.isEmpty())  
  System.out.println(cousins) ; 
  
}

      static void printGivenLevel (Node root ,int level,List<Integer> arr) 
    { 
        if (root == null) 
            return; 

        if (level == 1 ) 
            arr.add(root.value); 
        else if (level > 1) 
        { 
            printGivenLevel(root.left, level-1,arr); 
            printGivenLevel(root.right, level-1,arr); 
        } 

    } 

    public static void main(String[] args) {
      BinaryTree bt = new BinaryTree();
      List arr = new ArrayList();
      Scanner sc = new Scanner(System.in);
      int search = sc.nextInt();
       for(;sc.hasNextInt();){
        arr.add(sc.nextInt());
    }
      bt = bt.createBinaryTree(arr);
      
      findCousins(bt,search,arr);
      
    }
    

}

class Node {
    int value;
    Node left;
    Node right;
 
    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}



