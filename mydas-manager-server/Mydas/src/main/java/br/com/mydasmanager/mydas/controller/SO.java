package br.com.mydasmanager.mydas.controller;

import br.com.mydasmanager.mydas.model.SOModel;
import br.com.mydasmanager.mydas.data.SORepository;
import java.sql.SQLException;

public class SO {

    public static void insert() throws SQLException {
        SOModel m = new SOModel();
        SORepository.insert(m);
    }
}
