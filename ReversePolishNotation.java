/***
 * Given an expression as a list in reverse polish notation, evaluate the expression.
 * Reverse Polish notation is where numbers come before the operand.
 * Operation is performed on the previous two numbers.
 * 
 * Input : [1,2,3,+,2,*,-]
 * #above input is equivalent to (1 - ((2+3) * 2)) 
 * Ouput : -9
 * 
 * Explanation : push 1, 2 and 3 in the stack [3,2,1]
 * perform '+' on previous 2 numbers .i.e 3 and 2
 * push result in the stack [5,1]
 * Continue in this fashion till expression is evaluated. 
 * 
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;;


public class ReversePolishNotation{
    static Stack<Double> evaluate(List<String> input){
        Stack<Double> numbers = new Stack<Double>();
        numbers.push(Double.valueOf(input.get(0)));
        numbers.push(Double.valueOf(input.get(1)));
       for(int i = 2 ; i < input.size();i++){
           String exp = input.get(i);
           Double x2 = numbers.pop();
           Double x1 = numbers.pop();
           if(exp.equals("+"))
               numbers.push(x1+x2);
           else if(exp.equals("-"))
               numbers.push(x1-x2);
           else if(exp.equals("/"))
               numbers.push(x1/x2);
           else if(exp.equals("*"))
               numbers.push(x1*x2);
           else{
               numbers.push(x1);
               numbers.push(x2);
               numbers.push(Double.valueOf(exp));
           }
       }
       return numbers;
    }

    public static void main(String[] args) {
        // List<String> input = new  ArrayList<String>();
        // Scanner sc = new Scanner(System.in);
        // for(;sc.hasNext();)
        //     input.add(sc.next());

        List<String> input = Arrays.asList("1","2","4","/","2","*","-");
        System.out.println(evaluate(input));
        
    }
}