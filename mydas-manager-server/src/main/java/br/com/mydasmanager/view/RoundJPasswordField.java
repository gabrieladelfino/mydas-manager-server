/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mydasmanager.view;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPasswordField;

/**
 *
 * @author Gabriela Garcia
 */
public class RoundJPasswordField extends JPasswordField {

    private Shape shape;

    public RoundJPasswordField() {
        setOpaque(false);
    }

    protected void paintComponent(Graphics g) {
        g.setColor(Colors.WHITE);
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 4, 4);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getBackground());
        g.drawRoundRect(0, 0, getWidth(), getHeight(), 4, 4);
    }

    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 4, 4);
        }

        return shape.contains(x, y);
    }

}
