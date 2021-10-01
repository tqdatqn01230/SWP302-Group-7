/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.timetable;

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
public class TimetableDAO {
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
    public boolean AddTimeTable(TimetableDTO dto) throws SQLException{
        boolean check =false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="INSERT INTO tbltimetable(EventID,LocationID,starttime,endtime,Status) "
                        + " VALUES(?,?,?,?,1)";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, dto.getEventID());
                stm.setInt(2, dto.getLocationID());
                int c=dto.getEventID();
                int d=dto.getEventID();
                String a=dto.getEndtime();
                String b=dto.getStarttime();
                stm.setString(3, dto.getStarttime());
                stm.setString(4, dto.getEndtime());
                int re= stm.executeUpdate();
                if (re>0) check=true;
            }
        }finally{
            CloseConnection();
            return check;
        }
    }
    List<TimetableDTO> getListTimeTableByEventID(int EventID) throws SQLException{
        List<TimetableDTO> list=new ArrayList();
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="SELECT * FROM tblTimeTable Where EventID=? AND Status=1";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, EventID);
                rs=stm.executeQuery();
                while(rs.next()){
                    list.add(new TimetableDTO(rs.getInt("TimeTableID"), rs.getInt("EventID"), rs.getInt("LocationID"), 
                            rs.getString("starttime"),rs.getString("endTime")));
                }
            }
        }finally{
            CloseConnection();
            return list;
        }
    }
    List<TimetableDTO> getListTimeTableByLocationName(String locationName) throws SQLException{
        List<TimetableDTO> list=new ArrayList();
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="select * from tblTimetable t\n" +
                "   where t.LocationID in (Select LocationID from tblLocation "
                        + "where LocationName like ?)";
                stm=conn.prepareStatement(sql);
                stm.setString(1,"%"+locationName+"%");
                rs=stm.executeQuery();
                while(rs.next()){
                    list.add(new TimetableDTO(rs.getInt("TimeTableID"), rs.getInt("EventID"), rs.getInt("LocationID"), 
                            rs.getString("starttime"),rs.getString("endTime")));
                }
            }
        }finally{
            CloseConnection();
            return list;
        }
    }
}
