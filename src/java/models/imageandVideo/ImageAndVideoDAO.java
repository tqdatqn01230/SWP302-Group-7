/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.imageandVideo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DButils;

/**
 *
 * @author Dell
 */
public class ImageAndVideoDAO {
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
    public boolean UPdateImage(ImageAndVideoDTO vid) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String a=vid.getLink();
                int b=vid.getImageID();
                String sql="Update tblImageAndVideo SET ImageLink=? WHERE ImageID=?";
                stm = conn.prepareStatement(sql);
                stm.setInt(2, vid.getImageID());
                stm.setString(1,vid.getLink() );
                int re=stm.executeUpdate();
                if (re>0) check =true;
            }
        }finally{
            CloseConnection();
            return check;
        }
    }
     public boolean AddImage(ImageAndVideoDTO vid) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="Insert into tblImageAndVideo(ImageLink,PostID) VALUES(?,?)";
                stm = conn.prepareStatement(sql);
                stm.setInt(2, vid.getPostID());
                stm.setString(1,vid.getLink() );
                int re=stm.executeUpdate();
                if (re>0) check =true;
            }
        }finally{
            CloseConnection();
            return check;
        }
    }
    public  ImageAndVideoDTO getImage(int PostID) throws SQLException{
        ImageAndVideoDTO list=new ImageAndVideoDTO(PostID, "");
        try{
            conn= DButils.getConnection1();
            if (conn!=null){
                String sql="SELECT TOP(1) * FROM tblImageAndVideo WHERE PostID=?";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, PostID);
                rs=stm.executeQuery();
                while (rs.next()){
                    list=new ImageAndVideoDTO(rs.getInt("ImageID"),PostID,rs.getString("Imagelink"));
                }
            }
        }finally{
            CloseConnection();
            return list;
        }
    }
    public int GetImageID(int postID) throws SQLException{
        int res=0;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="Select Top(1) ImageID from tblImageAndVideo Where PostID=?";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, postID);
                rs=stm.executeQuery();
                if (rs.next())res=rs.getInt("ImageID");
            }
        }finally{
            CloseConnection();
            return res;
        }
    }
    public int GetImageID() throws SQLException{
        int res=0;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="Select max(ImageID) as ImageID from tblImageAndVideo";
                stm=conn.prepareStatement(sql);
                rs=stm.executeQuery();
                if (rs.next())res=rs.getInt("ImageID");
            }
        }finally{
            CloseConnection();
            return res;
        }
    }
}
