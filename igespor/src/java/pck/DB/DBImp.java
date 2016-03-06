/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pck.DB;

import java.util.Date;
import java.util.List;
import pck.Entity.Haberler;

/**
 *
 * @author caner
 */
public interface DBImp {
    List<Haberler> getHaberler();
    void saveHaber(String baslik,String icerik,String imagesPath,String tarih,String mainResim);
    Haberler getHaber(String link);
    void saveWant();
    List getWantAll();
    void saveIletisim();
    List getIletisimAll();
    void closeDB();
}
