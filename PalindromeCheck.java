/***
 * Given a string, determine if there is a way to arrange 
 * the string such that the string becomes a palindrome.
 * If such arrangement exists,return a palindrome(there can be more then one). 
 * Otherwise return None
 * 
 * Input : mmoom
 * Output: momom
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromeCheck{

    static String findPallindrome(String str){   

        Map<Character,Integer> count = new HashMap<Character,Integer>();

        for(int i = 0 ; i < str.length(); i++){
            Character c = str.charAt(i);
            count.put(c , count.getOrDefault(c, 0) + 1);
        }

         long oddCount = count.values().stream().filter( k -> k%2 == 1 ).count();

         if(oddCount > 1)
            return "None";

         Character middle = null;
         StringBuilder str1 = new StringBuilder();
         StringBuilder str2 = new StringBuilder();  

         for(Map.Entry<Character,Integer> entry : count.entrySet()){
             Character c = entry.getKey();
             Integer n = entry.getValue();
                 for(int i = 0 ; i< n/2; i++){
                     str1.append(c);
                     str2.append(c);   
                 }
              if(n%2 ==1)   
                 middle =c;
            }

         str2 = str2.reverse();    
         if(middle == null)
              str1.append(str2);
         else{
            str1.append(middle);
            str1.append(str2);
         }

         return str1.toString();        
    }   

       public static void main(String[] args) {
        //    Scanner sc = new Scanner(System.in);
        //    String str = sc.next(); 
        String str = "mmoom";
        System.out.println(findPallindrome(str));
    }
}