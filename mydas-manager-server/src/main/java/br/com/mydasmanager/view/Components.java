package br.com.mydasmanager.view;

import br.com.mydasmanager.controller.Initialize;
import br.com.mydasmanager.data.repository.CPURepository;
import br.com.mydasmanager.data.repository.CustomerRepository;
import br.com.mydasmanager.data.repository.GPURepository;
import br.com.mydasmanager.data.repository.HDRepository;
import br.com.mydasmanager.data.repository.RAMRepository;
import br.com.mydasmanager.data.repository.SORepository;
import br.com.mydasmanager.model.CPUModel;
import br.com.mydasmanager.model.GPUModel;
import br.com.mydasmanager.model.HDModel;
import br.com.mydasmanager.model.RAMModel;
import br.com.mydasmanager.model.SOModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

    JPanel components;
    static int id;

    public Components(int customerid) {

        setUndecorated(true);
        setSize(600, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        this.getContentPane().setBackground(Colors.WHITE);

        components = new JPanel();
        components = new GradientPanel(Colors.BLACK, Colors.MEDIUM_BLACK);
        components.setSize(500, 550);
        components.setLocation(0, 0);
        components.setLayout(null);
        //add(getData());

        setVisible(true);
        getDevicesByCustomer(id);
    }

    public JPanel getData() {

        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        List<Double> r = RAMRepository.selectFreeMemory();

        System.out.println(r.size());

        for (int i = 0; i < r.size(); i++) {
            ds.addValue(r.get(i), "máximo", i + "");
        }

        JFreeChart grafico = ChartFactory.createLineChart("Memório RAM disponivel", "Minuto",
                "Valor", ds, PlotOrientation.VERTICAL, true, true, false);

        JPanel p = new ChartPanel(grafico);
        p.setSize(getWidth(), getHeight());
        p.setLocation(0, 0);

        return p;
    }

    public static void loadInformation(int customerid, int deviceid) {

        id = Initialize.selectCustomerDeviceId(customerid, deviceid);

        try {

            Thread.sleep(Initialize.selectInterval(id));

            for (;;) {
                GPURepository.insert(new GPUModel(), id);
                CPURepository.insert(new CPUModel(), id);
                RAMRepository.insert(new RAMModel(), id);
                SORepository.insert(new SOModel(), id);
                HDRepository.insert(new HDModel(), id);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Components.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getDevicesByCustomer(int id) {
        List<String> devices = CustomerRepository.selectDevice(id);
        System.out.println("Entrou: "+CustomerRepository.selectDevice(id).size());

        for (int i = 0; i < devices.size(); i++) {
            System.out.println("Device " + i + ": " + devices.get(i));
        }
    }
}
