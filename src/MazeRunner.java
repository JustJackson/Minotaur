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
        mazeBuilder = new MazeBuilder();
        createNewMaze();
        currentNumMoves = 0;
    }

    public int[][] getMaze() {
        return maze;
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
        gui.updateCurrentNumMoves();
        gui.repaint();
    }
    
    public void createNewMaze(){
        mazeBuilder.generateMaze();
        replaceMaze();
        currentNumMoves = 0;
    }
    public void resetCurrentMaze(){
        
        replaceMaze();
        currentNumMoves = 0;
        gui.repaint();
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
    public void displayWinMessage(){
        gui.displaySolvedMessage();
        currentNumMoves = 0;
        resetCurrentMaze();
        resetCurrentMaze();
    }
    private void replaceMaze(){
        int[][]  newMaze = new int[mazeBuilder.returnMaze().length][mazeBuilder.returnMaze()[0].length];
        for (int i=0; i<mazeBuilder.returnMaze().length; i++){
            for (int j=0; j<mazeBuilder.returnMaze()[i].length; j++){
                newMaze[i][j] = mazeBuilder.returnMaze()[i][j];
            }
        }
        maze = newMaze;
    }
    
}
