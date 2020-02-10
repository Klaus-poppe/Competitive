/***
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR".
 * Write the code that will take a string and make this conversion given a number of rows.
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 */


public class ZigZagConversion{
    public String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder();

        for(int j = 0 ; j < numRows ; j++){
            int skipUp = 2*j;
            int skipDown = 2*(numRows-j) - 2;
            int alternate = 0;
            for(int i = j; i <s.length(); alternate++){
               result.append(s.charAt(i));
               if(skipDown > 0 && skipUp >0 )
                    if(alternate %2 == 0 )
                    i += skipDown;
                    else 
                    i += skipUp;
                else if (skipDown == 0 && skipUp == 0)
                    i++;
                else if(skipDown == 0)
                    i+= skipUp;
                else if(skipUp == 0)
                    i += skipDown;
            }
        }

        return result.toString(); 
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        ZigZagConversion z = new  ZigZagConversion();
        System.out.println(z.convert(s,numRows));
    }
}