package br.com.mydasmanager.view;

import br.com.mydasmanager.data.repository.DeviceRepository;
import br.com.mydasmanager.model.DeviceModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.BorderFactory;
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
        panel.setSize((getWidth() / 100) * 50, (getHeight()/100)*50);
        panel.setLocation((getWidth() / 100) * 25, line.getY() + 50);
        panel.setLayout(null);
        components.add(panel);
        
        setVisible(true);
        getDevicesByCustomer(customerid);
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
                machine.setLocation((panel.getComponent(i - 1).getX() + machine.getWidth())+30, 10);
            }
            machine.setOpaque(true);
            machine.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    dispose();
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
}
