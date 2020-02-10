/***
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Assume we are dealing with an environment which could only store
 *  integers within the 32-bit signed integer range: [−231,  231 − 1]. 
 * For the purpose of this problem, assume that your function returns 0 
 * when the reversed integer overflows.
 * 
 * Input: -123
 * Output: -321
 * 
 * Input: 120
 * Output: 21
 * 
 */


class test {
    public int reverse(int x) {
       
        String str = String.valueOf(x);
        char ch = str.charAt(0);
        if(ch == '-' || ch == '+')
            str = str.substring(1,str.length());
            
        StringBuilder s = new StringBuilder(str);
        str = new String(s.reverse());
       try{
        x = Integer.valueOf(str);
        }catch(NumberFormatException e){
            return 0;
        }
        if(ch == '-')
            x = -1*x;
       return x;
        
    }
    public static void main(String[] args) {
        test s = new test();
        System.out.println(s.reverse(123456789));
    }        
}