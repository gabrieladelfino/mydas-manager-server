package br.com.mydasmanager.view;

import br.com.mydasmanager.controller.Initialize;
import br.com.mydasmanager.data.repository.CPURepository;
import br.com.mydasmanager.data.repository.CustomerRepository;
import br.com.mydasmanager.data.repository.GPURepository;
import br.com.mydasmanager.data.repository.HDRepository;
import br.com.mydasmanager.data.repository.RAMRepository;
import br.com.mydasmanager.model.CPUModel;
import br.com.mydasmanager.model.DeviceModel;
import br.com.mydasmanager.model.GPUModel;
import br.com.mydasmanager.model.HDModel;
import br.com.mydasmanager.model.RAMModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Gabriela Garcia
 */
public class Components extends JFrame {

    /**
     * Estrutural components
     */
    JPanel components;
    JPanel panel;
    JScrollPane scroll;
    List<DeviceModel> devices;
    JLabel customerName;
    JLabel line;
    JButton lbl;
    JButton graphics;

    /**
     *
     * @param customerid
     * @param deviceid
     */
    public Components(int customerid, int deviceid) {

        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        this.getContentPane().setBackground(Colors.MEDIUM_BLACK);

        components = new JPanel();
        components.setSize(getWidth(), getHeight());
        components.setLocation(0, 0);
        components.setLayout(null);
        components.setBackground(Colors.MEDIUM_BLACK);
        add(components);

        customerName = new JLabel("Bem vindo(a) " + CustomerRepository.getName(customerid));
        customerName.setSize(getWidth(), (getHeight() / 100) * 10);
        customerName.setLocation(0, 0);
        customerName.setOpaque(false);
        customerName.setForeground(Colors.WHITE);
        customerName.setHorizontalAlignment(SwingConstants.CENTER);
        customerName.setVerticalAlignment(SwingConstants.CENTER);
        components.add(customerName);

        line = new JLabel();
        line.setSize((getWidth() / 100) * 25, 2);
        line.setLocation(((getWidth() / 100) * 37), customerName.getHeight());
        line.setOpaque(true);
        line.setBackground(Colors.PALE_VIOLET_RED);
        components.add(line);

        lbl = new RoundJButton();
        lbl.setText("Clique aqui para iniciar");
        lbl.setSize(300, 30);
        lbl.setLocation(100, line.getY() + 100);
        lbl.setForeground(Colors.WHITE);
        lbl.setBackground(Colors.MEDIUM_VIOLET_RED);
        lbl.setForeground(Colors.WHITE);
        lbl.setOpaque(false);
        lbl.setFocusPainted(false);
        lbl.setBorderPainted(false);
        lbl.setContentAreaFilled(false);
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        lbl.setVerticalAlignment(SwingConstants.CENTER);
        lbl.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbl.setText("Capturando dados...");
                lbl.setBackground(Colors.BLACK);
                new Modal("Iniciando...", "relaxa, vamos guardar todas as informações");
                loadInformation(deviceid);
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
        components.add(lbl);
        
        graphics = new RoundJButton();
        graphics.setText("Visualizar dados");
        graphics.setSize(300, 30);
        graphics.setLocation(100, lbl.getY() + 50);
        graphics.setForeground(Colors.WHITE);
        graphics.setBackground(Colors.MEDIUM_VIOLET_RED);
        graphics.setForeground(Colors.WHITE);
        graphics.setOpaque(false);
        graphics.setFocusPainted(false);
        graphics.setBorderPainted(false);
        graphics.setContentAreaFilled(false);
        graphics.setHorizontalAlignment(SwingConstants.CENTER);
        graphics.setVerticalAlignment(SwingConstants.CENTER);
        graphics.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Graphics(deviceid);
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
        components.add(graphics);

        setVisible(true);
    }

    public static void loadInformation(int deviceid) {
        while (true) {
            try {
                RAMRepository.insert(new RAMModel(), deviceid);
                CPURepository.insert(new CPUModel(), deviceid);
                GPURepository.insert(new GPUModel(), deviceid);
                HDRepository.insert(new HDModel(), deviceid);
                Thread.sleep(Initialize.selectInterval(deviceid));
            } catch (InterruptedException ex) {
                Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
