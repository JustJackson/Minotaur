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

    int length = 0;
    int width = 0;

    boolean Collision() {
        switch (currentDirection) {
            case North:
                if (self_y <= 1) {
                    return true;
                } else {
                    return maze[self_x][self_y - 1] == MazeRunner.WALL;
                }
            case South:
                if (self_y >= length - 1) {
                    return true;
                } else {
                    return maze[self_x][self_y + 1] == MazeRunner.WALL;
                }
            case East:
                if (self_x >= width - 1) {
                    return true;
                } else {
                    return maze[self_x + 1][self_y] == MazeRunner.WALL;
                }
            case West:
                if (self_x <= 1) {
                    return true;
                } else {
                    return maze[self_x - 1][self_y] == MazeRunner.WALL;
                }

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

    public int[][] Solve(int[][] Maze) {
        for (int i = 0; i <= maze.length - 1; i++) {
            for (int j = 0; j <= maze[0].length - 1; j++) {
                if (maze[i][j] == MazeRunner.END) {
                    self_x = j;
                    self_y = i;

                    break;
                }
            }
        }
        while (!(Maze[self_x][self_y] == MazeRunner.END)) {
            changeDirection();
            if (!Collision()) {


                Move();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(randomMouse.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return maze;

    }
}
