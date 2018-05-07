
import java.util.Random;


/**
 *
 * @author Michael DuBose
 */
public class Pledge implements AutoSolver{
    
    
    MazeRunner mazeRunner;
    int[][] maze;
    
    int self_x = 0;
    int self_y = 0;
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
                {North, West, South, East}}
            ;
    int[][] directionalMatrixValue = {
                {0, 1, 2, -1},
                {-1, 0, 1, 2}, 
                {2, -1, 0, 1},
                {1, 2, -1, 0}}
            ;
    int[] directionIndex = {North, East, South, West};
    int preferredDirection = North;
    int currentDirection = North;
    int count = 0;

    boolean Collision(int direction) {
        switch (direction) {
            case North:
                return maze[self_x][self_y - 1] == 0;
            case South:
                return maze[self_x][self_y + 1] == 0;
            case East:
                return maze[self_x + 1][self_y] == 0;
            case West:
                return maze[self_x - 1][self_y] == 0;
            default:
                System.out.println("We should never get here.");
                return true;
        }
    }

    void pledgeAlgorithm() {
        if(count != 0){
            for(int i = 0; i < 3; i++){
            if(!Collision(directionalMatrix[currentDirection][i])){
                count += directionalMatrixValue[currentDirection][i];
                currentDirection = directionIndex[i];  
                Move();
                break;
            }
            else Move();

            }
            
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
    
    

    void Move() {
        moveCounter++;
        switch (currentDirection) {
            case North:
                self_y -= 1;
                break;
            case South:
                self_y += 1;
                break;
            case East:
                self_x += 1;
                break;
            case West:
                self_x -= 1;
                break;
        }
    }

    int[][] Solve(int[][] Maze, int x, int y) {
        self_x = x;
        self_y = y;
        setPreferredDirection();
        //Waiting for MazeRunner to be built and how we're going to mess with
        //Imports, in future, will change to const GOAL state.
        while (!(Maze[self_x][self_y] == 3)) {
            if (Collision(currentDirection)) {
                pledgeAlgorithm();
            } else {
                Move();
            }
        }
        return maze;
    }

    @Override
    public int[][] Solve(int[][] Maze) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
