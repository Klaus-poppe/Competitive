Ashwin Jawahar Vontivillu

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

private static int getHeight(Node current, int value, int height) {
    if (current == null) {
        return 0;
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
  int height = getHeight(bt.root, value , 1);
  if(height == 1){
    System.out.println("its the root node it has no cousins");
  }
   List cousins = new ArrayList();
  int i;
  for(i=1;i<arr.size();i++){
    if((Integer)arr.get(i) != value)
    if(getHeight(bt.root,(Integer)arr.get(i),1) == height)
      cousins.add(arr.get(i));
  } 
  
  if(cousins.isEmpty())
    System.out.println("No cousins found");
  if(!cousins.isEmpty())  
  System.out.println(cousins) ; 
  
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

