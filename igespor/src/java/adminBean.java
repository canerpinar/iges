
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import pck.DB.DAO;
import pck.Entity.Haberler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caner
 */
@ManagedBean
@RequestScoped
public class adminBean {
    private Haberler haberler=new Haberler();
    private Part file;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    
    public Haberler getHaberler() {
        return haberler;
    }

    public void setHaberler(Haberler haberler) {
        this.haberler = haberler;
    }
    
    public void upload(){
         InputStream inputStream = null;
         String realPath=FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
         File folder=new File(realPath+haberler.getResimPath());
         folder.canWrite();
         folder.canExecute();
         folder.setWritable(true);
         folder.setExecutable(true);
         folder.setReadable(true);
         folder.mkdir();
         realPath=realPath+(haberler.getResimPath()+"/main.jpg");
         
        try {
            inputStream = file.getInputStream();
             try (FileOutputStream outputStream = new FileOutputStream(realPath)) {
                 byte[] buffer = new byte[4096];
                 int bytesRead = 0;
                 while(true) {
                     bytesRead = inputStream.read(buffer);
                     if(bytesRead > 0) {
                         outputStream.write(buffer, 0, bytesRead);
                     }else {
                         break;
                     }
                 }}
            inputStream.close();
            
        } catch (IOException ex) {
            Logger.getLogger(adminBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(adminBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
  
    
    }
    public void saveHaber(){
        DAO dao=new DAO();
        SimpleDateFormat bicim=new SimpleDateFormat("dd/M/yyyy");
        Date tarih=new Date();
        haberler.setTarih(bicim.format(tarih));        
        dao.saveHaber(haberler.getBaslik(), haberler.getIcerik(), haberler.getResimPath(),haberler.getTarih(),haberler.getMainResim());
        haberler=new Haberler();
    }
}
