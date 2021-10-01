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
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql= "INSERT INTO tblEvents(UserID,EventContent, Followers,MaxFollower,Status)"
                        + " VALUES (?,?,?,?,0)";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, event.getUserID());
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
    public List<EventsDTO> ListEventByUserID(int userID) throws NamingException, SQLException{
        List<EventsDTO> list =new ArrayList();
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="SELECT * FROM tblEvents WHERE UserID = ? AND status=1 "
                        + " ORDER BY EventID DESC";
                stm=conn.prepareStatement(sql);
                stm.setInt(1,userID);
                rs=stm.executeQuery();
                while (rs.next()){
                    EventsDTO eva=new EventsDTO(rs.getInt("EventID"),rs.getInt("UserID"),rs.getString("EventContent")
                    ,rs.getInt("Followers"),rs.getInt("MaxFollower"));
                    list.add(eva);
                }   
            }
        }finally{
            CloseConnection();
            return list;
        }
    }
    public List<EventsDTO> SearchEvents(String eventContent) throws NamingException, SQLException{
        List<EventsDTO> list =new ArrayList();
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="SELECT * FROM tblEvents WHERE EventContent like ? AND status=1 "
                        + " ORDER BY EventID DESC";
                stm=conn.prepareStatement(sql);
                stm.setString(1, "%"+eventContent+"%");
                rs=stm.executeQuery();
                while (rs.next()){
                    EventsDTO eva=new EventsDTO(rs.getInt("EventID"),rs.getInt("UserID"),rs.getString("EventContent")
                    ,rs.getInt("Followers"),rs.getInt("MaxFollower"));
                    list.add(eva);
                }   
            }
        }finally{
            CloseConnection();
            return list;
        }
    }
    public List<EventsDTO> ViewEvents(String date) throws NamingException, SQLException{
        List<EventsDTO> list =new ArrayList();
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="declare @currentdate datetime \n" +
                            "set @currentdate = ? \n" +
                            "Select e.EventID,e.UserID,e.EventContent,e.Followers,e.MaxFollower from tblEvents e \n" +
        "WHERE e.EventID in (Select EventID from tblTimetable where cast(endtime as float) > cast(@currentdate as float)) AND e.Status=1\n" +
                            "Order By EventID DESC";
                stm=conn.prepareStatement(sql);
                stm.setString(1,date);
                rs=stm.executeQuery();
                while (rs.next()){
                    EventsDTO eva=new EventsDTO(rs.getInt("EventID"),rs.getInt("UserID"),rs.getString("EventContent")
                    ,rs.getInt("Followers"),rs.getInt("MaxFollower"));
                    list.add(eva);
                }   
            }
        }finally{
            CloseConnection();
            return list;
        }
    }
    public List<EventsDTO> ViewPendingEvents() throws NamingException, SQLException{
        List<EventsDTO> list =new ArrayList();
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="Select * from tblEvents Where status=0";
                stm=conn.prepareStatement(sql);
                rs=stm.executeQuery();
                while (rs.next()){
                    EventsDTO eva=new EventsDTO(rs.getInt("EventID"),rs.getInt("UserID"),rs.getString("EventContent")
                    ,rs.getInt("Followers"),rs.getInt("MaxFollower"));
                    list.add(eva);
                }   
            }
        }finally{
            CloseConnection();
            return list;
        }
    }
    
    public int GetEventID() throws SQLException{
        int res=0;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="Select max(EventID) as EventID from tblEvents";
                stm=conn.prepareStatement(sql);
                rs=stm.executeQuery();
                if(rs.next()) res=rs.getInt("EventID");
            }
        }finally{
            CloseConnection();
            return res;
        }
    }
    public EventsDTO GetEventByID(int eventID) throws SQLException{
        EventsDTO res=null;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="Select * From tblEvents where EventID = ?";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, eventID);
                rs=stm.executeQuery();
                if(rs.next()) res= new EventsDTO(eventID,rs.getInt("UserID"),rs.getString("EventContent")
                    ,rs.getInt("Followers"),rs.getInt("MaxFollower"));
            }
        }finally{
            CloseConnection();
            return res;
        }
    }
    public boolean UpdateFollowers(int eventID,int follower) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="UPDATE tblEvents SET followers= ? WHERE eventID=?";
                stm=conn.prepareStatement(sql);
                stm.setInt(2, eventID);
                stm.setInt(1, follower);
                int re=stm.executeUpdate();
                check= re>0 ? true:false;
            }
        }finally{
            CloseConnection();
            return check;
        }
    }
        public boolean UpdateStatus(int eventID,int status) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="UPDATE tblEvents SET status= ? WHERE eventID=?";
                stm=conn.prepareStatement(sql);
                stm.setInt(2, eventID);
                stm.setInt(1, status);
                int re=stm.executeUpdate();
                check= re>0 ? true:false;
            }
        }finally{
            CloseConnection();
            return check;
        }
    }
    
}
