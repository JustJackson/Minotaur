
/**
 *
 * @author jackson
 */
import java.util.Random;

public class MazeBuilder {

    private int[][] maze;
    public static int width;
    public static int length;
    public static int currentX;
    public static int currentY;
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
                result = !(y - 1 <= 1);
                break;
            case 'S':
                result = !(y + 1 <= length + 1);
                break;
            case 'E':
                result = !(x + 1 <= width + 1);
                break;
            case 'W':
                result = !(x - 1 <= 1);
                break;
        }
        return result;
    }

    void randomWalk() {
        System.out.printf("W: %d L: %d\n", width, length);
        System.out.printf("X: %d Y: %d\n", currentX, currentY);
        maze[currentX][currentY] = MazeRunner.START;
        boolean exitCondition = false;
        Random numGenerator = new Random();
        int minDistance = ((width + length) / 3);
        int counter = 0;
        int loopBreaker = 0;
        while (!exitCondition) {
            System.out.println(loopBreaker);
            if (loopBreaker > 50) {
                generateMaze();
                break;
            }
            if (maze[currentX][currentY] == nonInitialized || maze[currentX][currentY] == MazeRunner.WALL) {
                maze[currentX][currentY] = MazeRunner.NOTVISITED;
            }
            // 0 through 20. (21 Total.)
            int choice = numGenerator.nextInt(21);
            //We could make this just a break and have an unlimited for 
            //but I think this is better for clarity.
            if (choice == 0 && (currentX == 0 || currentY == 0 || currentX == width-1 || currentY == length-1) && counter >= minDistance) {
                maze[currentX][currentY] = MazeRunner.END;
                exitCondition = true;
            }
            if (choice > 1 && choice <= 5) {
                System.out.println("North");
                if (boundCheck('N', currentX, currentY)) {
                    counter++;
                    currentY--;
                }
                loopBreaker++;

            }
            if (choice > 5 && choice <= 10) {
                System.out.println("South");
                if (boundCheck('S', currentX, currentY)) {
                    counter++;
                    currentY++;
                }
                loopBreaker++;
            }
            if (choice > 10 && choice <= 15) {
                System.out.println("East");
                if (boundCheck('E', currentX, currentY)) {
                    counter++;
                    currentX++;
                }
                loopBreaker++;
            }
            if (choice > 15 && choice <= 20) {
                System.out.println("West");
                if (boundCheck('W', currentX, currentY)) {
                    counter++;
                    currentX--;
                }
                loopBreaker++;

            }
            //If we get here we assume that we got a direction but it was 
            //not valid
        }
    }

    void initalizeMaze() {
        Random numGenerator = new Random();
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                if (maze[x][y] == nonInitialized) {
                    int value = numGenerator.nextInt(10) + 1;
                    maze[x][y] = ((value > 6) ? MazeRunner.NOTVISITED : MazeRunner.WALL);
                }
            }
        }
    }

    void generateMaze() {
        int startingPointX, startingPointY, endPointX, endPointY;
        Random numGenerator = new Random();
        width = numGenerator.nextInt(10) + 6;
        length = numGenerator.nextInt(10) + 6;
        maze = new int[width][length];
        for (int y = 1; y < length - 1; y++) {
            for (int x = 1; x < width - 1; x++) {
                maze[x][y] = nonInitialized;
            }
        }
        //Initialize the Walls
        for (int i = 0; i < length - 1; i++) {
            maze[0][i] = MazeRunner.WALL;
            maze[width - 1][i] = MazeRunner.WALL;
        }
        for (int j = 0; j < width; j++) {
            maze[j][0] = MazeRunner.WALL;
            maze[j][length - 1] = MazeRunner.WALL;
        }
        boolean llSwitch = numGenerator.nextBoolean();
        //Initial Cooridnate is on the X axis.
        if (llSwitch) {
            currentX = numGenerator.nextInt(width);
            boolean topOrBottom = numGenerator.nextBoolean();
            if (topOrBottom) {
                currentY = 0;
            } else {
                currentY = length - 1;
            }
        } else {
            currentY = numGenerator.nextInt(length);
            boolean leftOrRight = numGenerator.nextBoolean();
            if (leftOrRight) {
                currentX = 0;
            } else {
                currentX = width - 1;
            }
        }
//        currentX = numGenerator.nextInt(width);
//        currentY = numGenerator.nextInt(length);
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
