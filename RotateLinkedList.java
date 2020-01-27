/***
 * Given a linked list and a number k, rotate the linked list by k places
 * 
 * Input  : k = 2
 *          1->2->3->4->5
 * 
 * Output : 4->5->1->2->3 
 * 
***/


import java.util.*;

public class HelloWorld {
      static Node rotate(Node pointer ,int k){
        
      Node first = pointer;
      int count=1;
      while(pointer.next != null){
        pointer = pointer.next;
        count++;
      }
      pointer.next = first;
      pointer = first;
      k = k%count;
      for(int i = 1 ; i < count - k ; i++){
        pointer = pointer.next;
      }
      first = pointer.next;
      pointer.next = null;
      
      return first;
    }
  
    public static void main(String[] args) {
    Node linkedList = new Node(1,new Node(2,new Node(3,new Node(4,new Node(5,null)))));
    linkedList.print();
    System.out.println();
    linkedList = rotate(linkedList,2);
    linkedList.print();
    }
}

class Node{
  int value;
  Node next;
  Node(int value,Node next ){
  this.value = value;
  this.next = next;
  }
  
  void print(){
    Node current = this;
    while(current != null){
      System.out.print(current.value + " ");
      current = current.next;
    }
    
  }
  
}
