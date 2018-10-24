package br.com.mydasmanager.mydas.model;

import java.sql.Date;

public class SO {
    
    private String nameSystem;
    private String systemVersion;
    private String nameUser;
    private Date dateCapture;

    public String getNameSystem() {
        return nameSystem;
    }

    public void setNameSystem(String nameSystem) {
        this.nameSystem = nameSystem;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Date getDateCapture() {
        return dateCapture;
    }

    public void setDateCapture(Date dateCapture) {
        this.dateCapture = dateCapture;
    }
    
    
}