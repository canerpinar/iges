/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pck.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author caner
 */
@ManagedBean(name = "iletisimBean")
@SessionScoped
public class iletisimBean {
    private String ad,soyad,email,baslik,aciklama;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
    
    private String alertMessage;

    public String getAlertMessage() {
        return alertMessage;
        
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }
      
    public String save(){
        
        try {
            /*
            InitialContext initialContext=new InitialContext();
            Context context=(Context) initialContext.lookup("java:comp/env");
            DataSource dataSource=(DataSource) context.lookup("jdbc/Test");
            Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement("insert into istekler(ad,soyad,email,baslik,aciklama) values(?,?,?,?,?)");            
            statement.setString(1, ad);
            statement.setString(2, soyad);
            statement.setString(3, email);
            statement.setString(4, baslik);
            statement.setString(5, aciklama);
            statement.execute();
            connection.close();
            */        
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/igesDB?useUnicode=true&characterEncoding=utf-8","root","3772391Caner%");
            PreparedStatement statement=connection.prepareStatement("insert into istekler(ad,soyad,email,baslik,aciklama) values(?,?,?,?,?)");
            statement.setString(1, ad);
            statement.setString(2, soyad);
            statement.setString(3, email);
            statement.setString(4, baslik);
            statement.setString(5, aciklama);
            statement.execute();
            connection.close();
                    
            ad="";
            soyad="";
            email="";
            baslik="";
            aciklama="";
                alertMessage="Kaydınız başarıyla alınmıştır.";                
                        
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(iletisimBean.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return "faces/iletisim.xhtml?faces-redirect=true";
    }
  


}
