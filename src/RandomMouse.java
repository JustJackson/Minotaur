
import java.awt.event.KeyEvent;
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
public class RandomMouse implements Solver {

    private MazeRunner mazeRunner;
    private int currentX, currentY;
    private int moveCounter = 0;
    private int currentDirection;

    private final int North = 0;
    private final int East = 1;
    private final int South = 2;
    private final int West = 3;

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
        while (mazeRunner.getCell(currentX, currentY) != MazeRunner.END){
             solve();
        }
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
        System.out.println("Location before solve: X: " + currentX + " Y: " + currentY);
        if (currentDirection == North) {
//            System.out.println("Move Up");
//            System.out.println("Current Location is: (" + currentX + ", " + currentY + ")");
            attemptMove(currentX, currentY - 1);
        } else if ( currentDirection == South) {
//            System.out.println("Move Down");
//            System.out.println("Current Location is: (" + currentX + ", " + currentY + ")");
            attemptMove(currentX, currentY + 1);
        } else if (currentDirection == West) {
//            System.out.println("Move Left");
//            System.out.println("Current Location is: (" + currentX + ", " + currentY + ")");
            attemptMove(currentX - 1, currentY);
        } else if (currentDirection == East) {
//            System.out.println("Move Right");
//            System.out.println("Current Location is: (" + currentX + ", " + currentY + ")");
            attemptMove(currentX + 1, currentY);
        }
        System.out.println("Location after solve: X: " + currentX + " Y: " + currentY);
    }

    private void attemptMove(int x, int y) {
//        System.out.println("Attempting to move to (" + x + ", " + y + ")");
        //if (x >= mazeRunner.getMaze()[0].length-1 || x <= 0 || y >= mazeRunner.getMaze().length-1 || y <= 0){
//            System.out.println("Falling off the earth.");
            //changeDirection();
        //}
        if (mazeRunner.getCell(x, y) == MazeRunner.END) {
            moveCurrentLocation(x, y);
            mazeRunner.displayWinMessage();
        } else if (mazeRunner.getCell(x, y) != MazeRunner.WALL) {
            moveCurrentLocation(x, y);
        } //else {
//            System.out.println("Invalid move: Wall");
            changeDirection();
        //}
    }

    private void moveCurrentLocation(int x, int y) {
        mazeRunner.setCell(x, y, MazeRunner.CURRENTLOCATION);
        mazeRunner.setCell(currentX, currentY, MazeRunner.VISITED);
        currentX = x;
        currentY = y;
        mazeRunner.incrementCurrentNumMoves();
        mazeRunner.updateDisplay();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //TODO
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
