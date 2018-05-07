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

    int[][] maze = MazeRunner.maze;
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

<<<<<<< HEAD
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
=======
    int length = 0;
    int width = 0;

    boolean Collision() {
        switch (currentDirection) {
            case North:
                if (self_y < 1) {
                    return true;
                } else {
                    return maze[self_x][self_y - 1] == MazeRunner.WALL;
                }
            case South:
                if (self_y > length - 1) {
                    return true;
                } else {
                    return maze[self_x][self_y + 1] == MazeRunner.WALL;
                }
            case East:
                if (self_x > width - 1) {
                    return true;
                } else {
                    return maze[self_x + 1][self_y] == MazeRunner.WALL;
                }
            case West:
                if (self_x < 1) {
                    return true;
                } else {
                    return maze[self_x - 1][self_y] == MazeRunner.WALL;
                }
>>>>>>> 36bb0f1ec1e5d9846aae7d63d574548a1505e5c7
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
            case 3:
                currentDirection = West;
                break;
        }
    }

    void Move() {
        moveCounter++;
        maze[self_x][self_y] = MazeRunner.VISITED;
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
<<<<<<< HEAD
        for (int i=0; i< mazeRunner.getMaze().length; i++){
            for (int j=0; j<mazeRunner.getMaze()[i].length; j++){
                if (mazeRunner.getMaze()[i][j] == MazeRunner.START || mazeRunner.getMaze()[i][j] == MazeRunner.CURRENTLOCATION){
                    self_x = j;
                    self_y = i;
                    mazeRunner.setCell(self_x, self_y, 4);
=======
        for (int i = 0; i < maze.length - 1; i++) {
            for (int j = 0; j < maze[0].length - 1; j++) {
                if (maze[i][j] == MazeRunner.END) {
                    self_x = j;
                    self_y = i;
>>>>>>> 36bb0f1ec1e5d9846aae7d63d574548a1505e5c7
                    break;
                }
            }
        }
<<<<<<< HEAD
        //Waiting for MazeRunner to be built and how we're going to mess with
        //Imports, in future, will change to const GOAL state.
        while (!(Maze[self_y][self_x] == MazeRunner.END)) {
=======
        while (!(Maze[self_x][self_y] == MazeRunner.END)) {
>>>>>>> 36bb0f1ec1e5d9846aae7d63d574548a1505e5c7
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
