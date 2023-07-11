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
import java.util.ArrayList;
import java.util.List;
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
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="INSERT INTO tblComments(PostID,userID,comment,status)"
                        + " VALUES (?,?,?,1)";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, cmt.getPostID());
                stm.setInt(2, cmt.getUserID());
                stm.setString(3, cmt.getComment());
                int re=stm.executeUpdate();
                if (re>0) check=true;
            }           
        }finally{
            CloseConnection();
            return check;
        }
    }
    public boolean DeleteComment(int commentID) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="Update tblComments SET status=0  "
                        + " Where commentID=?";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, commentID);
                int re=stm.executeUpdate();
                if (re>0) check=true;
            }
        }finally{
            CloseConnection();
            return check;
        }       
    }
    public int getUserIDfromComment(int commentID) throws SQLException{
        int check=-1;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="Select UserID from tblComments Where CommentID=?";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, commentID);
                rs = stm.executeQuery();
                if (rs.next()) check= rs.getInt("UserID");
            }
        }finally{
            CloseConnection();
            return check;
        }       
    }
        public boolean ChangeComment(int commentID,String Content) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="Update tblComments SET Comment=?  "
                        + " Where commentID=?";
                stm=conn.prepareStatement(sql);
                stm.setString(1, Content);
                stm.setInt(2, commentID);
                int re=stm.executeUpdate();
                if (re>0) check=true;
            }
        }finally{
            CloseConnection();
            return check;
        }       
    }
    public List<CommentDTO> getListComment(int PostID) throws SQLException{
        List<CommentDTO> list=new ArrayList();
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="SELECT C.CommentID,C.UserID,C.Comment,U.FullName FROM tblComments C,tblUsers  U"
                        + " WHERE C.PostID=? AND C.status=1 AND C.userID= U.userID"
                        + " ORDER BY CommentID DESC";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, PostID);
                rs=stm.executeQuery();
                while (rs.next()){
                    list.add(new CommentDTO(rs.getInt("CommentID"), PostID,rs.getInt("UserID"), rs.getString("Comment")
                    ,rs.getString(4)));
                }
            }
        }finally{
            CloseConnection();
            return list;
        }
    }
    
}
