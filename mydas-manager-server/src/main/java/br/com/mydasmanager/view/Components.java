package br.com.mydasmanager.view;

import br.com.mydasmanager.controller.Initialize;
import br.com.mydasmanager.data.repository.CPURepository;
import br.com.mydasmanager.data.repository.DeviceRepository;
import br.com.mydasmanager.data.repository.GPURepository;
import br.com.mydasmanager.data.repository.HDRepository;
import br.com.mydasmanager.data.repository.RAMRepository;
import br.com.mydasmanager.data.repository.SORepository;
import br.com.mydasmanager.model.CPUModel;
import br.com.mydasmanager.model.DeviceModel;
import br.com.mydasmanager.model.GPUModel;
import br.com.mydasmanager.model.HDModel;
import br.com.mydasmanager.model.RAMModel;
import br.com.mydasmanager.model.SOModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Gabriela Garcia
 */
public class Components extends JFrame {

    /**
     * Estrutural components
     */
    DefaultListModel model = new DefaultListModel();
    JPanel components;
    JButton machine;
    JList listDevices;
    JPanel panel;
    JScrollPane scroll;
    List<DeviceModel> devices;

    /**
     * Size and location components
     */
    private static final int WIDTH_COMPONENT = 150;
    private static final int HEIGTH_COMPONENT = 30;
    private static final int AXIS_X = 20;
    private static final int AXIS_Y = 20;

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

        model.removeAllElements();
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
