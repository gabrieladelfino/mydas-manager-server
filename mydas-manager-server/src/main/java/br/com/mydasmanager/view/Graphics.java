/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mydasmanager.view;

import br.com.mydasmanager.controller.Initialize;
import br.com.mydasmanager.data.repository.CPURepository;
import br.com.mydasmanager.data.repository.GPURepository;
import br.com.mydasmanager.data.repository.HDRepository;
import br.com.mydasmanager.data.repository.RAMRepository;
import br.com.mydasmanager.model.CPUModel;
import br.com.mydasmanager.model.GPUModel;
import br.com.mydasmanager.model.HDModel;
import br.com.mydasmanager.model.RAMModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

    static JPanel panel;
    static JPanel p;
    static DefaultListModel model;
    static JFrame frame;

    public Graphics(int deviceid) {

        setSize(1200, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        this.getContentPane().setBackground(Colors.LIGTH_GRAY);

        panel = new JPanel();
        panel.setLocation(10, 10);
        panel.setSize(getWidth(), getHeight());
        panel.setOpaque(true);
        panel.setPreferredSize(new Dimension(300, 300));

        panel.add(getData(deviceid, panel.getWidth(), panel.getHeight()));

        add(panel);

        frame = this;

        setVisible(true);
        loadInformation(deviceid);
    }

    public static JPanel getData(int deviceid, int width, int heigth) {

        System.out.println("Desenhando gráfico");

        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        List<Double> r = HDRepository.selectBytesRead(deviceid);

        System.out.println("Quantidade de dados: " + r.size());

        for (int i = 0; i < r.size(); i++) {
            ds.addValue(r.get(i), "máximo", i + "");
        }

        JFreeChart grafico = ChartFactory.createLineChart("Memória RAM disponivel", "Minuto",
                "Valor", ds, PlotOrientation.VERTICAL, true, true, false);

        p = new ChartPanel(grafico);
        p.setSize(width, heigth);
        p.setLocation(0, 0);

        return p;
    }

    public void loadInformation(int deviceid) {
        while (true) {
            try {

                Thread.sleep(Initialize.selectInterval(deviceid));

                RAMRepository.insert(new RAMModel(), deviceid);
                CPURepository.insert(new CPUModel(), deviceid);
                GPURepository.insert(new GPUModel(), deviceid);
                HDRepository.insert(new HDModel(), deviceid);

                System.out.println("Executou");
            } catch (InterruptedException ex) {
                Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
            }

            panel.remove(p);
            panel.add(getData(deviceid, panel.getWidth(), panel.getHeight()));
            panel.revalidate();
            panel.repaint();
        }
    }
}