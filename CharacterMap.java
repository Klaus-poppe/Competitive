/***
 * Given two strings, find if there is a one to one mapping of characters between the two strings
 * 
 * Input : abc def
 *  a -> d , b -> e , c -> f
 * Output : True
 * 
 * Input : aac def
 *  a -> d , c -> e //f cannot be maped
 * Output : False
 * 
 * 
***/


import java.util.*;
import java.util.stream.*;

public class HelloWorld {
  
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      String str1 = sc.next();
      Set<Character> set1 = new HashSet<Character>();
      for(int i=0;i<str1.length();i++)
        set1.add(str1.charAt(i));
      
      String str2 = sc.next();
      Set<Character> set2 = new HashSet<Character>();
      for(int i=0;i<str2.length();i++)
        set2.add(str2.charAt(i));
      
      if(set1.size() == set2.size()){
        System.out.println("true");
      }else{
        System.out.println("false");
      }
      
      
    }
}

