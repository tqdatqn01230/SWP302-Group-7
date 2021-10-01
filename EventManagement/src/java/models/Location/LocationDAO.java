/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.events.EventsDTO;
import utils.DButils;

/**
 *
 * @author Dell
 */
public class LocationDAO {
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
    public boolean AddLocation(LocationDTO location) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql= "INSERT INTO tblLocation(LocationName,Status)"
                        + " VALUES (?,1)";
                stm=conn.prepareStatement(sql);
                stm.setString(1, location.getLocationName());
                int re= stm.executeUpdate();
                if (re>0) check=true;
            }
            
        }finally{
            CloseConnection();
            return check;
        }
    }
    public boolean DeleteLoacation(int locationID) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="UPdate tbllocation set Status=0  "
                        + " Where locationID=?";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, locationID);                
                int re=stm.executeUpdate();
                if (re>0) check=true;
            }
        }finally{
            CloseConnection();
            return check;
        }       
    }
    public LocationDTO getLocation(String locationName) throws SQLException{
        LocationDTO res=null;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="SELECT * FROM tblLocation Where LocationName like ?";
                stm=conn.prepareStatement(sql);
                stm.setString(1, "%"+locationName+"%");
                rs=stm.executeQuery();
                if (rs.next()) res=new LocationDTO(rs.getInt("LocationID"), rs.getString("LocationName"));
            }
        }finally{
            CloseConnection();
            return res;
        }       
    }
    public List<String> getListLocation() throws SQLException{
        List<String> list=new ArrayList();
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="SELECT LocationName FROM tblLocation Where Status=1";
                stm=conn.prepareStatement(sql);
                rs=stm.executeQuery();
                while (rs.next()) {
                    String a=rs.getString("LocationName");
                    list.add(a);
                }
            }
        }finally{
            CloseConnection();
            return list;
        }       
    }
}
