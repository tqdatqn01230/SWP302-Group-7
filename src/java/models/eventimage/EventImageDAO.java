/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.eventimage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.imageandVideo.ImageAndVideoDTO;
import utils.DButils;

/**
 *
 * @author Dell
 */
public class EventImageDAO {
    Connection conn=null;
    PreparedStatement stm=null;
    ResultSet rs=null;
    public void CloseConnection() throws SQLException{
        if (rs !=null) {
                rs.close();
            }
            if (stm!=null){
                stm.close();
            }
            if (conn!=null){
                conn.close();
            }  
    }
    public boolean AddImage(EventImageDTO vid) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="INSERT INTO tblEventImage(eventID,link) VALUES(?,?)";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, vid.getEventID());
                stm.setString(2,vid.getLink() );
                int re=stm.executeUpdate();
                if (re>0) check =true;
            }
        }finally{
            CloseConnection();
            return check;
        }
    }
    public boolean UpdateImage(EventImageDTO image) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="Update tblEventImage SET Link=? Where EventID=? ";
                stm = conn.prepareStatement(sql);
                stm.setInt(2, image.getEventID());
                stm.setString(1,image.getLink() );
                int re=stm.executeUpdate();
                if (re>0) check =true;
            }
        }finally{
            CloseConnection();
            return check;
        }
    }
    public EventImageDTO GetImage(int EventID) throws SQLException{
        EventImageDTO image=null;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="SELECT ID,link,EventID FROM tblEventImage WHERE EventID=? ";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, EventID);
                rs=stm.executeQuery();
                if (rs.next()){
                    image=new EventImageDTO(rs.getString("link"),EventID);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EventImageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            CloseConnection();
            return image;
        }
    }
}
