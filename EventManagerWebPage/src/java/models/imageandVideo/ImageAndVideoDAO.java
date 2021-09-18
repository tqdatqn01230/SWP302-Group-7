/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.imageandVideo;

import com.sun.javafx.scene.control.skin.VirtualFlow;
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
    public boolean AddImage(ImageAndVideoDTO vid) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection();
            if (conn!=null){
                String sql="INSERT INTO tblImageAndVideo(EventID,ImageLink) VALUES(?,?)";
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
    List <ImageAndVideoDTO> getListImage(int EventID) throws SQLException{
        List<ImageAndVideoDTO> list=new ArrayList<ImageAndVideoDTO>();
        try{
            conn= DButils.getConnection();
            if (conn!=null){
                String sql="SELECT * FROM tblImageAndVideo WHERE username=?";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, EventID);
                rs=stm.executeQuery();
                while (rs.next()){
                    list.add(new ImageAndVideoDTO(rs.getInt("ImageID"),EventID,
                            rs.getString("ImageLink")));
                }
            }
        }finally{
            CloseConnection();
            return list;
        }
    }
}
