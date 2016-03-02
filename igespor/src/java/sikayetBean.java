
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import pck.DB.DAO;
import pck.Entity.Istekler;

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
public class sikayetBean {
   
   List<Istekler> istekler=new ArrayList<>();

    public List<Istekler> getIstekler() {
        return istekler;
    }

    public void setIstekler(List<Istekler> istekler) {
        this.istekler = istekler;
    }
   
    @PostConstruct
    public void init(){
        DAO dao=new DAO();
        istekler=dao.getIletisimAll();
        dao.closeDB();
    }
}
