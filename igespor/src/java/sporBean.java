
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.jsp.PageContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caner
 */
@ManagedBean(name = "sporBean")
@SessionScoped
public class sporBean implements Serializable{
    
    
    String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }
    
    
    
    public String getContent(int sporDali)//dosya içindeki içerikleri okuması için deger döndürmek gerekir.
    {
                    FacesContext context = FacesContext.getCurrentInstance();
                    String realPath=context.getExternalContext().getRealPath("/");   
                    String content;
            
            switch(sporDali){
            
            case 1:
            {                    
                     try {
                         content = new String(Files.readAllBytes(Paths.get(realPath+"resources/golbol.txt")));
                         return content;
                     } catch (IOException ex) {
                         Logger.getLogger(sporBean.class.getName()).log(Level.SEVERE, null, ex);
                     }  
            }
            
            case 2:
            {                    
                     try {
                         content = new String(Files.readAllBytes(Paths.get(realPath+"resources/yuzme.txt")));
                         return content;
                     } catch (IOException ex) {
                         Logger.getLogger(sporBean.class.getName()).log(Level.SEVERE, null, ex);
                     }  
            }
            
            case 3:
            {                    
                     try {
                         content = new String(Files.readAllBytes(Paths.get(realPath+"resources/satranc.txt")));
                         return content;
                     } catch (IOException ex) {
                         Logger.getLogger(sporBean.class.getName()).log(Level.SEVERE, null, ex);
                     }  
            }
                        
            case 4:
            {                    
                     try {
                         content = new String(Files.readAllBytes(Paths.get(realPath+"resources/futsa.txt")));
                         return content;
                     } catch (IOException ex) {
                         Logger.getLogger(sporBean.class.getName()).log(Level.SEVERE, null, ex);
                     }  
            }
                                    
            case 5:
            {                    
                     try {
                         content = new String(Files.readAllBytes(Paths.get(realPath+"resources/futsa.txt")));
                         return content;
                     } catch (IOException ex) {
                         Logger.getLogger(sporBean.class.getName()).log(Level.SEVERE, null, ex);
                     }  
            }                        

        }
       return ""; 
        
    }
    
    
    public String sporDali(int isim){
                      
                     if(isim==1){
                         Content=getContent(1);
                         return "/faces/spor.xhtml?faces-redirect=true&spor=GOLBOL";
                     }else if(isim==2){
                         Content=getContent(2);
                         return "/faces/spor.xhtml?faces-redirect=true&spor=YUZME";                         
                     }else if(isim==3){
                         Content=getContent(3);
                         return "/faces/spor.xhtml?faces-redirect=true&spor=SATRANC";                         
                     }else if(isim==4){
                         Content=getContent(4);
                         return "/faces/spor.xhtml?faces-redirect=true&spor=FUTSA";                         
                     }else if(isim==5){
                         Content=getContent(5);
                         return "/faces/spor.xhtml?faces-redirect=true&spor=JUDO";                         
                     }else if(isim==6){
                         Content=getContent(1);
                         return "/faces/spor.xhtml?faces-redirect=true&spor=DIGER";                         
                     }else
                     {
                         return null;
                     }                    
    }
}
