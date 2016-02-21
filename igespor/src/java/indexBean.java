
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import pck.DB.iletisimBean;

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
public class indexBean {
    
    @ManagedProperty(value = "iletisimBean")
    private iletisimBean iletisim_Bean;

    public iletisimBean getIletisim_Bean() {
        return iletisim_Bean;
    }

    public void setIletisim_Bean(iletisimBean iletisim_Bean) {
        this.iletisim_Bean = iletisim_Bean;
    }
    
    
    private boolean alertMessaje=false;

    public boolean isAlertMessaje() {
        return alertMessaje;
    }

    public void setAlertMessaje(boolean alertMessaje) {
        this.alertMessaje = alertMessaje;
    }
    
    @PostConstruct
    public void isAlert(){
        alertMessaje=iletisim_Bean.isAlertMessage();
    }
    
}
