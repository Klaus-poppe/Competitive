import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTree{
    private Node root;
    BinaryTree(){
        root = null;
    }
    BinaryTree(List<Integer> ls){
        this.createTree(ls);
    }

    int height(){
        return height(this.root);
    }

    void print(){
        int height = height();
        for(int i=1;i<=height;i++){
            printLevel(i);
            System.out.println();        
        }
         
    }

    void printLevel (int level) { 
        List<Integer> arr = getLevel(this.root, level, new ArrayList<Integer>());
        for(Integer n : arr)
        if(n ==null)
            System.out.print(". ");
        else    
            System.out.print(n + " " );  
   } 

    void add(int value){
        if(this.root == null){
            this.root = new Node(value);
            return;
        }
        int height = height();
        for(int i=1;i<=height;i++){
            if(addRecursively(root, i, new Node(value)))
                return;
        }
    }

    void addTree(BinaryTree bt){
        int height = height();
        for(int i=1;i<=height;i++)
            if(addRecursively(this.root, i, bt.root))
                return;
    }

    private void createTree(List<Integer> ls){
        if(this.root != null){
            System.out.println("tree exists");
            return;
        }

        this.root = new Node(ls.get(0));
        createTree(this.root,ls,0); 
    }

    private void createTree(Node node,List<Integer> ls,int i){
           int left = 2*i+1;
           int right = left +1;

           if(left >= ls.size()) return;
           node.left = new Node(ls.get(left));

           if(right >= ls.size()) return;
           node.right = new Node(ls.get(left+1));
            
            createTree(node.left, ls, left);
            createTree(node.right, ls, right);
    }

   
    

    private boolean addRecursively(Node node , int level, Node newNode){
        boolean flag = false;
        if (level > 0) {  
           if(node.left == null){
           node.left = newNode;
           flag = true;
           }
           else if(level > 1)         
           flag = addRecursively(node.left, level-1,newNode); 
           
           if(flag)
           return flag; 

           if(node.right == null){
           node.right = newNode; 
           flag = true;
           } 
           else if(level>1)      
           flag = addRecursively(node.right, level-1,newNode);          
       }  
       return flag;
    }

    
    private int height(Node node){
        if(node == null)
            return 0;
        int lDepth = height(node.left);
        int rDepth = height(node.right); 

        if( lDepth > rDepth)
            return lDepth + 1 ;
        else 
            return rDepth + 1 ;   
    }


    List<Integer> getLevel (Node root ,int level,List<Integer> arr) { 
        if (root == null) 
            arr.add(null);
        else if (level == 1 ) 
            arr.add(root.value); 
        else if (level > 1) 
        { 
            getLevel(root.left, level-1,arr); 
            getLevel(root.right, level-1,arr); 
        } 
        return arr;
    } 

    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1,2,3,9,10);
        BinaryTree bt = new BinaryTree(ls);
        BinaryTree bs = new BinaryTree();
        for(int i = 0 ;i<20 ;i++)
       bs.add(i); 

      //  bt.print();
     //   bs.print();
        bt.addTree(bs);
        bt.print();

    }
}

class Node{
    Integer value;
    Node left , right;

    Node(){  }

    Node(int value){
        this.value = value;
        left = right = null;
    }
    Node(int value,Node left){
        Node(value);
        this.left = left;
    }
    Node(int value, Node left , Node right){
        Node(value,left);
        this.right = right;
    }

    void remove(){
        this.value = this.left = this.right = null;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}