
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Sean Matthew
 */
public class GUI extends JFrame {

    /**
     * Values: 0 = not-visited 1 = start 2 = wall 3 = visited 4 = current location 9 = end
     */
    int[][] maze
            = {
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 1, 2, 0, 2, 0, 2, 0, 0, 0, 0, 0, 2},
            {2, 0, 2, 0, 0, 0, 2, 0, 2, 2, 2, 0, 2},
            {2, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 2},
            {2, 0, 2, 0, 0, 0, 0, 0, 2, 2, 2, 0, 2},
            {2, 0, 2, 0, 2, 2, 2, 0, 2, 0, 0, 0, 2},
            {2, 0, 2, 0, 2, 0, 0, 0, 2, 2, 2, 0, 2},
            {2, 0, 2, 0, 2, 2, 2, 0, 2, 9, 2, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
            };

    public GUI() {
        setTitle("Minotaur");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        g.translate(100, 100);
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                Color color;
                switch (maze[row][col]) {
                    case 1:
                        color = Color.BLUE; break;
                    case 2:
                        color = Color.BLACK; break;
                    case 3:
                        color = Color.YELLOW; break;
                    case 4:
                        color = Color.RED; break;
                    case 9:
                        color = Color.GREEN; break;
                    default:
                        color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(30 * col, 30 * row, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(30 * col, 30 * row, 30, 30);
            }
        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                GUI gui = new GUI();
                gui.setVisible(true);
            }
        
    });
    }
}
