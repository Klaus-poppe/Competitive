import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/***
 * 
 * Suppose you have a string, haystack, and a set of characters which may or may not appear in that string, alphabet.
 * (No characters appear in alphabet more than once, because it's a set.)
 * How many non-empty sub-strings of haystack do not contain every character in alphabet? 
 * Write a function that accepts haystack and alphabet as input and returns an answer to this question as an integer.
 * 
 * Input: haystack = "cab", alphabet = ['a', 'c']
 * Output: 4
 * Explanation:
 * We can enumerate all 6 non-empty substrings of `cab`:
 * "c" - this does not have `a`.
 * "a" - this does not have `c`.
 * "ca" - this has every entry in `alphabet`.
 * "b" - this does not have `a` or `c`.
 * "ab" - this does not have `c`.
 * "cab" - this has every entry in `alphabet`.
 * 4 of these substrings don't have every answer, so the function should return 4.
 * 
 */

public class SubString{
    static int substring(String haystack , Set<Character> alphabet){
        int res = 0, start =0;
        Map <Character,Integer> count = new LinkedHashMap<Character,Integer>();
        for(int i =0 ; i < haystack.length();i++){
            if(haystack.charAt(i) == ' '){
                start++;
                continue;
            }
            if(alphabet.contains(haystack.charAt(i))){   
                count.put(haystack.charAt(i) , i);
                if(count.size() == alphabet.size()){
                    Character c = count.keySet().stream().findFirst().get();
                    start =  count.get(c) + 1;
                    count.remove(c);
                }                  
            }
            res += i - start +1;
        }
        return res;
    }

    public static void main(String[] args) {
        String haystack = " cbbbbba ";
        Set<Character> alphabet = new HashSet<>(Arrays.asList('a','c'));
        long start = System.nanoTime();
        System.out.println(substring(haystack,alphabet));
        double time = (double) (System.nanoTime() - start)/1_000_000_000.0;
        System.out.println(time);
    }
}