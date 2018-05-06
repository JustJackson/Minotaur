
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class ManualSolver implements KeyListener {
    //where initialization occurs:
    MazeRunner mazeRunner;
    int currentX, currentY;
    
    public ManualSolver(MazeRunner mazeRunner){
        System.out.println("Entering Manual Solver");
        this.mazeRunner = mazeRunner;
        for (int i=0; i< mazeRunner.getMaze().length; i++){
            for (int j=0; j<mazeRunner.getMaze()[0].length; j++){
                if (mazeRunner.getMaze()[i][j] == 1){
                    currentX = j;
                    currentY = i;
                    mazeRunner.setCell(currentX, currentY, 4);
                    break;
                }
            }
        }
    }
    

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'w'){
            System.out.println("Move Up");
            System.out.println("Current Location is: (" + currentX + ", " + currentY + ")");
            attemptMove(currentX, currentY-1);
        }else if(e.getKeyChar() == 's'){
            System.out.println("Move Down");
            System.out.println("Current Location is: (" + currentX + ", " + currentY + ")");
            attemptMove(currentX, currentY+1);
        }else if(e.getKeyChar() == 'a'){
            System.out.println("Move Left");
            System.out.println("Current Location is: (" + currentX + ", " + currentY + ")");
            attemptMove(currentX-1, currentY);
        }else if (e.getKeyChar() == 'd'){
            System.out.println("Move Right");
            System.out.println("Current Location is: (" + currentX + ", " + currentY + ")");
            attemptMove(currentX+1, currentY);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Do Nothing
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //Do Nothing
    }
    
    private void attemptMove(int x, int y){
        System.out.println("Attempting to move to (" + x + ", " + y + ")");
        if (mazeRunner.getCell(x, y) == 9){
            System.out.println("YOU WIN!");
            System.exit(0);
        }
        if (mazeRunner.getCell(x, y) != 2){
            mazeRunner.setCell(x, y, 4);
            mazeRunner.setCell(currentX, currentY, 3);
            currentX = x;
            currentY = y;
            mazeRunner.incrementCurrentNumMoves();
            mazeRunner.updateDisplay();
        }else
            System.out.println("Invalid move: Wall");
    }

    
}