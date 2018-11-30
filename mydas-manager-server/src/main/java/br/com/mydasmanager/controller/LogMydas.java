package br.com.mydasmanager.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class LogMydas {
    
   
    String caminhoDoArquivo = "C:\\Users\\eduardo.brentan\\Desktop\\log\\Mydas";
    File arquivo;
    FileReader fileReader;
    BufferedReader bufferedReader;
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    
   
    File arq;
  
    String time = new SimpleDateFormat("MM-YYYY").format(Calendar.getInstance().getTime());
    String timeStamp = new SimpleDateFormat("dd-MM-yyyy__HH.mm").format(Calendar.getInstance().getTime());
      
      
      public void log(String log) throws IOException {
        
        
        //objeto que insere a data no nome do arquivo txt, isso irá mudar o arquivo
        //de acordo com o dia
       String dataArq = new SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date());     


        //cria o arquivo txt, escreve e grava(close).
        
         
        BufferedWriter writer = new BufferedWriter(new FileWriter( "log - " + dataArq +".txt", true));
        writer.write(log);
        writer.close();     

    }
      
      //Você terá que instanciar isso aqui nas classes que você quer pegar o log:
   

    //public log arq = new arquivoLog();//
    //String quebraLinha = System.getProperty("line.separator");//quebra linha
    //Date dataHoraAtual = new Date();//intancia um obj data e hr 
    //String data2 = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);//dois objetos inseridos no log
    //String hora2 = new SimpleDateFormat(" HH:mm:ss").format(dataHoraAtual);

      //Exemplo de como você deve chamar o método em outra classe:
     //arq.log(quebraLinha + data2 + hora2 + ""+ex);
    
}

