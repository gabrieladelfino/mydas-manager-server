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
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
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

    static JFrame components;
    static JPanel p;

    public Graphics(int deviceid) {

        setSize(1200, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        this.getContentPane().setBackground(Colors.LIGTH_GRAY);
        setVisible(true);

        components = this;
        components.add(getData(deviceid));

        loadInformation(deviceid);
    }

    public static JPanel getData(int deviceid) {

        System.out.println("getData: " + deviceid);

        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        List<Double> r = HDRepository.selectBytesRead(deviceid);

        System.out.println("Tamanho dos dados: " + r.size());

        for (int i = 0; i < r.size(); i++) {
            ds.addValue(r.get(i), "máximo", i + "");
        }

        JFreeChart grafico = ChartFactory.createLineChart("Memória RAM disponivel", "Minuto",
                "Valor", ds, PlotOrientation.VERTICAL, true, true, false);

        p = new ChartPanel(grafico);
        p.setSize(components.getWidth(), components.getHeight());
        p.setLocation(0, 0);

        return p;
    }

    public static void loadInformation(int deviceid) {

        LoadInformation task = new LoadInformation(deviceid);
        System.out.println("Processando a tarefa ...");

        Future<Boolean> future = threadpool.submit(task);

        for (;;) {
            try {
                System.out.println("A tarefa ainda não foi processada!");
                components.remove(p);
                components.add(getData(deviceid));
                Thread.sleep(Initialize.selectInterval(deviceid));
            } catch (InterruptedException ex) {
                Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static final ExecutorService threadpool = Executors.newFixedThreadPool(3);

    private static class LoadInformation implements Callable<Boolean> {

        private int deviceid;

        public LoadInformation(int deviceid) {
            this.deviceid = deviceid;
        }

        @Override
        public Boolean call() {
            RAMRepository.insert(new RAMModel(), deviceid);
            CPURepository.insert(new CPUModel(), deviceid);
            GPURepository.insert(new GPUModel(), deviceid);
            HDRepository.insert(new HDModel(), deviceid);
            return true;
        }
    }
    
    //threadpool.shutdown();
}
