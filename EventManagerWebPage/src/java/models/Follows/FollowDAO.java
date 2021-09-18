/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.Follows;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public boolean AddFollow(FollowDTO follow) throws NamingException, SQLException{
        boolean check=false;
        try{
            conn =DButils.getConnection();
            if (conn!=null){
                String sql="INSERT INTO tblFollow(eventID,notification,UserName) VALUES (?,?)";
                stm= conn.prepareStatement(sql);
                stm.setInt(1, follow.getEventID());
                stm.setString(2, follow.getNotification());
                stm.setString(3, follow.getUserName());
                int re=stm.executeUpdate();
                if (re>0) check=true;
            }
        }finally{
            CloseConnection();
        }
        return check;
    }
    public boolean ChangeNotification(FollowDTO follow) throws SQLException, NamingException{
        boolean check=false;
        try{
            conn =DButils.getConnection();
            if (conn!=null){
                String sql="UPDATE tblFollow "
                        + " SET Notification= ? Where eventID = ? AND username = ? And Check=?";
                stm= conn.prepareStatement(sql);
                stm.setInt(2, follow.getEventID());
                stm.setString(1, follow.getNotification());
                stm.setString(3, follow.getUserName());
                stm.setBoolean(4, false);
                int re=stm.executeUpdate();
                if (re>0) check=true;
            }
        }finally{
            CloseConnection();
        }
        return check;
    }
    
}
