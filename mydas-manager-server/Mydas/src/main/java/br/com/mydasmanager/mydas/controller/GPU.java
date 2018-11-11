package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.data.GPURepository;
import br.com.mydasmanager.mydas.model.GPUModel;
import java.sql.SQLException;

public class GPU {
    
    public static void insert() throws SQLException {
        GPUModel m = new GPUModel();
        GPURepository.insert(m);
    }
}
