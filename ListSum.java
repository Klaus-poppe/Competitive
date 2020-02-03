/***
 * Create a class that initializes with a list of numbers and has one method called sum.
 * sum should take in two parameters, startIndex and endIndex and 
 * return the sum of the list from startIndex(inclusive) and endIndex(exclusive).
 * 
 * Input : (1,2,3,4,5,6,7)
 *          2  5
 * 
 * Output: 12 (3+4+5)
 *   
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSum{
    private List<Integer> ls = new ArrayList<Integer>();

    ListSum(Integer [] arr){
        this.ls = Arrays.asList(arr);
    }

    //much faster due to simplicity
    public int sum(int startIndex , int endIndex){
        int sum = 0;
        for(int i= startIndex ; i< endIndex ;i ++ )
            sum += ls.get(i);
        return sum;    
    }
    
    //slower but one line code
    public int coolSum(int startIndex , int endIndex){
        return ls.subList(startIndex, endIndex).stream().mapToInt(Integer::intValue).sum();
    }
    
    public static void main(String[] args) {
        Integer [] arr = {1,2,3,4,5,6,7};
        
        ListSum ls = new ListSum(arr);

        System.out.println(ls.sum(2,5));
   
        System.out.println(ls.coolSum(2,5));


        
    }
}