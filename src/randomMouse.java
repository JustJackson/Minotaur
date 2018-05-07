/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jackson
 */
public class randomMouse implements AutoSolver {

    MazeRunner mazeRunner;
    int[][] maze;
    int self_x = 0;
    int self_y = 0;
    int moveCounter = 0;
    int currentDirection;

    final int North = 0;
    final int East = 1;
    final int South = 2;
    final int West = 3;

    public randomMouse(MazeRunner mazeRunner){
        this.currentDirection = North;
        this.mazeRunner = mazeRunner;

    }
    boolean Collision() {
        switch (currentDirection) {
            case North:
                return maze[self_y-1][self_x] == 0;
            case South:
                return maze[self_y+1][self_x] == 0;
            case East:
                return maze[self_y][self_x+1] == 0;
            case West:
                return maze[self_y][self_x+1] == 0;
            default:
                System.out.println("We should never get here.");
                return true;
        }
    }

    void changeDirection() {
        Random numGenerator = new Random();
        int choice = numGenerator.nextInt(4);
        switch (choice) {
            case 0:
                currentDirection = North;
                break;
            case 1:
                currentDirection = East;
                break;
            case 2:
                currentDirection = South;
                break;
            case West:
                currentDirection = West;
                break;
        }
    }

    void Move() {
        moveCounter++;
        switch (currentDirection) {
            case North:
                mazeRunner.setCell(self_x, self_y, MazeRunner.VISITED);
                self_y -= 1;
                mazeRunner.setCell(self_x, self_y, MazeRunner.CURRENTLOCATION);
                break;
            case South:
                mazeRunner.setCell(self_x, self_y, MazeRunner.VISITED);
                self_y += 1;
                mazeRunner.setCell(self_x, self_y, MazeRunner.CURRENTLOCATION);
                break;
            case East:
                mazeRunner.setCell(self_x, self_y, MazeRunner.VISITED);
                self_x += 1;
                mazeRunner.setCell(self_x, self_y, MazeRunner.CURRENTLOCATION);
                break;
            case West:
                mazeRunner.setCell(self_x, self_y, MazeRunner.VISITED);
                self_x -= 1;
                mazeRunner.setCell(self_x, self_y, MazeRunner.CURRENTLOCATION);
                break;
        }
    }

    public void Solve(int[][] Maze) {
        for (int i=0; i< mazeRunner.getMaze().length; i++){
            for (int j=0; j<mazeRunner.getMaze()[i].length; j++){
                if (mazeRunner.getMaze()[i][j] == MazeRunner.START || mazeRunner.getMaze()[i][j] == MazeRunner.CURRENTLOCATION){
                    self_x = j;
                    self_y = i;
                    mazeRunner.setCell(self_x, self_y, 4);
                    break;
                }
            }
        }
        //Waiting for MazeRunner to be built and how we're going to mess with
        //Imports, in future, will change to const GOAL state.
        while (!(Maze[self_y][self_x] == MazeRunner.END)) {
            if (Collision()) {
                changeDirection();
            } else {
                Move();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(randomMouse.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}


