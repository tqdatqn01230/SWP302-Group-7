/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.Follows;

import com.sun.webkit.graphics.GraphicsDecoder;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.DButils;

/**
 *
 * @author Dell
 */
public class FollowDAO implements Serializable{
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
    public boolean AddFollow(FollowDTO follow) throws NamingException, SQLException, ClassNotFoundException{
        boolean check=false;
        try{
            conn =DButils.getConnection1();
            if (conn!=null){
                String sql="INSERT INTO tblFollow(eventID,Notifications,userID,Status) VALUES (?,?,?,0)";
                stm= conn.prepareStatement(sql);
                stm.setInt(1, follow.getEventID());
                stm.setString(2, follow.getNotification());
                stm.setInt(3,follow.getUserID());
                int re=stm.executeUpdate();
                if (re>0) check=true;
            }
        }finally{
            CloseConnection();
        }
        return check;
    }
    public boolean ChangeNotification(String noti,int eventID) throws SQLException, NamingException, ClassNotFoundException{
        boolean check=false;
        try{
            conn =DButils.getConnection1();
            if (conn!=null){
                String sql="UPDATE tblFollow "
                        + " SET Notifications= ?, Status=0 Where eventID = ? ";
                stm= conn.prepareStatement(sql);
                stm.setString(1, noti);
                stm.setInt(2, eventID);
                int re=stm.executeUpdate();
                if (re>0) check=true;
            }
        }finally{
            CloseConnection();
        }
        return check;
    }    
    public boolean SeeNotification(int userID) throws SQLException, NamingException, ClassNotFoundException{
        boolean check=false;
        try{
            conn =DButils.getConnection1();
            if (conn!=null){
                String sql="UPDATE tblFollow "
                        + " SET Status=1  Where userID = ? ";
                stm= conn.prepareStatement(sql);
                stm.setInt(1, userID);
                int re=stm.executeUpdate();
                if (re>0) check=true;
            }
        }finally{
            CloseConnection();
        }
        return check;
    }
    public List<FollowDTO> GetNotification(int userID) throws SQLException, NamingException, ClassNotFoundException{
        List<FollowDTO> list=new ArrayList();
        try{
            conn =DButils.getConnection1();
            if (conn!=null){
                String sql="SELECT * FROM tblFollow WHERE userID= ? AND status=0 ";
                stm= conn.prepareStatement(sql);
                stm.setInt(1, userID);
                rs=stm.executeQuery();
                while (rs.next()){
                    list.add(new FollowDTO(rs.getInt("EventID"),rs.getInt("userID"), rs.getString("Notifications")));
                }
            }
        }finally{
            CloseConnection();
        }
        return list;
    }
    public boolean DeleteFollow(int eventID,int userID) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="DELETE FROM tblFollow WHERE eventID=? AND userID=?";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, eventID);
                stm.setInt(2, userID);
                int re=stm.executeUpdate();
                if (re>0) check=true;
            }
        }finally{
            CloseConnection();
            return check;
        }       
    }
    public List<Integer> GetEventFollow(int userID) throws SQLException{
        List<Integer>list=new ArrayList();
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="SELECT EventID FROM tblFollow WHERE userID=?";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, userID);
                rs=stm.executeQuery();
                while (rs.next()){
                    list.add(rs.getInt("EventID"));
                }
            }
        }finally{
            CloseConnection();
            return list;
        }       
    }
    public List<FollowDTO> GetNotifications(int userID) throws SQLException{
        List<FollowDTO>list=new ArrayList();
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="SELECT * FROM tblFollow WHERE userID=?";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, userID);
                rs=stm.executeQuery();
                while (rs.next()){
                    list.add(new FollowDTO(rs.getInt("eventID"), 
                            rs.getInt("userID"), rs.getString("Notifications")));
                }
            }
        }finally{
            CloseConnection();
            return list;
        }       
    }
}
