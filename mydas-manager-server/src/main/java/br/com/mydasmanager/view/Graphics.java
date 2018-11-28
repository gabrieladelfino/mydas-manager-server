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
import java.awt.Dimension;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
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
public class Graphics extends JDialog {

    static boolean isDraw = false;
    static JPanel panel;
    static JPanel p;
    static DefaultListModel model;

    public Graphics(int deviceid) {

        setModal(true);
        setSize(800, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        this.getContentPane().setBackground(Colors.WHITE);

        panel = new JPanel();
        panel.setLocation(0, 0);
        panel.setSize(getWidth(), getHeight());
        panel.setOpaque(true);
        panel.setVisible(true);
        getData(deviceid, getWidth(), getHeight());
        add(panel);

        setVisible(true);
    }

    public static void getData(int deviceid, int width, int heigth) {

        if (!isDraw) {
            DefaultCategoryDataset ds = new DefaultCategoryDataset();
            List<Double> r = HDRepository.selectBytesRead(deviceid);

            for (int i = 0; i < r.size(); i++) {
                ds.addValue(r.get(i), "máximo", i + "");
            }

            JFreeChart grafico = ChartFactory.createLineChart("Memória RAM disponivel", "Minuto",
                    "Valor", ds, PlotOrientation.VERTICAL, true, true, false);

            p = new ChartPanel(grafico);
            p.setSize(width, heigth);
            p.setLocation(0, 0);
            panel.add(p);

            isDraw = true;
            System.out.println("Executou");

        } else {
            loadInformation(deviceid);
        }
    }

    public static void loadInformation(int deviceid) {

        if (isDraw) {
            System.out.println(deviceid);

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

                isDraw = false;
                panel.remove(p);
                getData(deviceid, panel.getWidth(), panel.getHeight());
                panel.revalidate();
                panel.repaint();
            }
        }
    }
}
