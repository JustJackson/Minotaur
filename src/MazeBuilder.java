
/**
 *
 * @author jackson
 */
import java.util.Random;

public class MazeBuilder {

    private class Cell {

        int cellType = nonInitialized;
    }

    private Cell[][] maze;
    private int width;
    private int length;

    final int Wall = 0;
    final int Open = 1;
    final int Start = 2;
    final int Goal = 3;
    final int Player = 4;
    final int nonInitialized = 5;

    //
    boolean boundCheck(char Direction, int x, int y) {
        boolean result = false;
        switch (Direction) {
            case 'N':
                result = !(y - 1 < 1);
                break;
            case 'S':
                result = !(y + 1 < length);
                break;
            case 'E':
                result = !(x - 1 < 1);
                break;
            case 'W':
                result = !(x + 1 < width);
                break;
        }
        return result;
    }

    void randomWalk(int x, int y) {
        maze[x][y].cellType = Start;
        boolean exitCondition = false;
        Random numGenerator = new Random();
        while (!exitCondition) {
            if (maze[x][y].cellType == nonInitialized) {
                maze[x][y].cellType = Open;
            }
            // 0 through 20. (21 Total.)
            int choice = numGenerator.nextInt(21);
            //We could make this just a break and have an unlimited for 
            //but I think this is better for clarity.
            if (choice == 0) {
                maze[x][y].cellType = Goal;
                exitCondition = true;
                continue;
            }
            if (choice > 1 && choice <= 5) {
                if (boundCheck('N', x, y)) {
                    y--;
                    continue;
                }
            }
            if (choice > 5 && choice <= 10) {
                if (boundCheck('S', x, y)) {
                    y++;
                    continue;
                }
            }
            if (choice > 10 && choice <= 15) {
                if (boundCheck('E', x, y)) {
                    x++;
                    continue;
                }
            }
            if (choice > 15 && choice <= 20) {
                if (boundCheck('W', x, y)) {
                    x--;
                    continue;
                }
            }
            //If we get here we assume that we got a direction but it was 
            //not valid
        }
    }

    void initalizeMaze() {
        Random numGenerator = new Random();
        for (int y = 0; y < length - 1; y++) {
            for (int x = 0; x < width - 1; x++) {
                if (maze[x][y].cellType == nonInitialized) {
                    int value = numGenerator.nextInt(2);
                    maze[x][y].cellType = ((value == 0) ? Open : Wall);
                }
            }
        }
    }

    void generateMaze() {
        int startingPointX, startingPointY, endPointX, endPointY;
        Random numGenerator = new Random();
        width = numGenerator.nextInt(500);
        length = numGenerator.nextInt(500);
        maze = new Cell[width][length];
        for (int y = 0; y < length - 1; y++) {
            for (int x = 0; x < width - 1; x++) {
                maze[x][y] = new Cell();
            }
        }
        startingPointX = numGenerator.nextInt(width) + 1;
        startingPointY = numGenerator.nextInt(length) + 1;
        randomWalk(startingPointX, startingPointY);
        initalizeMaze();
    }

    Cell[][] returnMaze() {
        return maze;
    }

    public void prettyPrint() {
        for (int y = 0; y < length - 1; y++) {
            for (int x = 0; x < width - 1; x++) {
                System.out.print(maze[x][y].cellType);
                System.out.print(" ");
            }
            System.out.println("\n");
        }

    }
}
