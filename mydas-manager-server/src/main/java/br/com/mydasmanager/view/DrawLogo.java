package br.com.mydasmanager.view;

import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JLabel;

/**
 *
 * @author Gabriela Garcia
 */
public class DrawLogo extends JLabel {

    public DrawLogo(){
        setOpaque(false);
    }
    
    public void paint(Graphics g) {
        super.paint(g);

        Polygon p = new Polygon();
        p.addPoint(100, 0);
        p.addPoint(0, 200);
        p.addPoint(200, 200);
        
        Polygon pp = new Polygon();
        pp.addPoint(130, 20);
        pp.addPoint(40, 200);
        pp.addPoint(230, 200);

        g.setColor(Colors.MEDIUM_VIOLET_RED);
        g.fillPolygon(p);
        
        g.setColor(Colors.MEDIUM_SPRING_GREEN);
        g.fillPolygon(pp);
    }
}