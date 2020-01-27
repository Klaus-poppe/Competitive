/***
 * Given two rectangles,find the area of intersection
 * Input : rect1: (x1=0,y1=0) ,(x2=3,y2=2)
 *         rect2: (x3=1,y3=1) ,(x4=3,y4=3)
 *
 *    B B B 
 *  A X X B
 *  A A A
 * 
 * Output : 2
***/

class RectangleIntersection 
{ 
// area of intersection of two rectangles. 
      static void findIntersectArea(Rectangle rect1 , Rectangle rect2) 
      { 
          // gives bottom-left point 
          // of intersection rectangle 
          Rectangle intersect = new Rectangle();
          intersect.x1 = Math.max(rect1.x1, rect2.x1); 
          intersect.y1 = Math.max(rect1.y1, rect2.y1); 
        
          // gives top-right point 
          // of intersection rectangle 
          intersect.x2 = Math.min(rect1.x2, rect2.x2); 
          intersect.y2 = Math.min(rect1.y2, rect2.y2); 
        
          // no intersection 
          if (intersect.x1 > intersect.x2 || intersect.y1 > intersect.y2)  
          { 
              System.out.println("No intersection"); 
              return; 
          } 
        
          int area = intersect.getArea();
          System.out.println(area);
          intersect.printCoordinates();
        
      
      } 
        
      
      public static void main(String args[]) 
      {
          // Scanner sc = new Scanner(System.in);
          // int x1 = sc.nextInt();
          // int y1 = sc.nextInt();
          // int x2 = sc.nextInt();
          // int y2 = sc.nextInt();
          // int x3 = sc.nextInt();
          // int y3 = sc.nextInt();
          // int x4 = sc.nextInt();
          // int y4 = sc.nextInt();
          
          // bottom-left and top-right 
          // corners of first rectangle 
          int x1 = 0, y1 = 0,  
              x2 = 3, y2 = 2; 
      
          // bottom-left and top-right 
          // corners of first rectangle 
          int x3 = 2, y3 = 1,  
              x4 = 3, y4 = 3; 
      
          Rectangle rect1 = new Rectangle(x1,y1,x2,y2);
          Rectangle rect2 = new Rectangle(x3,y3,x4,y4);  
      
          findIntersectArea(rect1,rect2); 
      } 
} 

class Rectangle{
  int x1 ,y1,x2,y2;
  Rectangle(){
    
  }
  
  Rectangle(int x1,int y1,int x2,int y2){
    this.x1=x1;
    this.y1=y1;
    this.x2=x2;
    this.y2=y2;
  }
  
  int getArea(){
    return (this.x2 -this.x1)*(this.y2-this.y1);
  }
  
  void printCoordinates(){
    System.out.println("(x1,y1)=("+ this.x1 + "," + this.y1 +") (x2,y2)=(" + this.x2 + "," + this.y2 + ")");
  }
}  
