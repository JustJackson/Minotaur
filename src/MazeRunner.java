/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author seanm
 */
class MazeRunner {
    
    int[][] maze;
    ManualSolver ms;
    
    /**
     * Values: 1 = START, 0 = not visited, 2 = wall, 3 = visited, 4 = current location, 9 = END
     */
    
    /*
    This is a dummy maze until we get a functioning MazeBuilder
    */
    public MazeRunner(){
        int[][] defaultMaze
            = {
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 1, 2, 0, 2, 0, 2, 0, 0, 0, 0, 0, 2},
                {2, 0, 2, 0, 0, 0, 2, 0, 2, 2, 2, 0, 2},
                {2, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 2},
                {2, 0, 2, 0, 0, 0, 0, 0, 2, 2, 2, 0, 2},
                {2, 0, 2, 0, 2, 2, 2, 0, 2, 0, 0, 0, 2},
                {2, 0, 2, 0, 2, 0, 0, 0, 2, 2, 2, 0, 2},
                {2, 0, 2, 0, 2, 2, 2, 0, 2, 9, 2, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
            };
        maze = defaultMaze;
    }

    public int[][] getMaze() {
        return maze;
    }
    public void resetMaze(){
        int[][] defaultMaze
            = {
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 1, 2, 0, 2, 0, 2, 0, 0, 0, 0, 0, 2},
                {2, 0, 2, 0, 0, 0, 2, 0, 2, 2, 2, 0, 2},
                {2, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 2},
                {2, 0, 2, 0, 0, 0, 0, 0, 2, 2, 2, 0, 2},
                {2, 0, 2, 0, 2, 2, 2, 0, 2, 0, 0, 0, 2},
                {2, 0, 2, 0, 2, 0, 0, 0, 2, 2, 2, 0, 2},
                {2, 0, 2, 0, 2, 2, 2, 0, 2, 9, 2, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
            };
        maze = defaultMaze;
    }
    public void manualSolve(){
        ms = new ManualSolver(this);
    }
    /**
     * newValue: 1 = START, 0 = not visited, 2 = wall, 3 = visited, 4 = current location, 9 = END
     * @param cellX
     * @param cellY
     * @param newValue 
     */
    public void setCell(int cellX, int cellY, int newValue){
        maze[cellY][cellX] = 4;
    }
}