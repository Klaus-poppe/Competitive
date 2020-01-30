/***
 * Given a 32 bit integer, reverse the bits and return the number.
 * Input : 1234
 * In bits this would be 0000 0000 0000 0000 0000 0100 1101 0010
 * 
 * Output : 1260388352
 * Reversed bits are  0100 1011 0010 0000 0000 0000 0000 0000 
 * 
 */



import java.util.Scanner;

public class ReverseBits{
        static String reverseBits(String binary){
            StringBuilder tempBuilder = new StringBuilder(binary);
            tempBuilder.reverse();
            binary = new String(tempBuilder);
            for(int i=binary.length();i<32;i++){
                binary += "0";
            }
            return binary;    
        }
        public static void main(String[] args) {
            // Scanner sc = new Scanner(System.in); 
            // int n = sc.nextInt();
            int n = 1234;
            String binary = Integer.toBinaryString(n);
            // System.out.println(binary);
            String reverse = reverseBits(binary);
            n = Integer.valueOf(reverse,2);
            // System.out.println(reverse);
            System.out.println(n);    
    }

}