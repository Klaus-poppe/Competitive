/***
 * Convert given integer to roman numeral(n<4000).
 * 
 * Input : 3064
 * Output: MMMLXIV
 */

import java.util.HashMap;
import java.util.Map;

public class IntToRoman {
    final Map<Integer,Character> conversion = new HashMap<Integer,Character>();
    IntToRoman(){
        conversion.put(1, 'I' );
        conversion.put(5, 'V' );
        conversion.put(10, 'X' );
        conversion.put(50 ,'L' );
        conversion.put(100, 'C' );
        conversion.put(500, 'D' );
        conversion.put(1000, 'M' );
    }

    public String intToRoman(int n){
        StringBuilder num = new StringBuilder();

        for(int i=0; n>0; i++){
            int digit = n % 10;
            int place = (int)  Math.pow(10,i);
            if(digit == 4 || digit == 9){
                num.append(conversion.get((digit+1)*place));
                num.append(conversion.get(place));
            }
            else {
                for(int j = 0; j < digit % 5 ;j++)
                    num.append(conversion.get(place));

                if(digit >= 5)
                        num.append(conversion.get(5*place));
            }

            n/=10;
        }
        
        return num.reverse().toString();
    }
    
    public static void main(String[] args) {
        int n=3064;
        IntToRoman ir = new IntToRoman();

        long start = System.nanoTime();
        System.out.println(ir.intToRoman(n));
        double time = (double) (System.nanoTime() -start)/1_000_000_000.0;
        System.out.println(time);

    }    
}