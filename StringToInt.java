/***
 * Implement atoi which converts a string to an integer.The function first discards 
 * as many whitespace characters as necessary until the first non-whitespace character is found. 
 * Then, starting from this character, takes an optional initial plus or minus sign 
 * followed by as many numerical digits as possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral 
 * number, which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral 
 * number, or if no such sequence exists because either str is empty or it contains only 
 * whitespace characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned.
 * 
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers 
 * within the 32-bit signed integer range: [−231,  231 − 1]. 
 * If the numerical value is out of the range of representable values, 
 * INT_MAX  or INT_MIN  is returned.
 * 
 * Input: "4193 with words"
 * Output: 4193
 * 
 * Input: "words and 987"
 * Output: 0
 * 
 * Input: "-91283472332"
 * Output: -2147483648
 * 
 */

class Solution {
    public int myAtoi(String str) {
        StringBuilder number = new StringBuilder();
        int i;
     
        for(i =0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == ' ')
                continue;    
            if(ch == '-'){
                number.append("-");
                i++;
                break;
            }   
            else if(ch == '+')  { 
                i++;
                break;
            }
            else 
                break; 

        } 


        for(;i<str.length(); i++){
            Character ch = str.charAt(i);
            if(isNaN(ch))
                number.append(ch);
            else
                break;    
        }

        if(number.length() == 0 || (number.length() == 1 && number.charAt(0) == '-'))
            return 0;
            
        str = new String(number);

          try{
                i = Integer.valueOf(str);
            }catch(NumberFormatException e){
              if(str.charAt(0) == '-')
                return Integer.MIN_VALUE;
              else
                return Integer.MAX_VALUE;  
            }
        
        return i;
    }

    static boolean isNaN(Character ch){
            if(ch.equals('0') || ch.equals('1') || ch.equals('2') ||ch.equals('3') ||ch.equals('4') ||ch.equals('5') ||ch.equals('6') ||ch.equals('7') || ch.equals('8') || ch.equals('9') )
             return true;
             else
             return false;
    }
    public static void main(String[] args) {
        String str =  "-";
        Solution s = new Solution();
        long start = System.nanoTime();
        System.out.println(s.myAtoi(str));
        long end = System.nanoTime();
        double seconds = (double) (end-start)/1_000_000_000.0;
        System.out.println(seconds);
    }
}