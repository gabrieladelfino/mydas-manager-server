package br.com.mydasmanager.view;

import br.com.mydasmanager.controller.Initialize;
import br.com.mydasmanager.data.repository.CPURepository;
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
    JButton isBreak;
    static Thread t = new Thread();

    /**
     *
     * @param customerid
     */
    public Components(int customerid) {

        setSize(500, 500);
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

        customerName = new JLabel("Fulano");
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

        lbl = new JButton("Clique aqui para iniciar");
        lbl.setSize(300, 20);
        lbl.setLocation(100, line.getY() + 50);
        lbl.setForeground(Colors.WHITE);
        lbl.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbl.setText("Capturando dados...");
                new Modal("Vamos iniciar", "estamos capturando os dados da máquina, você pode parar a qualquer momento clicando em interromper");
                loadInformation(101);
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

        isBreak = new JButton("Interromper");
        isBreak.setSize(300, 20);
        isBreak.setLocation(100, lbl.getY() + 30);
        isBreak.setForeground(Colors.WHITE);
        isBreak.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Clicou");
                t.stop();
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
        components.add(isBreak);

        setVisible(true);
    }

    public static void loadInformation(int deviceid) {
        while (true) {
            try {
                System.out.println("Terminou");
                RAMRepository.insert(new RAMModel(), deviceid);
                CPURepository.insert(new CPUModel(), deviceid);
                GPURepository.insert(new GPUModel(), deviceid);
                HDRepository.insert(new HDModel(), deviceid);
                t.sleep(Initialize.selectInterval(deviceid));
            } catch (InterruptedException ex) {
                Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
