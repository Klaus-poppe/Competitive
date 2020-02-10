/***
 * Convert roman numerals to arabic numbers.
 * 
 * Input : III
 * Output: 3
 * 
 * Input : LIV
 * Output: 54
 * 
 */

public class RomanToInt {
    
    static int romanToInt(String s){
        int res = 0;
        int n = s.length();
            for(int i =0 ; i < n ; i++){
                char c = s.charAt(i);
                if(c == 'I')
                    if((i+1) < n && s.charAt(i+1) == 'V' ){
                        res += 4;
                        i++;
                    }
                    else if((i+1) < n && s.charAt(i+1) == 'X'  ){
                        res += 9;
                        i++;
                    }    
                    else    
                    res += 1;
                else if(c == 'V') 
                    res +=5;
                else if(c == 'X')
                    if((i+1) < n && s.charAt(i+1) == 'L' ){
                        res += 40;
                        i++;
                    }
                    else if((i+1) < n && s.charAt(i+1) == 'C' ){
                        res += 90;
                        i++;
                    }    
                    else  
                    res += 10;
                else if(c == 'L')
                    res += 50; 
                else if(c == 'C')
                    if((i+1) < n && s.charAt(i+1) == 'D'  ){
                        res += 400;
                        i++;
                    }
                    else if((i+1) < n && s.charAt(i+1) == 'M' ){
                        res += 900;
                        i++;
                    }    
                    else  
                    res += 100;
                else if(c == 'D')
                    res += 500;
                else if(c == 'M')
                    res += 1000;
                else 
                return 0;         
            }
        return res;
    }
    
    public static void main(String[] args) {
    String s = "III";
    long start = System.nanoTime();
    System.out.println(romanToInt(s));
    double time = (double) (System.nanoTime() - start)/1_000_000_000.0;
    System.out.println(time);
    }
}