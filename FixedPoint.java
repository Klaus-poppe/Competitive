/***
A fixed point in a list is where the value is equal to its index. So for example the list [-5, 1, 3, 4],
1 is a fixed point in the list since the index and value is the same. 
Find a fixed point (there can be many, just return 1) in a sorted list of distinct elements,
or return None if it doesn't exist.

Input : [-5, 1, 3, 4]
Output: 1

***/





import java.util.*;
import java.io.*;

public class FixedPoint {
    
    static void getFixedPoint(List<Integer> ls, int pointer){
   // System.out.println(pointer);
    if(ls.get(pointer) == pointer){
      System.out.println(pointer);
      return;
    }
    if(ls.get(pointer) > pointer){
      if(pointer==0){
      System.out.println("None");
      return;
    }
      pointer = pointer/2;
      getFixedPoint(ls,pointer);
    
    }
    else if(ls.get(pointer) < pointer){
        if(pointer==ls.size()-1){
      System.out.println("None");
      return;
    }
      int temp = ls.size()- pointer;
      pointer += temp/2;
      getFixedPoint(ls,pointer);
    }
      
      
    
    }
    
    public static void main(String [] args){
      Scanner sc = new Scanner(System.in);
      List <Integer> ls =new ArrayList<Integer>();
      for(int i=0;sc.hasNextInt();i++){
        int x = sc.nextInt();
        ls.add(x);
        }
        int size = ls.size();
        int pointer = size/2;
        getFixedPoint(ls,pointer);
        
    }
