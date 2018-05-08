
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
        maze[currentY][currentX] = MazeRunner.START;
        boolean exitCondition = false;
        Random numGenerator = new Random();
        int minDistance = ((width + length) / 2) / 2;
        int counter = 0;
        int loopBreaker = 0;
        while (!exitCondition) {
//            System.out.println(loopBreaker);
            if (loopBreaker > 50) {
                generateMaze();
                break;
            }
//            || maze[currentX][currentY] == MazeRunner.WALL
            if (maze[currentY][currentX] == nonInitialized) {
                maze[currentY][currentX] = MazeRunner.NOTVISITED;
            }
            // 0 through 20. (21 Total.)
            int choice = numGenerator.nextInt(41);
            //We could make this just a break and have an unlimited for 
            //but I think this is better for clarity.
            if (choice == 0 && counter > minDistance) {
                maze[currentY][currentX] = MazeRunner.END;
                exitCondition = true;
            }
            if (choice > 1 && choice <= 10) {
                System.out.println("North");
                if (boundCheck('N', currentX, currentY)) {
                    counter++;
                    currentY--;
                }
                loopBreaker++;

            }
            if (choice > 10 && choice <= 20) {
                System.out.println("South");
                if (boundCheck('S', currentX, currentY)) {
                    counter++;
                    currentY++;
                }
                loopBreaker++;
            }
            if (choice > 20 && choice <= 30) {
                System.out.println("East");
                if (boundCheck('E', currentX, currentY)) {
                    counter++;
                    currentX++;
                }
                loopBreaker++;
            }
            if (choice > 30 && choice <= 40) {
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
        for (int y = 1; y < length-2; y++) {
            for (int x = 1; x < width-2; x++) {
                if (maze[y][x] == nonInitialized) {
                    int value = numGenerator.nextInt(10) + 1;
                    maze[y][x] = ((value > 6) ? MazeRunner.NOTVISITED : MazeRunner.WALL);
                }
            }
        }
    }

    void generateMaze() {
        int startingPointX, startingPointY, endPointX, endPointY;
        Random numGenerator = new Random();
        width = numGenerator.nextInt(10) + 7;
        length = numGenerator.nextInt(10) + 7;
        maze = new int[length][width];
        for (int y = 1; y < length - 1; y++) {
            for (int x = 1; x < width - 1; x++) {
                maze[y][x] = nonInitialized;
            }
        }
        //Initialize the Walls
        for (int i = 0; i < length ; i++) {
            if (i == 0 || i == length-1){
            for (int j = 0; j < width; j++) {
                maze[0][j] = MazeRunner.WALL;
                maze[length - 1][j] = MazeRunner.WALL;
            }
            }
            else{
                    maze[i][0] = MazeRunner.WALL;
                    maze[i][width-1] = MazeRunner.WALL;
            }
            
        }
        boolean llSwitch = numGenerator.nextBoolean();
        //Initial Cooridnate is on the X axis.
        if (llSwitch) {
            currentX = numGenerator.nextInt(width-2)+1;
            boolean topOrBottom = numGenerator.nextBoolean();
            if (topOrBottom) {
                currentY = 1;
            } else {
                currentY = length - 2;
            }
        } else {
            currentY = numGenerator.nextInt(length-2)+1;
            boolean leftOrRight = numGenerator.nextBoolean();
            if (leftOrRight) {
                currentX = 1;
            } else {
                currentX = width - 2;
            }
        }
//        currentX = numGenerator.nextInt(width);
//        currentY = numGenerator.nextInt(length);
        randomWalk();
        initalizeMaze();
//        prettyPrint();
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
