/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import pck.DB.DAO;

/**
 *
 * @author caner
 */
@ManagedBean(name = "iletisimBean")
@SessionScoped
public class iletisimBean {
    private String ad,soyad,email,baslik,aciklama,securitCode,securityControl;

    public String getSecurityControl() {
        return securityControl;
    }

    public void setSecurityControl(String securityControl) {
        this.securityControl = securityControl;
    }

    public String getSecuritCode() {
        return securitCode;
    }

    public void setSecuritCode(String securitCode) {
        this.securitCode = securitCode;
    }

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
      
    
    @PostConstruct
    public void init(){
        securitCode="";//kodu boşalt yeni üret
        securityCode();
       
    }
    
    public String save(){  
            if(!FacesContext.getCurrentInstance().isPostback()){
                FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            }
            else
            {
                alertMessage="";
            }
            
            if(securitCode.equals(securityControl)){
                DAO dao=new DAO();
                dao.saveIletisim(ad, soyad, email, baslik, aciklama);
                dao.closeDB();                        
                ad="";
                soyad="";
                email="";
                baslik="";
                aciklama="";
                securityControl="";
                alertMessage="Kayıt işlemi başarıyla gerçekleşti";
                return "faces/iletisim.xhtml?faces-redirect=true";
            }else{
                FacesContext.getCurrentInstance().addMessage("iletisimForm:guvenlik", new FacesMessage("Güvenlik Kodu Yanlış"));
            }
                   
        return "";
    }
  

    public String securityCode(){
        String deger="";
        char[] character={'a','b','c','d','e','f','g','h','ı','i','j','k','l','m','n','o','ö','p','r','s','ş','t','u','ü'
        ,'v','y','z','x'
        };
        Random rnd = new Random();
        
        
        for(int s=0;s<6;s++){
           deger=deger.concat(String.valueOf(character[rnd.nextInt(27)]));
           
           if(s==2){
               
               for(int k=0;k<2;k++){
                   deger=deger.concat(String.valueOf(rnd.nextInt(10)));
               }
           }
           
           
        }
        securitCode=deger;       
        return deger;
    }

}
