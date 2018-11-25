package br.com.mydasmanager.view;

import br.com.mydasmanager.data.repository.DeviceRepository;
import br.com.mydasmanager.model.DeviceModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Gabriela Garcia
 */
public class Components extends JFrame {

    /**
     * Estrutural components
     */
    JPanel components;
    JButton machine;
    JPanel panel;
    JScrollPane scroll;
    List<DeviceModel> devices;


    /**
     *
     * @param customerid
     */
    public Components(int customerid) {

        setSize(1200, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        this.getContentPane().setBackground(Colors.WHITE);

        components = new JPanel();
        components.setSize(getWidth(), getHeight());
        components.setLocation(0, 0);
        components.setLayout(null);
        add(components);

        panel = new JPanel();
        panel.setLocation(10, 10);
        panel.setSize(300, 300);
        panel.setOpaque(true);
        panel.setPreferredSize(new Dimension(300, 300));

        scroll = new JScrollPane(panel);
        scroll.setSize(300, 300);
        scroll.setOpaque(false);
        scroll.setLocation(0, 0);
        components.add(scroll, BorderLayout.CENTER);

        setVisible(true);

        getDevicesByCustomer(customerid);
    }

    private void getDevicesByCustomer(int customerid) {

        devices = DeviceRepository.selectDevices(customerid);

        for (int i = 0; i < devices.size(); i++) {
            
            int deviceid = devices.get(i).getId();
            
            machine = new JButton(devices.get(i).getMachineName());
            machine.setBackground(Colors.PALE_VIOLET_RED);
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
