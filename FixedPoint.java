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
