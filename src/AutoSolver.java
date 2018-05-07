/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jackson
 */
public interface AutoSolver {
    static public AutoSolver pickSolver(int length, int width){
        //Assuming that we have 25 as our minimum, and 225 as our maximum, that
        //is a range of 200. 200 divided into 3 equal segments is 67ish.
       if (width * length <= 66){
           return new randomMouse();
        }
       if (width * length <= 132){
           return new WallFollower();
        }
       if (width * length >= 133){
           return new Pledge();
        }
        
    }
    void Solve(int[][] Maze);
}
