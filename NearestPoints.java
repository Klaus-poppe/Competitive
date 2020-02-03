/***
 * Given a list of points, an integer k and a point p,
 * find the k closest points to p. 
 * 
 * Input : k = 2 p = (0,2)
 *         points = [(0,0),(1,1),(2,2),(3,3)]
 * 
 * Output: [(0,0),(1,1)]
 * 
 * 
 */



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class NearestPoints{
    
    static List<Point> closestPoints(List<Point> points , int k , Point p){
            Map<Point,Double> distances = new LinkedHashMap<Point,Double>();
            List<Point> closest = new ArrayList<Point>();

            for(Point z : points){
                distances.put(z,p.getDistance(z));
            }
             distances = sortMap(distances);

            for(Point entry : distances.keySet())
                    closest.add(entry);

            return closest.subList(0,k);

    }

    static <K, V extends Comparable<? super V>> Map<K,V> sortMap(Map<K,V> map){
    List<Map.Entry<K,V>> ls = new ArrayList<Map.Entry<K,V>>(map.entrySet());

    Collections.sort(ls, (o1, o2) ->  o1.getValue().compareTo(o2.getValue()) );

    Map<K,V> temp = new LinkedHashMap<K,V>();

    for(Map.Entry<K,V> entry : ls)
        temp.put(entry.getKey(),entry.getValue());

    return temp;
    }
    
    public static void main(String [] args) { 
    //     Scanner sc = new Scanner(System.in);
    //     int k = sc.nextInt();
    //     int x = sc.nextInt();
    //     int y = sc.nextInt();
    //     Point p = new Point(x,y);
    //    int n = sc.nextInt();
    //     List<Point> points = new ArrayList<Point>(n);
    //    for(int i=0;i<n;i++){  
    //         x = sc.nextInt();
    //         y = sc.nextInt(); 
    //         points.add(new Point(x,y));
    //     }

        List<Point> points = new ArrayList<Point>();
        points.add(new Point(0,0));
        points.add(new Point(1,1));
        points.add(new Point(2,2));
        points.add(new Point(3,3));
    
       Point p = new Point(0,2);
       int k = 2;
      System.out.println(closestPoints(points,k,p));

    }
}


class Point{
    private int x ,y;
 

    Point(int x ,int y){
    this.x = x;
    this.y = y;    
    }

    @Override
    public String toString(){
        return "(" + x + ", " + y + ")" ;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getDistance(Point p){
        return Math.sqrt(Math.pow(p.getX() - this.getX() , 2) + Math.pow(p.getY() - this.getY() , 2)) ;
    }
}