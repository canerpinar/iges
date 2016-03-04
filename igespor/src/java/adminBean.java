
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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

    public Haberler getHaberler() {
        return haberler;
    }

    public void setHaberler(Haberler haberler) {
        this.haberler = haberler;
    }
    
    public void saveHaber(){
        DAO dao=new DAO();
        SimpleDateFormat bicim=new SimpleDateFormat("dd/M/yyyy");
        Date tarih=new Date();
        haberler.setTarih(bicim.format(tarih));        
        dao.saveHaber(haberler.getBaslik(), haberler.getIcerik(), haberler.getResimPath(),haberler.getTarih());
        haberler=new Haberler();
    }
}
