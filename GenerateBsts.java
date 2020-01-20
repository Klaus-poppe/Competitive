import java.io.*;
import java.util.*;

public class BinaryTree {
 
    Node root;
  Set<List<Integer>> trees = new LinkedHashSet<List<Integer>>();

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



private static BinaryTree createBinaryTree(List arr) {
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

private static List<Integer> getPreorder(Node node , List<Integer> arr) 
    { 
        if (node == null) 
            return null; 
  
        arr.add(node.value);
  
        getPreorder(node.left , arr); 
  
        getPreorder(node.right , arr);
        
        return arr;
    } 

private static void generateBsts(int n){
   List <Integer> arr = new ArrayList<Integer>();
      for(int i =1; i<=n;i++)
        arr.add(i);
  BinaryTree b = new BinaryTree();
      b.permute(arr,0,arr.size()-1);
      for(List<Integer> ls : b.trees)
        System.out.println(ls);
      
}
  

  private void permute(List<Integer> arr, int l, int r) 
    { 
      
      
        if (l == r) {
             BinaryTree bt = createBinaryTree(arr);
             List<Integer> ls = getPreorder(bt.root,new ArrayList<Integer>());
             trees.add(ls);
   
        }
        else
        { 
            for (int i = l; i <= r; i++) 
            { 
                Collections.swap(arr,l,i); 
                permute(arr, l+1, r) ;
                Collections.swap(arr,l,i); 
            } 
        }

    } 


    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      generateBsts(n);
     
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
