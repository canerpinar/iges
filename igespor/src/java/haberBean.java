
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
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
@ManagedBean(name = "haberBean")
@RequestScoped
public class haberBean {
    Haberler haber=new Haberler();
    String link;
    List<String> listFile=new ArrayList<>();

    public List<String> getListFile() {
        return listFile;
    }

    public void setListFile(List<String> listFile) {
        this.listFile = listFile;
    }
    
    
    public Haberler getHaber() {
        return haber;
    }

    public void setHaber(Haberler haber) {
        this.haber = haber;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    @PostConstruct
    public void init(){
        
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();            
            if(request!=null){
                link=request.getParameter("link");
                DAO dao=new DAO();
                haber=dao.getHaber(link);
                
                String realPath=FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
                File[] files= new File(realPath+haber.getResimPath()).listFiles();
                for(File file:files){
                    listFile.add("/igespor/"+haber.getResimPath()+"/"+file.getName());
                }
                dao.closeDB();
                
            }            
    }
}
