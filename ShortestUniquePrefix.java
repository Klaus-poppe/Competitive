/***
 * Given a list of words,for each word find the shortest unique prefix.
 * You can assume a word will not be a substring of another word
 * ( play and playing won't be in the same list)
 * 
 * Input : ['joma' , 'john' , 'jack' , 'techlead']
 * 
 * Output : ['jom' , 'joh' , 'ja' , 't']
 */



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ShortestUniquePrefix{
    static List<String> getShortestUniquePrefix(List<String> input){
        List<String> commonPrefix = new ArrayList<String>();
        List<String> output = new ArrayList<String>();
        String prefix = null;
        for(int i=0;i<input.size();i++){
            int k = 1;
            for(int j=i+1; j<=input.size();j++){
                prefix = input.get(i).substring(0,k);
                if(commonPrefix.contains(prefix)){
                    k++;
                    j=i;
                }   
                else if(j< input.size() && prefix.equals(input.get(j).substring(0,k))){
                    commonPrefix.add(prefix);
                    k++;
                    j=i;
                }
            }
            output.add(prefix);
        }
        return output;
    }


    public static void main(String[] args) {
        // List<String> input = new ArrayList<String>();
        // Scanner sc = new Scanner(System.in);
        // for(;sc.hasNext();)
        //     input.add(sc.next());
        List<String> input = Arrays.asList("joma","john" ,"ashwin","jack" ,"jamie");
        List<String> output = getShortestUniquePrefix(input);
        System.out.println(output);
    }
}