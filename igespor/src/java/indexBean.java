
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
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
@ManagedBean(name = "indexBean")
@RequestScoped
public class indexBean {
    
    private List<Haberler> listHaberler;

    public List<Haberler> getListHaberler() {
        return listHaberler;
    }

    public void setListHaberler(List<Haberler> listHaberler) {
        this.listHaberler = listHaberler;
    }
    
    public String getHaberLink(Haberler haber){        
        return "/faces/haberler.xhtml?faces-redirect=true"+"&link="+haber.getLink();
    }
    
    @PostConstruct
    public void init(){
        DAO dao=new DAO();
        listHaberler=dao.getHaberler();
        dao.closeDB();                
    }
    
}
