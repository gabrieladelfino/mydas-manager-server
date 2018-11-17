package br.com.mydasmanager.view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Gabriela Garcia
 */
public class Login extends JFrame {

    /**
     * Estrutural components
     */
    JPanel contentLogin;
    JPanel contentHasCode;
    JLabel labelLogin;
    JLabel passwordLabel;
    JLabel hasACode;
    JLabel labelCode;

    /**
     * Action components
     */
    JLabel close;
    JLabel minimize;
    JTextField login;
    JPasswordField password;
    JButton sendLogin;
    JTextField code;

    /**
     * Size and location components
     */
    private static final int AXIS_X = 130;
    private static final int AXIS_Y = 180;
    private static final int WIDTH_COMPONENT = 220;
    private static final int HEIGHT_LABEL = 25;
    private static final int HEIGTH_INPUT = 30;
    private static final int DIFERENCE_BETWEEN_LABEL_AND_INPUT = HEIGTH_INPUT;
    private static final int DIFERENCE_BETWEEN_COMPONENTS = HEIGTH_INPUT + 20;
    private static final int DIFERENCE_COMPONENTS_AND_BUTTON = HEIGTH_INPUT + 30;

    public Login() {

        setUndecorated(true);
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        this.getContentPane().setBackground(new Color(255, 165, 0));

        close = new JLabel();
        close.setBounds(450, 20, 32, 32);
        close.setOpaque(false);
        close.setIcon(new ImageIcon("img/menu-bar/close-32.png"));
        close.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        minimize = new JLabel();
        minimize.setSize(32, 32);
        minimize.setLocation(400, 20);
        minimize.setOpaque(false);
        minimize.setIcon(new ImageIcon("img/menu-bar/minimize-line-32.png"));
        minimize.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setExtendedState(JFrame.ICONIFIED);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        sendLogin = new RoundJButton();
        sendLogin.setText("Entrar");
        sendLogin.setSize(WIDTH_COMPONENT, HEIGTH_INPUT);
        sendLogin.setOpaque(false);
        sendLogin.setFocusPainted(false);
        sendLogin.setBorderPainted(false);
        sendLogin.setContentAreaFilled(false);

        initializeLogin();
        setVisible(true);
    }

    private void initilizeHasCode() {
        hideContentLogin();

        contentHasCode = new GradientPanel(Colors.PALE_VIOLET_RED, Colors.MEDIUM_VIOLET_RED);
        contentHasCode.setSize(500, 550);
        contentHasCode.setLocation(0, 0);
        contentHasCode.setLayout(null);

        contentHasCode.add(close);
        contentHasCode.add(minimize);

        labelCode = new JLabel("Código de acesso");
        labelCode.setSize(WIDTH_COMPONENT, HEIGHT_LABEL);
        labelCode.setLocation(AXIS_X, AXIS_Y);
        contentHasCode.add(labelCode);

        code = new RoundJTextField();
        code.setSize(WIDTH_COMPONENT, HEIGTH_INPUT);
        code.setLocation(AXIS_X, labelCode.getY() + DIFERENCE_BETWEEN_LABEL_AND_INPUT);
        code.setBorder(null);
        contentHasCode.add(code);

        sendLogin.setLocation(AXIS_X, code.getY() + DIFERENCE_COMPONENTS_AND_BUTTON);
        sendLogin.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                verifyHasCode();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        contentHasCode.add(sendLogin);

        add(contentHasCode);
    }

    private void initializeLogin() {

        contentLogin = new GradientPanel(Colors.PALE_VIOLET_RED, Colors.MEDIUM_VIOLET_RED);
        contentLogin.setSize(500, 550);
        contentLogin.setLocation(0, 0);
        contentLogin.setLayout(null);

        contentLogin.add(close);
        contentLogin.add(minimize);

        labelLogin = new JLabel("Email ou login");
        labelLogin.setSize(WIDTH_COMPONENT, HEIGHT_LABEL);
        labelLogin.setLocation(AXIS_X, AXIS_Y);
        contentLogin.add(labelLogin);

        login = new RoundJTextField();
        login.setSize(WIDTH_COMPONENT, HEIGTH_INPUT);
        login.setLocation(AXIS_X, labelLogin.getY() + DIFERENCE_BETWEEN_LABEL_AND_INPUT);
        login.setBorder(null);
        contentLogin.add(login);

        passwordLabel = new JLabel("Senha");
        passwordLabel.setSize(WIDTH_COMPONENT, HEIGHT_LABEL);
        passwordLabel.setLocation(AXIS_X, login.getY() + DIFERENCE_BETWEEN_COMPONENTS);
        contentLogin.add(passwordLabel);

        password = new RoundJPasswordField();
        password.setSize(WIDTH_COMPONENT, HEIGTH_INPUT);
        password.setLocation(AXIS_X, passwordLabel.getY() + DIFERENCE_BETWEEN_LABEL_AND_INPUT);
        contentLogin.add(password);

        sendLogin.setLocation(AXIS_X, password.getY() + DIFERENCE_COMPONENTS_AND_BUTTON);
        sendLogin.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                verifyLogin();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        contentLogin.add(sendLogin);

        hasACode = new JLabel("Eu tenho um código");
        hasACode.setSize(WIDTH_COMPONENT, HEIGHT_LABEL);
        hasACode.setLocation(AXIS_X, sendLogin.getY() + hasACode.getHeight() + 10);
        hasACode.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                initilizeHasCode();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
        contentLogin.add(hasACode);

        add(contentLogin);
    }

    private void hideContentLogin() {
        contentLogin.setVisible(false);
    }

    private void hideContentHasCode() {
        contentHasCode.setVisible(false);
    }

    private void verifyLogin() {
        hideContentLogin();
    }

    private void verifyHasCode() {
        hideContentHasCode();
    }
}
