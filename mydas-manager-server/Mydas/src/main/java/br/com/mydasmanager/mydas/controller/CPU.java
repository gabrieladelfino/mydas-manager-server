package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.data.CPURepository;
import br.com.mydasmanager.mydas.model.CPUModel;
import java.sql.SQLException;

public class CPU {

    public static void insert() throws SQLException {
        CPUModel m = new CPUModel();
        CPURepository.insert(m);
    }
}
