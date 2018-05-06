
/**
 *
 * @author jackson
 */
import java.util.Random;

public class MazeBuilder {

    private int[][] maze;
    private int width;
    private int length;
    public int currentX;
    public int currentY;
//
//    static final int NOTVISITED = 0;
//    static final int START = 1;
//    static final int WALL = 2;
//    static final int VISITED = 3;
//    static final int CURRENTLOCATION = 4;
//    static final int END = 9;

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
                result = !(x + 1 < width);
                break;
            case 'W':
                result = !(x - 1 < 1);
                break;
        }
        return result;
    }

    void randomWalk() {
        maze[currentX][currentY] = MazeRunner.START;
        boolean exitCondition = false;
        Random numGenerator = new Random();
        while (!exitCondition) {
            if (maze[currentX][currentY] == nonInitialized) {
                maze[currentX][currentY] = MazeRunner.NOTVISITED;
            }
            // 0 through 20. (21 Total.)
            int choice = numGenerator.nextInt(21);
            //We could make this just a break and have an unlimited for 
            //but I think this is better for clarity.
            if (choice == 0) {
                maze[currentX][currentY] = MazeRunner.END;
                exitCondition = true;
                continue;
            }
            if (choice > 1 && choice <= 5) {
                if (boundCheck('N', currentX, currentY)) {
                    currentY--;
                    continue;
                }
            }
            if (choice > 5 && choice <= 10) {
                if (boundCheck('S', currentX, currentY)) {
                    currentY++;
                    continue;
                }
            }
            if (choice > 10 && choice <= 15) {
                if (boundCheck('E', currentX, currentY)) {
                    currentX++;
                    continue;
                }
            }
            if (choice > 15 && choice <= 20) {
                if (boundCheck('W', currentX, currentY)) {
                    currentX--;
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
                if (maze[x][y] == nonInitialized) {
                    int value = numGenerator.nextInt(2);
                    maze[x][y] = ((value == 0) ? MazeRunner.NOTVISITED : MazeRunner.WALL);
                }
            }
        }
    }

    void generateMaze() {
        int startingPointX, startingPointY, endPointX, endPointY;
        Random numGenerator = new Random();
        width = numGenerator.nextInt(10)+6;
        length = numGenerator.nextInt(10)+6;
        maze = new int[width][length];
        for (int y = 1; y < length - 1; y++) {
            for (int x = 1; x < width - 1; x++) {
                maze[x][y] = nonInitialized;
            }
        }
        //Initialize the Walls
//        for (int i = 0; i<width-1; i++){
//            maze[0][i] = MazeRunner.WALL;
//            maze[length-1][i] = MazeRunner.WALL;
//        }
//        for (int j = 0; j<length-1; j++){
//            maze[j][0] = MazeRunner.WALL;
//            maze[j][width-1] = MazeRunner.WALL;
//        }
        currentX = numGenerator.nextInt(width);
        currentY = numGenerator.nextInt(length);
        randomWalk();
        initalizeMaze();
        prettyPrint();
    }

    int[][] returnMaze() {
        return maze;
    }

    public void prettyPrint() {
        for (int y = 0; y < length - 1; y++) {
            for (int x = 0; x < width - 1; x++) {
                System.out.print(maze[x][y]);
                System.out.print(" ");
            }
            System.out.println("\n");
        }

    }
}
