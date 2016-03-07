/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pck.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pck.Entity.Haberler;
import pck.Entity.Istekler;

/**
 *
 * @author caner
 */
public class DAO implements DBImp{

    private Connection connection=null;
    public DAO(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/igesdb?useUnicode=true&characterEncoding=utf-8","root","06061989");
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void saveWant() {
        
    }
    @Override
    public List getWantAll() {
        return null;
        
    }

    @Override
    public void saveIletisim(String ad,String soyad,String email,String baslik,String aciklama) {
            PreparedStatement statement;
        try {
            statement = connection.prepareStatement("insert into istekler(ad,soyad,email,baslik,aciklama) values(?,?,?,?,?)");
            statement.setString(1, ad);
            statement.setString(2, soyad);
            statement.setString(3, email);
            statement.setString(4, baslik);
            statement.setString(5, aciklama);
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
    }
    @Override
    public List getIletisimAll() {
        List<Istekler> listIstekler=new ArrayList<>();
        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select ad,soyad,email,aciklama from istekler");
            
            while(resultSet.next()){
                Istekler istekler=new Istekler();
                istekler.setAd(resultSet.getString(1));
                istekler.setSoyad(resultSet.getString(2));
                istekler.setEmail(resultSet.getString(3));
                istekler.setAciklama(resultSet.getString(4));
                listIstekler.add(istekler);
                resultSet.close();
                statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listIstekler;
    
    }

    @Override
    public void closeDB() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void saveHaber(String baslik, String icerik, String imagesPath,String tarih,String mainResim,String haberLink) {
        
        try {
            PreparedStatement statement=connection.prepareStatement("insert into haberler(baslik,icerik,resimpath,tarih,mainresim,link) values(?,?,?,?,?,?)");
            statement.setString(1, baslik);
            statement.setString(2, icerik);
            statement.setString(3, imagesPath);
            statement.setString(4, tarih);
            statement.setString(5, mainResim);
            statement.setString(6, haberLink);
            statement.execute();
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Haberler> getHaberler() {
        List<Haberler> listHaberler=new ArrayList<>();
        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select id,baslik,icerik,resimpath,tarih,mainresim,link from haberler");
            while(resultSet.next()){
                Haberler haberler=new Haberler();
                haberler.setId(resultSet.getString(1));
                haberler.setBaslik(resultSet.getString(2));
                haberler.setIcerik(resultSet.getString(3));
                haberler.setResimPath(resultSet.getString(4));
                haberler.setTarih(resultSet.getString(5));
                haberler.setMainResim(resultSet.getString(6));
                haberler.setLink(resultSet.getString(7));
                listHaberler.add(haberler);
            }            
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return listHaberler;
    }

    @Override
    public Haberler getHaber(String link) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        Haberler haber=new Haberler();
        try {
            ResultSet resultSet=statement.executeQuery("select baslik,icerik,resimpath,tarih from haberler where link='"+link+"'");
            resultSet.next();
            
            haber.setBaslik(resultSet.getString(1));
            haber.setIcerik(resultSet.getString(2));
            haber.setResimPath(resultSet.getString(3));
            haber.setTarih(resultSet.getString(4));
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return haber;
    }

 
}
