package br.com.mydasmanager.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Gabriela Garcia
 */
public class Components extends JFrame {

    JPanel components;
    
    public Components() {
        
        setUndecorated(true);
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        this.getContentPane().setBackground(Colors.WHITE);
        
        components = new JPanel();
        components = new GradientPanel(Colors.BLACK, Colors.MEDIUM_BLACK);
        components.setSize(500, 550);
        components.setLocation(0, 0);
        components.setLayout(null);
        
        setVisible(true);
    }
}
