package br.com.mydasmanager.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Modal extends JDialog {

    /**
     * Estrutural components
     */
    JLabel message;
    JLabel agree;
    JLabel disagree;
    JLabel title;
    JLabel line;

    /**
     * Size and location components
     */
    private static final int AXIS_X = 50;
    private static final int AXIS_Y = 20;
    private static final int WIDTH_COMPONENT = 300;
    private static final int HEIGHT_COMPONENT = 50;
    private static final int DIFERENCE = 50;

    public Modal(String title, String message) {

        setModal(true);
        setSize(400, 250);
        setLayout(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        this.getContentPane().setBackground(Colors.WHITE);

        this.title = new JLabel(title);
        this.title.setSize(WIDTH_COMPONENT, HEIGHT_COMPONENT);
        this.title.setLocation(AXIS_X, AXIS_Y);
        this.title.setHorizontalAlignment(SwingConstants.CENTER);
        this.title.setOpaque(false);
        add(this.title);

        this.message = new JLabel(message);
        this.message.setForeground(Colors.DARK_GRAY);
        this.message.setSize(WIDTH_COMPONENT, HEIGHT_COMPONENT);
        this.message.setLocation(AXIS_X, this.title.getY() + DIFERENCE);
        this.message.setHorizontalAlignment(SwingConstants.CENTER);
        add(this.message);

        line = new JLabel();
        line.setSize(WIDTH_COMPONENT, 2);
        line.setLocation(AXIS_X, this.message.getY() + DIFERENCE);
        line.setBackground(Colors.LIGTH_GRAY);
        line.setOpaque(true);
        add(line);

        agree = new JLabel();
        agree.setIcon(new ImageIcon("img/tick.png"));
        agree.setSize(WIDTH_COMPONENT, HEIGHT_COMPONENT);
        agree.setLocation(AXIS_X, line.getY() + DIFERENCE);
        agree.setBackground(Colors.MEDIUM_VIOLET_RED);
        agree.setOpaque(true);
        agree.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

        });
        add(agree);

        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25));
        setVisible(true);
    }
}
