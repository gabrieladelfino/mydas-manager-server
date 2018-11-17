package br.com.mydasmanager.view;


import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JLabel;


/**
 *
 * @author Gabriela Garcia
 */
public class RoundJLabel extends JLabel {

    private Shape shape;

    public RoundJLabel() {
        setOpaque(false);
    }

    protected void paintComponent(Graphics g) {
        g.setColor(Colors.WHITE);
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 9, 9);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getBackground());
        g.drawRoundRect(0, 0, getWidth(), getHeight(), 9, 9);
    }

    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 9, 9);
        }
        
        return shape.contains(x, y);
    }
}
