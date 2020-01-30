/***
 * Given a string, return the first recurring letter that appears
 * If there are no recurring letters then return 'None'
 * 
 * Input : qwertty
 * Output: t
 * 
 * Input : qwerty
 * Output: None  
 */

import java.util.HashMap;

public class FirstRecurrence{

    static void getFirstRecurrence(String str){
        HashMap<Character, Integer> count = new HashMap<Character, Integer>(); 
        int n = str.length();  
        int i;
        for (i = 0; i < n; i++) {
            char c = str.charAt(i);
            if(count.getOrDefault(c, 0) == 1){
                System.out.println(c);
                return;
            }   
            count.put(c, count.getOrDefault(c, 0) + 1);     
        }
        System.out.println("None");
    }

    public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    // String str = sc.nextLine();
    String str = "qwertty";
    getFirstRecurrence(str);
    }
}