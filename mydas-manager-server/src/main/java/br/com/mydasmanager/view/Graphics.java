/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mydasmanager.view;

import br.com.mydasmanager.controller.Initialize;
import br.com.mydasmanager.data.repository.CPURepository;
import br.com.mydasmanager.data.repository.DeviceRepository;
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
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Gabriela Garcia
 */
public class Graphics extends JFrame {

    JPanel components;

    public Graphics(int deviceid) {
        setSize(1200, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        this.getContentPane().setBackground(Colors.WHITE);

        components = new GradientPanel(Colors.BLACK, Colors.MEDIUM_BLACK);
        components.setSize(getWidth(), getHeight());
        components.setLocation(0, 0);
        components.setLayout(null);
        
        add(getData(deviceid));

        setVisible(true);

//        loadInformation(deviceid);
    }

    public JPanel getData(int deviceid) {

        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        List<Double> r = RAMRepository.selectFreeMemory(deviceid);

        for (int i = 0; i < r.size(); i++) {
            ds.addValue(r.get(i), "máximo", i + "");
        }

        JFreeChart grafico = ChartFactory.createLineChart("Memória RAM disponivel", "Minuto",
                "Valor", ds, PlotOrientation.VERTICAL, true, true, false);

        JPanel p = new ChartPanel(grafico);
        p.setSize(components.getWidth(), components.getHeight());
        p.setLocation(0, 0);

        return p;
    }

    public static void loadInformation(int deviceid) {

        try {
            Thread.sleep(Initialize.selectInterval(deviceid));

            for (;;) {
                GPURepository.insert(new GPUModel(), deviceid);
                CPURepository.insert(new CPUModel(), deviceid);
                RAMRepository.insert(new RAMModel(), deviceid);
                SORepository.insert(new SOModel(), deviceid);
                HDRepository.insert(new HDModel(), deviceid);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Components.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
