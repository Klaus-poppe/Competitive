import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IntToEnglish{
    final Map<Integer,String> conversion = new HashMap<Integer,String>(32);

    IntToEnglish(){
        conversion.put(0, "Zero" );
        conversion.put(1, "One" );
        conversion.put(2, "Two" );
        conversion.put(3, "Three" );
        conversion.put(4 ,"Four" );
        conversion.put(5, "Five" );
        conversion.put(6, "Six" );
        conversion.put(7, "Seven" );
        conversion.put(8, "Eight" );
        conversion.put(9, "Nine" );
        conversion.put(10, "Ten" );
        conversion.put(11, "Eleven");
        conversion.put(12, "Twelve");
        conversion.put(13, "Thirteen");
        conversion.put(14, "Fourteen");
        conversion.put(15, "Fifteen");
        conversion.put(16, "Sixteen");
        conversion.put(17, "Seventeen");
        conversion.put(18, "Eighteen");
        conversion.put(19, "Nineteen");
        conversion.put(20, "Twenty");
        conversion.put(30, "Thirty");
        conversion.put(40, "Forty");
        conversion.put(50, "Fifty");
        conversion.put(60, "Sixty");
        conversion.put(70, "Seventy");
        conversion.put(80, "Eighty");
        conversion.put(90, "Ninety");
        conversion.put(100, "Hundred");
        conversion.put(1000, "Thousand");
        conversion.put(1_000_000, "Million");
        conversion.put(1_000_000_000, "Billion");
    }


    public String numberToWords(int num) {
        if(num == 0)
            return "conversion.get(num)";
    Stack<String> res = new Stack<String>();
    int comma =1;
    for(int i=0;num>0;i++){
        int digit = num%10;
        int place = (int) Math.pow(10,i);
       
        if(i==0 && (num/10)%10 == 1){
            digit += 10;
            i++;
            num /= 10;
        }else if(i ==1)
            digit *= place; 
        else if(i == 2  && digit !=0 )
          res.push(conversion.get(place));
        else if(i == 3){
            if(!(digit ==0 && (num/10)%10 == 0 && (num/100)%10 == 0))
                res.push(conversion.get((int) Math.pow(place,comma)));
            comma++;
            i=-1;
            continue;
        }

        if(digit != 0)
        res.push(conversion.get(digit));

        num/=10;
    }   

    StringBuilder result = new StringBuilder();
    for(;!res.isEmpty();){
        result.append(res.pop() + " ");
    }
    result.deleteCharAt(result.length()-1);
    return result.toString();
    }

    public static void main(String[] args) {
        int n = 1_000_000_000;
        IntToEnglish ie = new  IntToEnglish();
        System.out.println(ie.numberToWords(n));
    }
}