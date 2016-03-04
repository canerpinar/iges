/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pck.Entity;

import java.util.Date;



/**
 *
 * @author caner
 */
public class Haberler {
    private String baslik,icerik,resimPath;
    private String tarih;

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }


    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getResimPath() {
        return resimPath;
    }

    public void setResimPath(String resimPath) {
        this.resimPath = resimPath;        
    }
    
}
