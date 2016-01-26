
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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

    public String sporDali(String isim){
        
        if(isim.equals("yüzme"))
        {
            return "faces/spor.xhtml";
        }
        else{
            return "/faces/erisilebilirlik.xhtml";
        }
    }
}
