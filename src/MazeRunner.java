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
    
    public static int[][] maze;
    ManualSolver ms;
    GUI gui;
    MazeBuilder mazeBuilder;
    
    static final int NOTVISITED = 0;
    static final int START = 1;
    static final int WALL = 2;
    static final int VISITED = 3;
    static final int CURRENTLOCATION = 4;
    static final int END = 9;
    int currentNumMoves;
    
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
        currentNumMoves = 0;
        mazeBuilder = new MazeBuilder();
        mazeBuilder.generateMaze();
        maze = mazeBuilder.returnMaze();
        AutoSolver solve = autoSolver();
        solve.Solve(maze);
        
        

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
        maze[cellY][cellX] = newValue;
    }
    public int getCell(int cellX, int cellY){
        return maze[cellY][cellX];
    }
    public void attachGUI(GUI gui){
        this.gui = gui;
    }
    public void updateDisplay(){
        gui.repaint();
    }
    public void createNewMaze(){
        maze = mazeBuilder.returnMaze();
    }
    public void resetCurrentMaze(){
        mazeBuilder.generateMaze();
        maze = mazeBuilder.returnMaze();
    }
    
    public void incrementCurrentNumMoves(){
        currentNumMoves++;
    }
    public int getCurrentNumMoves(){
        return currentNumMoves;
    }
    public void resetCurrentNumMoves(){
        currentNumMoves = 0;
    }
    public AutoSolver autoSolver(){        
       if (MazeBuilder.width * MazeBuilder.length <= 66){
           System.out.println("Mouse");
           return new randomMouse();
        }
       if (MazeBuilder.width * MazeBuilder.length <= 132){
           System.out.println("Wall");
           return new randomMouse();
        }
       if (MazeBuilder.width * MazeBuilder.length >= 133){
           System.out.println("Pledge");
           return new Pledge();
        }
       return new Pledge();   
    }
    }


