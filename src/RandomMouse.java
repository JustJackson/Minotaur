
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author seanm
 */
public class RandomMouse implements AutoSolver {

    MazeRunner mazeRunner;
    int currentX, currentY;
    int moveCounter = 0;
    int currentDirection;

    final int North = 0;
    final int East = 1;
    final int South = 2;
    final int West = 3;

    public RandomMouse(MazeRunner mazeRunner){
        this.currentDirection = North;
        this.mazeRunner = mazeRunner;
        for (int i = 0; i < mazeRunner.getMaze().length; i++) {
            for (int j = 0; j < mazeRunner.getMaze()[i].length; j++) {
                if (mazeRunner.getMaze()[i][j] == MazeRunner.START || mazeRunner.getMaze()[i][j] == MazeRunner.CURRENTLOCATION) {
                    currentX = j;
                    currentY = i;
                    mazeRunner.setCell(currentX, currentY, 4);
                    break;
                }
            }
        }
        solve();

    }
    
    private void changeDirection() {
        Random numGenerator = new Random();
        int choice = numGenerator.nextInt(4);
        switch (choice) {
            case North:
                currentDirection = North;
                break;
            case East:
                currentDirection = East;
                break;
            case South:
                currentDirection = South;
                break;
            case West:
                currentDirection = West;
                break;
        }
    }
    
    @Override
    public void solve() {
        if (currentDirection == North) {
            System.out.println("Move Up");
            System.out.println("Current Location is: (" + currentX + ", " + currentY + ")");
            attemptMove(currentX, currentY - 1);
        } else if ( currentDirection == South) {
            System.out.println("Move Down");
            System.out.println("Current Location is: (" + currentX + ", " + currentY + ")");
            attemptMove(currentX, currentY + 1);
        } else if (currentDirection == West) {
            System.out.println("Move Left");
            System.out.println("Current Location is: (" + currentX + ", " + currentY + ")");
            attemptMove(currentX - 1, currentY);
        } else if (currentDirection == East) {
            System.out.println("Move Right");
            System.out.println("Current Location is: (" + currentX + ", " + currentY + ")");
            attemptMove(currentX + 1, currentY);
        }
    }

    private void attemptMove(int x, int y) {
        System.out.println("Attempting to move to (" + x + ", " + y + ")");
        if (y >= mazeRunner.getMaze()[0].length || y =< 0 || x >= mazeRunner.getMaze().length || x =< 0){
            System.out.println("Falling of the earth.");
            changeDirection();
            solve();
        }
        if (mazeRunner.getCell(x, y) == MazeRunner.END) {
            moveCurrentLocation(x, y);
            mazeRunner.displayWinMessage();
            mazeRunner.resetCurrentMaze();
        } else if (mazeRunner.getCell(x, y) != MazeRunner.WALL) {
            moveCurrentLocation(x, y);
            solve();
        } else {
            System.out.println("Invalid move: Wall");
            changeDirection();
            solve();
        }
    }

    private void moveCurrentLocation(int x, int y) {
        mazeRunner.setCell(x, y, MazeRunner.CURRENTLOCATION);
        mazeRunner.setCell(currentX, currentY, MazeRunner.VISITED);
        currentX = x;
        currentY = y;
        mazeRunner.incrementCurrentNumMoves();
        mazeRunner.updateDisplay();
    }

}
