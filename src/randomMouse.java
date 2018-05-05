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

    MazeRunner mazeRunner;
    int[][] maze;
    int self_x = 0;
    int self_y = 0;
    int moveCounter = 0;

    final int North = 0;
    final int East = 1;
    final int South = 2;
    final int West = 3;

    int currentDirection = North;

    boolean Collision() {
        switch (currentDirection) {
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

    public void Solve(int[][] Maze) {
        self_x = start;
        self_y = y;
        //Waiting for MazeRunner to be built and how we're going to mess with
        //Imports, in future, will change to const GOAL state.
        while (!(Maze[self_x][self_y] == 3)) {
            if (Collision()) {
                changeDirection();
            } else {
                Move();
            }
        }

    }


