
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author seanm
 */
public class GUI extends javax.swing.JFrame{

    /**
     * Creates new form GUI
     */
    MazeRunner mazeRunner;

    @Override
    public synchronized void addKeyListener(KeyListener l) {
        super.addKeyListener(l); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public GUI(MazeRunner mazeRunner) {
        initComponents();
        setIcon();
        this.mazeRunner = mazeRunner;
        this.setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OuterFrame = new javax.swing.JPanel();
        createNewMazeButton = new javax.swing.JButton();
        resetCurrentMazeButton = new javax.swing.JButton();
        autoSolveButton = new javax.swing.JButton();
        manualSolveButton = new javax.swing.JButton();
        field = new javax.swing.JTextField();
        giveUpButton = new javax.swing.JButton();
        currentNumMovesDisplay = new javax.swing.JTextField();
        currentNumMovesLabel = new javax.swing.JLabel();
        currentNumMovesLabel.setVisible(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Minotaur");
        setBackground(new java.awt.Color(102, 0, 0));
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        OuterFrame.setBackground(new java.awt.Color(0, 0, 0));

        createNewMazeButton.setText("Create New Maze");
        createNewMazeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewMazeButtonActionPerformed(evt);
            }
        });

        resetCurrentMazeButton.setText("Reset Current Maze");
        resetCurrentMazeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetCurrentMazeButtonActionPerformed(evt);
            }
        });

        autoSolveButton.setText("Auto Solve");

        manualSolveButton.setText("Manual Solve");
        manualSolveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manualSolveButtonActionPerformed(evt);
            }
        });

        field.setEditable(false);
        field.setBackground(new java.awt.Color(0, 0, 0));
        field.setBorder(null);

        giveUpButton.setText("Give Up!");
        giveUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giveUpButtonActionPerformed(evt);
            }
        });

        currentNumMovesDisplay.setEditable(false);
        currentNumMovesDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentNumMovesDisplayActionPerformed(evt);
            }
        });

        currentNumMovesLabel.setText("Current Number Of Moves: ");

        javax.swing.GroupLayout OuterFrameLayout = new javax.swing.GroupLayout(OuterFrame);
        OuterFrame.setLayout(OuterFrameLayout);
        OuterFrameLayout.setHorizontalGroup(
            OuterFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OuterFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(createNewMazeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetCurrentMazeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3288, Short.MAX_VALUE)
                .addComponent(currentNumMovesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentNumMovesDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(giveUpButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(autoSolveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manualSolveButton)
                .addContainerGap())
        );
        OuterFrameLayout.setVerticalGroup(
            OuterFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OuterFrameLayout.createSequentialGroup()
                .addContainerGap(580, Short.MAX_VALUE)
                .addGroup(OuterFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OuterFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(createNewMazeButton)
                        .addComponent(resetCurrentMazeButton)
                        .addComponent(autoSolveButton)
                        .addComponent(manualSolveButton)
                        .addComponent(field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OuterFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(giveUpButton)
                        .addComponent(currentNumMovesDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(currentNumMovesLabel)))
                .addContainerGap())
        );

        giveUpButton.setVisible(false);
        currentNumMovesDisplay.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OuterFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OuterFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createNewMazeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewMazeButtonActionPerformed
        // TODO add your handling code here:
        mazeRunner.createNewMaze();
        repaint();
    }//GEN-LAST:event_createNewMazeButtonActionPerformed

    private void manualSolveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manualSolveButtonActionPerformed
        // TODO add your handling code here:
        mazeRunner.manualSolve();
        field.addKeyListener(mazeRunner.ms);
        currentNumMovesDisplay.setText(String.valueOf(mazeRunner.getCurrentNumMoves()));
        currentNumMovesDisplay.setVisible(true);
        currentNumMovesLabel.setVisible(true);
        giveUpButton.setVisible(true);
        repaint();
        field.requestFocus();
        createNewMazeButton.setVisible(false);
        resetCurrentMazeButton.setVisible(false);
        autoSolveButton.setVisible(false);
        manualSolveButton.setVisible(false);
    }//GEN-LAST:event_manualSolveButtonActionPerformed

    private void giveUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giveUpButtonActionPerformed
        // TODO add your handling code here:
        field.removeKeyListener(mazeRunner.ms);
        giveUpButton.setVisible(false);
        currentNumMovesDisplay.setVisible(false);
        currentNumMovesLabel.setVisible(false);
        createNewMazeButton.setVisible(true);
        resetCurrentMazeButton.setVisible(true);
        autoSolveButton.setVisible(true);
        manualSolveButton.setVisible(true);
        repaint();
        OuterFrame.requestFocus();
        
    }//GEN-LAST:event_giveUpButtonActionPerformed

    private void currentNumMovesDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentNumMovesDisplayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currentNumMovesDisplayActionPerformed

    private void resetCurrentMazeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetCurrentMazeButtonActionPerformed
        // TODO add your handling code here:
        mazeRunner.resetCurrentMaze();
        repaint();
    }//GEN-LAST:event_resetCurrentMazeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel OuterFrame;
    private javax.swing.JButton autoSolveButton;
    private javax.swing.JButton createNewMazeButton;
    private javax.swing.JTextField currentNumMovesDisplay;
    private javax.swing.JLabel currentNumMovesLabel;
    private javax.swing.JTextField field;
    private javax.swing.JButton giveUpButton;
    private javax.swing.JButton manualSolveButton;
    private javax.swing.JButton resetCurrentMazeButton;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.translate(225, 50);
        int [][] currentMaze = mazeRunner.getMaze();
        for (int row = 0; row < currentMaze.length; row++) {
            for (int col = 0; col < currentMaze[0].length; col++) {
                Color color;
                switch (currentMaze[row][col]) {
                    case 1:
                        color = Color.BLUE;
                        break;
                    case 2:
                        color = Color.BLACK;
                        break;
                    case 3:
                        color = Color.YELLOW;
                        break;
                    case 4:
                        color = Color.RED;
                        break;
                    case 9:
                        color = Color.GREEN;
                        break;
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
    //Icon source: http://game-icons.net/lorc/originals/bull.html
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/bull.png")));
    }
    
    public void updateCurrentNumMoves(){
        currentNumMovesDisplay.setText(String.valueOf(mazeRunner.getCurrentNumMoves()));
    }
    
    public void displayWinMessage(){
        JOptionPane.showMessageDialog(rootPane, "Congratulations, You've Won!  Total Number of Moves: " + mazeRunner.getCurrentNumMoves());
    }
    
}
