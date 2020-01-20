import java.util.*;
import java.io.*;



public class Skyline {
    public static void getSkyline(List<Building> arr ,int max){
     List<Integer> skyline = new ArrayList<Integer>(Collections.nCopies(max+1, 0));
     for(int i =0 ; i<arr.size();i++){
       int leftIndex = arr.get(i).left;
       int rightIndex = arr.get(i).right;
       int height = arr.get(i).height;
        for(int j = leftIndex-1 ; j <= rightIndex-1 ; j++){
          if(height >= skyline.get(j))
          skyline.set(j , height);
        }
     }
     int height = 0;
     for(int i =0;i<skyline.size();i++){
       if(skyline.get(i) != height){
         height = skyline.get(i);
         System.out.println("( " + (i+1) + " , " + height + " )");
       }
       
     }
        
      System.out.println(skyline);
      
    }
  
    public static void main(String[] args) {
        int i;
        Scanner sc = new Scanner(System.in) ;
        List<Building> arr = new ArrayList<Building>();
        int buildings = sc.nextInt();
        int max = Integer.MIN_VALUE;
        for(i=0;i<buildings;i++){
          int left = sc.nextInt();
          int right = sc.nextInt();
          if(right >= max)
            max =right;
          int height = sc.nextInt();
          Building b = new Building(left ,right ,height);
          arr.add(b);
        }
        getSkyline(arr , max);
    }
}

class Building{
  int left,right,height;
  Building(int left , int right , int height){
    this.left = left;
    this.right =right;
    this.height = height;
  }
}
