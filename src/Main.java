import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Sean Matthew
 */
public class Main {
    
    public static void main(String[] args){
        MazeRunner mazeRunner = new MazeRunner();
        GUI gui = new GUI(mazeRunner);
        mazeRunner.attachGUI(gui);
          

    }
    
    
}
