
import java.util.Random;

/**
 *
 * @author Michael DuBose
 */
public class Pledge implements AutoSolver {

    MazeRunner mazeRunner;

    int currentX;
    int currentY;
    int moveCounter = 0;

    final int North = 0;
    final int East = 1;
    final int South = 2;
    final int West = 3;
    int[][] directionalMatrix
            = {
                {East, North, West, South},
                {South, East, North, West},
                {West, South, East, North},
                {North, West, South, East}};
    int[][] directionalMatrixValue = {
        {0, 1, 2, -1},
        {-1, 0, 1, 2},
        {2, -1, 0, 1},
        {1, 2, -1, 0}};
    int[] directionIndex = {North, East, South, West};
    int preferredDirection;
    int currentDirection;
    int count;

    public Pledge(MazeRunner mazeRunner) {
        this.mazeRunner = mazeRunner;
        this.currentDirection = North;
        count = 0;
        setPreferredDirection();
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

    boolean collision(int direction) {
        switch (direction) {
            case North:
                return mazeRunner.getCell(currentX, currentY - 1) == MazeRunner.WALL;
            case South:
                return mazeRunner.getCell(currentX, currentY + 1) == MazeRunner.WALL;
            case East:
                return mazeRunner.getCell(currentX + 1, currentY) == MazeRunner.WALL;
            case West:
                return mazeRunner.getCell(currentX - 1, currentY) == MazeRunner.WALL;
            default:
                System.out.println("We should never get here.");
                return true;
        }
    }

    void setPreferredDirection() {
        Random numGenerator = new Random();
        int choice = numGenerator.nextInt(4);
        switch (choice) {
            case 0:
                preferredDirection = North;
                break;
            case 1:
                preferredDirection = East;
                break;
            case 2:
                preferredDirection = South;
                break;
            case West:
                preferredDirection = West;
                break;
        }
        System.out.println("Your preferred choice is " + choice);
    }

    void move() {
        moveCounter++;
        switch (currentDirection) {
            case North:
                System.out.println("Current X: " + currentX + " Current Y: " + currentY + "Value: " + mazeRunner.getCell(currentX, currentY));
                mazeRunner.setCell(currentX, currentY, MazeRunner.VISITED);
                currentY -= 1;
                mazeRunner.setCell(currentX, currentY, MazeRunner.CURRENTLOCATION);
                mazeRunner.incrementCurrentNumMoves();
                mazeRunner.updateDisplay();
                break;
            case South:
                System.out.println("Current X: " + currentX + " Current Y: " + currentY + "Value: " + mazeRunner.getCell(currentX, currentY));
                mazeRunner.setCell(currentX, currentY, MazeRunner.VISITED);
                currentY += 1;
                mazeRunner.setCell(currentX, currentY, MazeRunner.CURRENTLOCATION);
                mazeRunner.incrementCurrentNumMoves();
                mazeRunner.updateDisplay();
                break;
            case East:
                System.out.println("Current X: " + currentX + " Current Y: " + currentY + "Value: " + mazeRunner.getCell(currentX, currentY));
                mazeRunner.setCell(currentX, currentY, MazeRunner.VISITED);
                currentX += 1;
                mazeRunner.setCell(currentX, currentY, MazeRunner.CURRENTLOCATION);
                mazeRunner.incrementCurrentNumMoves();
                mazeRunner.updateDisplay();
                break;
            case West:
                System.out.println("Current X: " + currentX + " Current Y: " + currentY + "Value: " + mazeRunner.getCell(currentX, currentY));
                mazeRunner.setCell(currentX, currentY, MazeRunner.VISITED);
                currentX -= 1;
                mazeRunner.setCell(currentX, currentY, MazeRunner.CURRENTLOCATION);
                mazeRunner.incrementCurrentNumMoves();
                mazeRunner.updateDisplay();
                break;
        }
    }

    void pledgeAlgorithm() {
        System.out.println("In Algorithm");
        if (count == 0) {
            for (int i = 0; i < 3; i++) {
                if (!collision(directionalMatrix[currentDirection][i])) {
                    count += directionalMatrixValue[currentDirection][i];
                    currentDirection = directionIndex[i];
                    System.out.println("Count: " + count + "currentDirection: " + currentDirection);
                    System.out.println("X before: " + currentX + " Y: " + currentY);
                    move();
                    System.out.println("X before: " + currentX + " Y: " + currentY);
                    break;
                }
                
                else{
                        System.out.println("PledgeAlgorithm Else");
                        System.out.println("X before: " + currentX + " Y: " + currentY);
                        move();
                        System.out.println("X before: " + currentX + " Y: " + currentY);
                        }
            }

        }
    }

    public void solve() {
        //Waiting for MazeRunner to be built and how we're going to mess with
        //Imports, in future, will change to const GOAL state.
        System.out.println("Begin loop");
        while (!(mazeRunner.getCell(currentX, currentY) == MazeRunner.END)) {
            System.out.println("NOT THE END");
            if (collision(currentDirection)) {
                System.out.println("in IF");
                pledgeAlgorithm();
            } else {
                System.out.println("In Else");
                move();
            }
        }

    }

}
