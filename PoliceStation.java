/***
 * Imagine that your city is an infinite 2D plane with Cartesian coordinate system. The only crime-affected road of your city is the x-axis. 
 * Currently, there are n criminals along the road. No police station has been built on this road yet, so the mayor wants to build one.
 * As you are going to be in charge of this new police station, the mayor has asked you to choose a suitable position (some integer point) for building it. 
 * You should choose the best position for the police station, so that you could minimize the total time of your criminal catching mission. 
 * Your mission of catching the criminals will operate only from this station.
 * The new station will have only one patrol car. You will go to the criminals by this car, 
 * carry them on the car, bring them back to the police station and put them in prison. 
 * The patrol car can carry at most m criminals at a time. Note that, the criminals don't know about your mission. 
 * So, they will stay where they are instead of running away.
 * Your task is to find the position for the police station, so that total distance you need to cover to catch all the criminals will be minimum possible.
 * Note that, you also can built the police station on the positions where one or more criminals already exist. 
 * In such a case all these criminals are arrested instantly.
 * 
 * Input
 * The first line of the input will have two integers n (1 ≤ n ≤ 10^6) and m (1 ≤ m ≤ 10^6) separated by spaces. 
 * The next line will contain n integers separated by spaces. The ith integer is the position of the ith criminal on the x-axis. 
 * Absolute value of positions will not exceed 10^9. If a criminal has position x, he/she is located in the point (x, 0) of the plane.
 * The positions of the criminals will be given in non-decreasing order. 
 * Note, that there can be more than one criminal standing at some point of the plane.
 * 
 * Input : 5 5
 *         -7 -6 -3 -1 1
 * Output: 16
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PoliceStation{

    static double average(List<Integer> arr){
       return arr.stream().mapToInt(Integer::intValue).average().orElse(0.0);    
    }


    static long getMinDistance(List<Integer>arr , int m){
        if(arr.size() <= 1)
            return 0;

        int policeStation = (int) average(arr);
        int i;
        
        //use faster search techniques to get better results
        for(i= 0 ; i<arr.size();i++){
            int criminal = arr.get(i);
             if(policeStation <= criminal) 
                break;   
        }  

        if( arr.get(i) - policeStation > policeStation - arr.get(i-1)){
            policeStation = arr.get(i-1);
            i--;
        }else
            policeStation = arr.get(i);
        
        long distance = 0;
        int n = m;
        boolean left ,right;
        left = right = true;
        for(;;){
            int farthestLeft = i-n;
            int farthestRight = i+n;
            if(i-n  < 0)
                farthestLeft = 0;
            if(i+n >= arr.size())
                farthestRight = arr.size()-1; 

            if(left)
            distance += (policeStation - arr.get(farthestLeft))*2;
            if(right)
            distance += (arr.get(farthestRight) - policeStation)*2;

            n += m;
            
            if(farthestLeft == 0)
                left =false;
            if(farthestRight == arr.size()-1)
                right = false;

            if(!right && !left)
                break;
        }


        return distance;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> arr = new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        arr.add(sc.nextInt());

        // int m = 1000000;
        // int n = 1000000;
        // List<Integer> arr = new ArrayList<Integer>();
        // for(int i=0;i<n;i++)
        // arr.add(i);

        long start = System.nanoTime();
        long distance = getMinDistance(arr, m);
        long end = System.nanoTime();
        double seconds = (double)(end-start)/ 1_000_000_000.0;
        System.out.println(distance);
        System.out.println(seconds);

    }    
}