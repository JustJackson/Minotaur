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
    
    /**
     * Values: 1 = START, 0 = not visited, 2 = wall, 3 = visited, 4 = current location, 9 = END
     */
    
    /*
    This is a dummy maze until we get a functioning MazeBuilder
    */
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

    public int[][] getDefaultMaze() {
        return defaultMaze;
    }
    public void manualSolve(){
        ManualSolver ms = new ManualSolver(this);
        System.out.println("Entering Manual Solver");
    }
}
