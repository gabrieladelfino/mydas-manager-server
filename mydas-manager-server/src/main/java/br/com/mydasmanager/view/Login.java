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
    JLabel close;
    JLabel minimize;
    JPanel content;

    /**
     * Login components
     */
    JLabel labelLogin;
    JTextField login;
    JLabel passwordLabel;
    JPasswordField password;
    JButton sendLogin;

    /**
     * Current size and location components
     */
    private static final int AXIS_X = 130;
    private static final int AXIS_Y = 180;
    private static final int WIDTH = 220;
    private static final int HEIGHT_LABEL = 25;
    private static final int HEIGTH_INPUT = 30;
    private static final int DIFERENCE_BETWEEN_LABEL_AND_INPUT = HEIGTH_INPUT;
    private static final int DIFERENCE_BETWEEN_COMPONENTS = HEIGTH_INPUT + 20;
    private static final int DIFERENCE_BETWEEN_COMPONENTS_AND_BUTTON = HEIGTH_INPUT + 30;

    public Login() {

        setUndecorated(true);
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        this.getContentPane().setBackground(new Color(255, 165, 0));

        content = new GradientPanel(Colors.PALE_VIOLET_RED, Colors.MEDIUM_VIOLET_RED);
        content.setSize(500, 550);
        content.setLocation(0, 0);
        content.setLayout(null);

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
        content.add(close);

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
        content.add(minimize);

        labelLogin = new JLabel("Email ou login");
        labelLogin.setSize(WIDTH, HEIGHT_LABEL);
        labelLogin.setLocation(AXIS_X, AXIS_Y);
        content.add(labelLogin);

        login = new RoundJTextField();
        login.setSize(WIDTH, HEIGTH_INPUT);
        login.setLocation(AXIS_X, labelLogin.getY() + DIFERENCE_BETWEEN_LABEL_AND_INPUT);
        login.setBorder(null);
        content.add(login);

        passwordLabel = new JLabel("Senha");
        passwordLabel.setSize(WIDTH, HEIGHT_LABEL);
        passwordLabel.setLocation(AXIS_X, login.getY() + DIFERENCE_BETWEEN_COMPONENTS);
        content.add(passwordLabel);

        password = new RoundJPasswordField();
        password.setSize(WIDTH, HEIGTH_INPUT);
        password.setLocation(AXIS_X, passwordLabel.getY() + DIFERENCE_BETWEEN_LABEL_AND_INPUT);
        content.add(password);

        sendLogin = new RoundJButton();
        sendLogin.setText("Login");
        sendLogin.setSize(WIDTH, HEIGTH_INPUT);
        sendLogin.setLocation(AXIS_X, password.getY() + DIFERENCE_BETWEEN_COMPONENTS_AND_BUTTON);
        sendLogin.setOpaque(false);
        sendLogin.setFocusPainted(false);
        sendLogin.setBorderPainted(false);
        sendLogin.setContentAreaFilled(false);
        sendLogin.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

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
        content.add(sendLogin);

        add(content);
        setVisible(true);
    }

//    public static void loadInformation() {
//        System.out.println(Initialize.isRunning());
//        System.out.println(Initialize.isRunning() == 1);
//        try {
//            while (Initialize.isRunning() == 1) {
//                GPURepository.insert(new GPUModel());
//                CPURepository.insert(new CPUModel());
//                RAMRepository.insert(new RAMModel());
//                SORepository.insert(new SOModel());
//                HDRepository.insert(new HDModel());
//            }
//            Thread.sleep(Initialize.selectInterval());
//        } catch (InterruptedException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
