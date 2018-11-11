package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.RAMModel;
import br.com.mydasmanager.mydas.data.RAMRepository;
import java.sql.SQLException;

public class RAM {

    public static void insert() throws SQLException {
        RAMModel m = new RAMModel();
        RAMRepository.insert(m);
    }
}
