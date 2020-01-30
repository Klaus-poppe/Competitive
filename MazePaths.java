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