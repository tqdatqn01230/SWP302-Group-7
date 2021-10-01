/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.posts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.replys.ReplyDTO;
import utils.DButils;

/**
 *
 * @author Dell
 */
public class PostDAO {
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
    public boolean addPost(PostDTO post) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="INSERT INTO tblPosts(EventID,PostContent,Status) "
                        + " VALUES(?,?,1)";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, post.getEventID());
                stm.setString(2, post.getPostContent());
                int re=stm.executeUpdate();
                if (re>0) check=true;
            }
        }finally{
            CloseConnection();
            return check;
        }       
        
    }
    public boolean DeletePost(int postID) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="UPDATE tblPosts SET status=0 WHERE PostID=?";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, postID);
                int re=stm.executeUpdate();
                if (re>0) check=true;
            }
        }finally{
            CloseConnection();
            return check;
        }           
    }
    public boolean ChangePostContent(int postID,String content) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="UPDATE tblPosts SET PostContent=? WHERE PostID=?";
                stm=conn.prepareStatement(sql);
                stm.setString(1, content);
                stm.setInt(2, postID);
                int re=stm.executeUpdate();
                if (re>0) check=true;
            }
        }finally{
            CloseConnection();
            return check;
        }           
    }
    public List<PostDTO> getListPost(int eventID) throws SQLException{
            List<PostDTO> list=new ArrayList();
            try{
               conn=DButils.getConnection1();
               if (conn!=null){
                   String sql="SELECT * FROM tblPosts "
                           + "WHERE EventID= ? AND status=1 orDER BY PostID DESC";
                   stm=conn.prepareStatement(sql);
                   stm.setInt(1, eventID);
                   rs=stm.executeQuery();
                   while (rs.next()){
                       list.add(new PostDTO(rs.getInt("PostID"), eventID, rs.getString("PostContent")));
                   }
               }
            }finally{
                CloseConnection();
                return list;
            }
        }
}
