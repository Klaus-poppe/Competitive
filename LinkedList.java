/***
 * Given a linked list swap the poisition of the 1st and 2nd node,
 * 2nd and 3rd node and so on.
 * 
 * Input : 1 -> 2 -> 3 -> 4 -> 5
 * Output: 2 -> 1 -> 4 -> 3 -> 5
 * 
 */



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LinkedList{    

    Node root;
    
    LinkedList(){
        this.root = null;
     }
    
    LinkedList(int value){
        this.root = new Node(value);
    }

    void addList(List<Integer> ls){
        for(int i : ls)
            this.add(i);
    }
    
    void add(int value){
        if(root == null){
            root = new Node(value); 
            return;
        }
        Node current = root;
        while(current.hasNext())
            current = current.next;
        current.next = new Node(value);    
    }
    
    void print(){
        Node current = this.root;
        System.out.print(current.value);
        while(current.hasNext()){
            current = current.next;
            System.out.print(" -> " +  current.value);
        }
        System.out.println();
    }

    void swapConsecutively(){
        Node current = this.root;
        for(;current.hasNext();){
            current.swapNext();
            current = current.next.next;
            if(current == null)
                break;
        }
    }

    int length(){
        int length = 1;
        Node current = this.root;
        while(current.hasNext()){
            length++;
            current = current.next;
        }   
        return length;    
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // List<Integer> ls = new ArrayList<Integer>();
        // for(;sc.hasNextInt();)
        //     ls.add(sc.nextInt());
     
        List<Integer> ls = Arrays.asList(1,2,3,4,5);
        LinkedList ll = new LinkedList();
        ll.addList(ls);
        ll.print();
        ll.swapConsecutively();
        ll.print();
    }

}

class Node{
    int value;
    Node next;
    Node(int value){
        this.value = value;
    }
    Node(int value , Node next){
        this.value = value;
        this.next = next;
    }
    boolean hasNext(){
        return this.next != null ? true : false;    
    }
  
    void swapNext(){
        if(this.next == null)
            return;
        this.value = this.value ^ next.value ^ (this.next.value = this.value);
    }
}

