/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.replys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DButils;

/**
 *
 * @author Dell
 */
public class ReplyDAO {
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
    public boolean addReplys(ReplyDTO rep) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="INSERT INTO tblReplys(CommentID,UserID,Reply,Status)  "
                        + " VALUES(?,?,?,1)";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, rep.getCommentID());
                stm.setInt(2, rep.getUserID());
                stm.setString(3, rep.getReply());
                int re=stm.executeUpdate();
                if (re>0) check=true;
            }
        }finally{
            CloseConnection();
            return check;
        }       
    }
    public List<ReplyDTO> GetListReplys(int CommentID) throws SQLException{
        List<ReplyDTO> list=new ArrayList();
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="select U.FullName,R.CommentID,R.Reply,R.ReplyID,R.UserID\n" +
" from tblReplys R, tblUsers U\n" +
" where R.UserID=U.UserID AND R.[Status]=1 and R.CommentID=?\n" +
" Order by ReplyID DESC";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, CommentID);
                rs=stm.executeQuery();
                while(rs.next()){
                    list.add(new ReplyDTO(rs.getInt("replyID"),rs.getInt("commentID"),rs.getInt("UserID"),
                            rs.getString("Reply"),rs.getString("FullName")));
                }
            }
        }finally{
            CloseConnection();
            return list;
        }
    }
    public boolean DeleteReplys(int replyID) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="UPdate tblReplys SET Status=0  "
                        + " Where replyID=?";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, replyID);                
                int re=stm.executeUpdate();
                if (re>0) check=true;
            }
        }finally{
            CloseConnection();
            return check;
        }       
    }
        public boolean ChangeReplys(int replyID,String rep) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="UPdate  tblReplys SET Reply=?  "
                        + " Where replyID= ?";
                stm=conn.prepareStatement(sql);
                stm.setString(1, rep);
                stm.setInt(2, replyID);                
                int re=stm.executeUpdate();
                if (re>0) check=true;
            }
        }finally{
            CloseConnection();
            return check;
        }       
    }
}
