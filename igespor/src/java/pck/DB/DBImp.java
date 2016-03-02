/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pck.DB;

import java.util.List;

/**
 *
 * @author caner
 */
public interface DBImp {
    void saveWant();
    List getWantAll();
    void saveIletisim();
    List getIletisimAll();
    void closeDB();
}
