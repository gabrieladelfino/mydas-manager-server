package br.com.mydasmanager.view;

import br.com.mydasmanager.data.repository.CustomerRepository;
import br.com.mydasmanager.model.Customer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
    JLabel labelPassword;
    JLabel labelHasACode;
    JLabel labelCode;
    JLabel logo;
    public static JPanel hide;

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
    private static final int AXIS_Y = 220;
    private static final int WIDTH_COMPONENT = 220;
    private static final int HEIGHT_LABEL = 25;
    private static final int HEIGHT_INPUT = 30;
    private static final int DIFERENCE_BETWEEN_LABEL_AND_INPUT = HEIGHT_INPUT;
    private static final int DIFERENCE_BETWEEN_COMPONENTS = HEIGHT_INPUT + 20;
    private static final int DIFERENCE_COMPONENTS_AND_BUTTON = HEIGHT_INPUT + 30;

    /**
     * Notices
     */
    private static final String MESSAGE = "os campos não foram preenchidos corretamente";
    private static final String TITLE = "Não conseguimos efetuar o login";

    public Login() {

        setUndecorated(true);
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        this.getContentPane().setBackground(Colors.WHITE);

        logo = new DrawLogo();
        logo.setSize(200, 100);
        logo.setLocation(120, 80);

        close = new JLabel();
        close.setBounds(450, 20, 32, 32);
        close.setOpaque(false);
        close.setIcon(new ImageIcon("img/menu-bar/close-white.png"));
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
        minimize.setIcon(new ImageIcon("img/menu-bar/minimize-line-white.png"));
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
        sendLogin.setSize(WIDTH_COMPONENT, HEIGHT_INPUT);
        sendLogin.setOpaque(false);
        sendLogin.setFocusPainted(false);
        sendLogin.setBorderPainted(false);
        sendLogin.setContentAreaFilled(false);

        hide = new JPanel();
        hide.setBounds(0, 0, getWidth(), getHeight());
        hide.setBackground(Colors.LIGTH_OPACITY);
        hide.setVisible(false);
        add(hide);

        initializeLogin();
        setVisible(true);
    }

    private void initializeLogin() {

        contentLogin = new GradientPanel(Colors.BLACK, Colors.MEDIUM_BLACK);
        contentLogin.setSize(500, 550);
        contentLogin.setLocation(0, 0);
        contentLogin.setLayout(null);

        contentLogin.add(close);
        contentLogin.add(minimize);

        labelLogin = new JLabel("Email ou login");
        labelLogin.setForeground(Colors.WHITE);
        labelLogin.setSize(WIDTH_COMPONENT, HEIGHT_LABEL);
        labelLogin.setLocation(AXIS_X, AXIS_Y);
        contentLogin.add(labelLogin);

        login = new RoundJTextField();
        login.setSize(WIDTH_COMPONENT, HEIGHT_INPUT);
        login.setLocation(AXIS_X, labelLogin.getY() + DIFERENCE_BETWEEN_LABEL_AND_INPUT);
        login.setBorder(null);
        login.setHorizontalAlignment(SwingConstants.CENTER);
        login.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                patternFields(login);
            }
        });
        contentLogin.add(login);

        labelPassword = new JLabel("Senha");
        labelPassword.setForeground(Colors.WHITE);
        labelPassword.setSize(WIDTH_COMPONENT, HEIGHT_LABEL);
        labelPassword.setLocation(AXIS_X, login.getY() + DIFERENCE_BETWEEN_COMPONENTS);
        contentLogin.add(labelPassword);

        password = new RoundJPasswordField();
        password.setSize(WIDTH_COMPONENT, HEIGHT_INPUT);
        password.setLocation(AXIS_X, labelPassword.getY() + DIFERENCE_BETWEEN_LABEL_AND_INPUT);
        password.setHorizontalAlignment(SwingConstants.CENTER);
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

        labelHasACode = new JLabel("Eu tenho um código");
        labelHasACode.setForeground(Colors.WHITE);
        labelHasACode.setSize(WIDTH_COMPONENT, HEIGHT_LABEL);
        labelHasACode.setLocation(AXIS_X, sendLogin.getY() + labelHasACode.getHeight() + 10);
        labelHasACode.addMouseListener(new MouseListener() {
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
        contentLogin.add(labelHasACode);

        contentLogin.add(logo);
        add(contentLogin);
    }

    /**
     * Graphics interfaces to application
     */
    private void initilizeHasCode() {

        hideContentLogin();

        contentHasCode = new GradientPanel(Colors.BLACK, Colors.MEDIUM_BLACK);
        contentHasCode.setSize(500, 550);
        contentHasCode.setLocation(0, 0);
        contentHasCode.setLayout(null);

        contentHasCode.add(close);
        contentHasCode.add(minimize);

        labelCode = new JLabel("Código de acesso");
        labelCode.setForeground(Colors.WHITE);
        labelCode.setSize(WIDTH_COMPONENT, HEIGHT_LABEL);
        labelCode.setLocation(AXIS_X, AXIS_Y);
        contentHasCode.add(labelCode);

        code = new RoundJTextField();
        code.setSize(WIDTH_COMPONENT, HEIGHT_INPUT);
        code.setLocation(AXIS_X, labelCode.getY() + DIFERENCE_BETWEEN_LABEL_AND_INPUT);
        code.setBorder(null);
        code.setHorizontalAlignment(SwingConstants.CENTER);
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

        contentHasCode.add(logo);
        add(contentHasCode);
    }

    /**
     * Controller hide and show components
     */
    private void hideContentLogin() {
        contentLogin.setVisible(false);
    }

    private void hideContentHasCode() {
        contentHasCode.setVisible(false);
    }

    /**
     * Controller acess to application
     */
    private void verifyLogin() {
        if (verifyFields(login.getText()) && verifyFields(password.getText())) {

            Customer customer = new Customer();
            customer.setUserName(login.getText());
            customer.setPassword(password.getText());

            if (CustomerRepository.verifyLogin(customer) != 0) {
                System.out.println("ID: "+CustomerRepository.verifyLogin(customer));
                dispose();
                new Components(CustomerRepository.verifyLogin(customer));
            }
        } else {
            new Modal(TITLE, MESSAGE);
        }
    }

    private void verifyHasCode() {
        if (verifyFields(code.getText())) {

            Customer customer = new Customer();
            customer.setCodeAcess(code.getText());

            if (CustomerRepository.verifyLogin(customer) != 0) {
                dispose();
                new Components(CustomerRepository.verifyLogin(customer));
            }
        }
    }

    private boolean verifyFields(String text) {
        if (text == null) {
            return false;
        } else if (text.isEmpty()) {
            return false;
        }

        return true;
    }

    private void patternFields(JTextField field) {
        String pattern = "[^a-zA-Z0-9@.-_]";
        field.setText(field.getText().replaceAll(pattern, ""));
    }
}
