/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jackson
 */
public class MazeRunnerTest {

    public MazeRunnerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    //This tests instantiates and gets a maze.
    @Test
    public void testGetMaze() {
        MazeRunner instance = new MazeRunner();
        int[][] result = instance.getMaze();
        if (!(5 > result.length || result[0].length < 20)) {
            fail("Generate Maze outside of listed parameters.");
        }
    }

    @Test
    public void testPutLocation() {
        System.out.println("Testing Cell Insert Operation.");
        MazeRunner instance = new MazeRunner();
        instance.maze = new int[][]{
            {2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 4, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2}
        };
        instance.setCell(3, 3, 5);
        if (instance.getCell(3, 3) != 5){
            fail("Failed to set cell.");
        }
    }

    @Test
    public void testAutoSolve() {
        System.out.println("Testing AutoSolve Functionality.");
        MazeRunner instance = new MazeRunner();
        GUI test = new GUI(instance);
        instance.gui = test;
        instance.createNewMaze();
        instance.autoSolve();
        //If we get here we passed.
    }

    /**
     * Test of attachGUI method, of class MazeRunner.
     */
//    @Test
//    public void testAttachGUI() {
//        System.out.println("Testing Attatchment of GUI");
//        GUI gui = null;
//        MazeRunner instance = new MazeRunner();
//        instance.attachGUI(gui);
//    }

    /**
     * Test of updateDisplay method, of class MazeRunner.
     * @throws java.lang.InterruptedException
     */
    @Test
    public void testUpdateDisplay() throws InterruptedException {
        System.out.println("Testing Update of Visual Represenation of Maze");
        MazeRunner instance = new MazeRunner();
        GUI test = new GUI(instance);
        instance.gui = test;
        instance.maze = new int[][]{
            {2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 4, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2}
        };
        instance.gui.repaint();
        Thread.sleep(2000);
        instance.maze = new int[][]{
            {2, 2, 2, 2, 2, 2, 2},
            {2, 3, 3, 3, 3, 3, 2},
            {2, 3, 3, 3, 3, 3, 2},
            {2, 3, 3, 4, 3, 3, 2},
            {2, 3, 3, 3, 3, 3, 2},
            {2, 3, 3, 3, 3, 3, 2},
            {2, 2, 2, 2, 2, 2, 2}
        };
        instance.gui.repaint();
    }

    /**
     * Test of resetCurrentMaze method, of class MazeRunner.
     */
    @Test
    public void testResetCurrentMaze() {
        System.out.println("Reset Current Maze");
        MazeRunner instance = new MazeRunner();
        GUI test = new GUI(instance);
        instance.gui = test;
        instance.createNewMaze();
        for (int y = 1; y < instance.maze.length-2; y++) {
            for (int x = 1; x < instance.maze[0].length-2; x++) {
                instance.maze[y][x] = MazeRunner.VISITED;
                }
            }
        instance.resetCurrentMaze();
        // We succeed at succesful exit.
    }


}
