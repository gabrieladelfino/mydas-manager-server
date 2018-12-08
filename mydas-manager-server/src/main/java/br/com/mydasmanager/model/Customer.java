package br.com.mydasmanager.model;

/**
 *
 * @author Gabriela Garcia
 */
public class Customer {
    
    private String userName;
    private String password;
    private String codeAcess;
    
    private int id;
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeAcess() {
        return codeAcess;
    }

    public void setCodeAcess(String codeAcess) {
        this.codeAcess = codeAcess;
    }
    
}
