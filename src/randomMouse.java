/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;

/**
 *
 * @author jackson
 */
public class randomMouse implements AutoSolver {

    int[][] maze = MazeRunner.maze;
    int self_x = 0;
    int self_y = 0;
    int moveCounter = 0;

    final int North = 0;
    final int East = 1;
    final int South = 2;
    final int West = 3;

    int currentDirection = North;

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
            }
        }
        
        return maze;

    }
}
