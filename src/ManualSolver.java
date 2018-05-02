
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class ManualSolver implements KeyListener {
    //where initialization occurs:
    MazeRunner mazeRunner;
    
    public ManualSolver(MazeRunner mazeRunner){
        
        this.mazeRunner = mazeRunner;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'w'){
            System.out.println("Move Up");
        }else if(e.getKeyChar() == 's'){
            System.out.println("Move Down");
        }else if(e.getKeyChar() == 'a'){
            System.out.println("Move Left");
        }else if (e.getKeyChar() == 'd'){
            System.out.println("Move Right");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    
}