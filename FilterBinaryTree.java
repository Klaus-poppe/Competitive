
/***
 * Given  a binary tree and an integer k, filter the binary tree such that its leaves don't contain the value k.
 * The rules for this are
 * 1. If a leaf node has a value of k, remove it.
 * 2. If a parent node has a value of k and all of its children are removed, remove it
 * 
 * Input : 1 
 * 
 *      1
 *     / \
 *    1   1
 *   /   / 
 *  2   1   
 * 
 * Output :
 * 
 *      1
 *     /
 *    1
 *   /
 *  2
 * 
 */

public class FilterBinaryTree {

    static void filter(Node root , int key){
        if(root.left != null)
            filter(root.left,key);
        if(root.right != null)
            filter(root.right,key);
        
        if(root.left != null && root.left.value ==  null)
            root.removeChild("left");
        
        if(root.right != null && root.right.value ==  null)
            root.removeChild("right");

        if(root.value == key && root.left == null && root.right == null){
            root.clear();
            return;
        }    
    }


    public static void main(String[] args) {
        Node n6 = new Node(1);
        Node n5 = new Node(2);
        Node n4 = new Node(1);
        Node n3 = new Node(1,n4);
        Node n2 = new Node(1,n5,n6);       
        Node root = new Node(1,n2,n3);
        root.print();
        filter(root,1);
        root.print();
        
        
    }
}


class Node {
    Integer value;
    Node left;
    Node right;

    Node(int value){
        this.value = value;
    }
    Node(int value,Node left){
        this.value = value;
        this.left = left;
    }
    Node(int value ,Node left ,Node right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    void print(){
        print(this,0);
        System.out.println();
    }

    void print(Node root , int level){
        String tab = "";
        for(int i = 0 ; i< level ; i++)
            tab += "\t";

        System.out.print("{\n" + tab + " value : " + root.value);

        if(root.left != null){
        System.out.print("\n" + tab + " left  :");
        print(root.left,level+1); 
        }

        if(root.right != null){
        System.out.print("\n" + tab + " right :");
        print(root.right,level+1);
        }

        System.out.print("\n" + tab + "}");
  
    }

    void removeChild(String child){
        if(child.equals("left"))
        this.left = null ;
        else if(child.equals("right"))
        this.right = null;
    }


    void clear(){
        this.value = null;
        this.left = null;
        this.right = null;
    }
    
    
}