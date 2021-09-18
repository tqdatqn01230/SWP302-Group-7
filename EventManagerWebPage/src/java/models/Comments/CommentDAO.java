/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.Comments;

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
public class CommentDAO {
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
    public boolean AddComment(CommentDTO cmt) throws NamingException, SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection();
            if (conn!=null){
                String sql="INSERT INTO tblComments(EventID,username,comment)"
                        + " VALUES (?,?,?)";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, cmt.getEventID());
                stm.setString(2, cmt.getUserName());
                stm.setString(3, cmt.getComment());
                int re=stm.executeUpdate();
                if (re>0) check=true;
            }           
        }finally{
            CloseConnection();
            return check;
        }
    }
    
}
