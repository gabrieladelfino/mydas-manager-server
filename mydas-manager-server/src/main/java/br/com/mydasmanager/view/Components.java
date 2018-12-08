package br.com.mydasmanager.view;

import br.com.mydasmanager.controller.Initialize;
import br.com.mydasmanager.data.repository.CPURepository;
import br.com.mydasmanager.data.repository.DeviceRepository;
import br.com.mydasmanager.data.repository.GPURepository;
import br.com.mydasmanager.data.repository.HDRepository;
import br.com.mydasmanager.data.repository.RAMRepository;
import br.com.mydasmanager.model.CPUModel;
import br.com.mydasmanager.model.DeviceModel;
import br.com.mydasmanager.model.GPUModel;
import br.com.mydasmanager.model.HDModel;
import br.com.mydasmanager.model.RAMModel;
import static br.com.mydasmanager.view.Graphics.panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    /**
     *
     * @param customerid
     */
    public Components(int customerid) {

        setSize(1200, 500);
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

        panel = new JPanel();
        panel.setSize(getWidth(), getHeight());
        panel.setOpaque(false);
        panel.setSize((getWidth() / 100) * 50, (getHeight() / 100) * 50);
        panel.setLocation((getWidth() / 100) * 25, line.getY() + 50);
        panel.setLayout(null);
        components.add(panel);

        setVisible(true);
        getDevicesByCustomer(customerid);
        loadInformation(100);
    }

    private void getDevicesByCustomer(int customerid) {

        devices = DeviceRepository.selectDevices(customerid);

        for (int i = 0; i < devices.size(); i++) {

            int deviceid = devices.get(i).getId();

            JLabel machine = new JLabel(devices.get(i).getMachineName());
            machine.setBackground(Colors.WHITE);
            machine.setOpaque(true);
            machine.setHorizontalAlignment(SwingConstants.CENTER);
            machine.setVerticalAlignment(SwingConstants.CENTER);
            machine.setSize(150, 60);
            if (i == 0) {
                machine.setLocation(10, 10);
            } else {
                machine.setLocation((panel.getComponent(i - 1).getX() + machine.getWidth()) + 30, 10);
            }
            machine.setOpaque(true);
            machine.addMouseListener(new MouseListener() {
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

            panel.add(machine);
        }
    }

    public static void loadInformation(int deviceid) {
        while (true) {
            try {
                Thread.sleep(Initialize.selectInterval(deviceid));

                RAMRepository.insert(new RAMModel(), deviceid);
                CPURepository.insert(new CPUModel(), deviceid);
                GPURepository.insert(new GPUModel(), deviceid);
                HDRepository.insert(new HDModel(), deviceid);
            } catch (InterruptedException ex) {
                Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
