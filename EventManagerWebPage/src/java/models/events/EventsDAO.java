/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.events;

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
public class EventsDAO {
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
    public boolean AddEvent(EventsDTO event) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection();
            if (conn!=null){
                String sql= "INSERT INTO tblEvents(UserName,EventContent, Followers,MaxFollower)"
                        + " VALUES (?,?,?,?)";
                stm=conn.prepareStatement(sql);
                stm.setString(1, event.getUserName());
                stm.setString(2, event.getEventContent());
                stm.setInt(3,0);
                stm.setInt(4, event.getMaxFollowers());
                int re= stm.executeUpdate();
                if (re>0) check=true;
            }
            
        }finally{
            CloseConnection();
            return check;
        }
    }
    List<EventsDTO> ListEventByUserName(String username) throws NamingException, SQLException{
        List<EventsDTO> list =new ArrayList();
        try{
            conn=DButils.getConnection();
            if (conn!=null){
                String sql="SELECT * FROM tblEvents WHERE username= ?";
                stm=conn.prepareStatement(sql);
                stm.setString(1, username);
                rs=stm.executeQuery();
                while (rs.next()){
                    EventsDTO eva=new EventsDTO(rs.getInt("EventID"),rs.getString("Username"),rs.getString("EventContent")
                    ,rs.getInt("Followers"),rs.getInt("MaxFollower"));
                    list.add(eva);
                }
                
            }
        }finally{
            CloseConnection();
            return list;
        }
    }
}
