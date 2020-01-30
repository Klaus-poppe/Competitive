/***
 * A maze is a matrix where each cell can either be a 0 or 1.
 * 0 represents and empty cell  and 1 represents a wall.
 * 
 * Given a n x m matrix, find the number of ways someone can go
 * from the top left to the bottom right, assuming you can only
 * move right or down.
 * 
 * Input  : [[0,1,0],[0,0,1],[0,0,0]]
 *  0 1 0
 *  0 0 1
 *  0 0 0
 * Output : 2 
 * the two paths that can be taken are
 * down -> right -> down -> right
 * down -> down -> right -> right
 * 
 * 
 ***/


public class MazePaths{
    int path = 0;

    void getPaths(int [][] maze,int i , int j){
        if(i == maze.length-1 && j == maze[0].length-1){
            path++;
            return;
        } 
        if(i+1 < maze.length )
            if(maze[i+1][j] == 0)
                getPaths(maze,i+1,j);
        if(j+1 < maze[0].length)
            if(maze[i][j+1] == 0)
                getPaths(maze,i,j+1);
     
              
        return;
    }

    public static void main(String [] args){
        int [] [] maze = { {0,1,0} , {0,0,1} ,{0,0,0},{0,0,0}};
        MazePaths mp = new MazePaths();
        mp.getPaths(maze,0,0);
        System.out.println(mp.path);

    }
}
