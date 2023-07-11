/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.user;

/**
 *
 * @author Dell
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import  utils.DButils;
import javax.naming.NamingException;
/**
 *
 * @author Dell
 */
public class UserDAO implements Serializable{
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
    public UserDTO checkLogin(String username,String password) throws ClassNotFoundException, SQLException{
        UserDTO res=null;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){ 
                String sql="SELECT * FROM tblUsers WHERE Username = ? AND password = ?";
                stm=conn.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                
                rs=stm.executeQuery();
                if (rs.next()){
                    res=new UserDTO(rs.getInt("UserID"),rs.getString("Username"),rs.getString("password"),rs.getString("Gmail"),rs.getString("Role")
                                    ,rs.getString("FullName"),rs.getBoolean("Status"));
                    } 
                }
        }catch (Exception e){
        }
        finally{
            CloseConnection();
        }
        return res;
    }
    public List<UserDTO> getListUser(String search) throws SQLException, ClassNotFoundException, NamingException{
        List<UserDTO> res=new ArrayList(); 
        if (search==null) return null;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="SELECT * FROM tblUsers WHERE fullName like ? AND Status=1" ;
                stm=conn.prepareStatement(sql);
                stm.setString(1,"%"+search+"%");
                rs=stm.executeQuery();
                while (rs.next()){
                    res.add(new UserDTO(rs.getInt("UserID"),rs.getString("username"),"***",rs.getString("Gmail"),rs.getString("Role")
                            ,rs.getString("FullName")));
                }
            }
        }catch (SQLException e){        
        }
        finally{
            CloseConnection();
        }
        return res;
    }
        public List<String> getListUserByMail(int eventID) throws SQLException, ClassNotFoundException, NamingException{
        List<String> res=new ArrayList(); 
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="select U.gmail\n" +
                            "from tblUsers U, tblFollow F\n" +
                            "Where U.UserID=F.userID AND F.eventID=? " ;
                stm=conn.prepareStatement(sql);
                stm.setInt(1, eventID);
                rs=stm.executeQuery();
                while (rs.next()){
                    res.add(rs.getString("Gmail"));
                }
            }
        }catch (SQLException e){        
        }
        finally{
            CloseConnection();
        }
        return res;
    }
    public List<UserDTO> getDeletedListUser(String search) throws SQLException, ClassNotFoundException, NamingException{
        List<UserDTO> res=new ArrayList(); 
        if (search==null) return null;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="SELECT * FROM tblUsers WHERE fullName like ? AND Status=0" ;
                stm=conn.prepareStatement(sql);
                stm.setString(1,"%"+search+"%");
                rs=stm.executeQuery();
                while (rs.next()){
                    res.add(new UserDTO(rs.getString("username"),"***",rs.getString("Gmail"),rs.getString("Role")
                            ,rs.getString("FullName")));
                }
            }
        }catch (SQLException e){        
        }
        finally{
            CloseConnection();
        }
        return res;
    }
    public UserDTO getUser(String userName) throws SQLException, ClassNotFoundException, NamingException{
        UserDTO res=null; 
        if (userName==null) return null;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="SELECT * FROM tblUsers WHERE username = ? AND Status=1";
                stm=conn.prepareStatement(sql);
                stm.setString(1,userName);
                rs=stm.executeQuery();
                while (rs.next()){
                    res=new UserDTO(rs.getInt("UserID"),rs.getString("username"),"*******",rs.getString("Gmail"),rs.getString("Role")
                                    ,rs.getString("FullName"));
                }
            }
        }catch (SQLException e){        
        }
        finally{
            CloseConnection();
        }
        return res;
    }
    public UserDTO getUserByID(int ID) throws SQLException, ClassNotFoundException, NamingException{
        UserDTO res=null; 
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="SELECT * FROM tblUsers WHERE UserID = ?";
                stm=conn.prepareStatement(sql);
                stm.setInt(1,ID);
                rs=stm.executeQuery();
                while (rs.next()){
                    res=new UserDTO(rs.getInt("UserID"),rs.getString("username"),"*******",rs.getString("Gmail"),rs.getString("Role")
                                    ,rs.getString("FullName"));
                }
            }
        }catch (SQLException e){        
        }
        finally{
            CloseConnection();
        }
        return res;
    }
    public boolean addUser(UserDTO user) throws SQLException{
        boolean res=false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="INSERT INTO tblUsers(username,password,fullname,gmail,role,Status) "
                        + " VALUES(?,?,?,?,?,1)";
                stm=conn.prepareStatement(sql);
                stm.setString(1, user.getUserName());
                stm.setString(2, user.getPassword());
                stm.setString(3,user.getFullName());
                stm.setString(4, user.getGmail());
                stm.setString(5, user.getRole());
                int re=stm.executeUpdate();
                if (re>0) res=true;
            }
        }finally{
            CloseConnection();
            return res;
        }
    }
    public UserDTO GetMail(String mail) throws SQLException, NamingException, ClassNotFoundException{
        UserDTO user=null;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="SELECT * From tblUsers where gmail=?";
                stm=conn.prepareStatement(sql);
                stm.setString(1, mail);
                rs=stm.executeQuery();
                if (rs.next()){
                    user=new UserDTO(rs.getInt("UserID"), rs.getString("username"),"***",rs.getString("Gmail"),rs.getString("Role")
                                    ,rs.getString("FullName"),rs.getBoolean("status"));
                }
            }
        }finally{
            CloseConnection();
            
        }
        return user;
    }
    public String GetPasswordByMail(String mail) throws SQLException, NamingException, ClassNotFoundException{
        String Pass=null;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="SELECT * From tblUsers where gmail=? AND Status=1";
                stm=conn.prepareStatement(sql);
                stm.setString(1, mail);
                rs=stm.executeQuery();
                if (rs.next()){
                    Pass=rs.getString("Password");
                }
            }
        }finally{
            CloseConnection();
            
        }
        return Pass;
    }
    public boolean DeleteUser(int userID) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="UPDATE tblUsers SET status=0"
                        + "Where UserID=? ";
                stm=conn.prepareStatement(sql);
                stm.setInt(1, userID);
                int re=stm.executeUpdate();
                if (re>0) check=true;
            }
        }finally{
            CloseConnection();
            return check;
        }       
    }
    public boolean UpdateUser(int userID,String username,String password,String fullname) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="UPDATE tblUsers SET username=?, password=?, Fullname=? "
                        + "Where UserID=? ";
                stm=conn.prepareStatement(sql);
                stm.setInt(4, userID);
                stm.setString(1, username);
                stm.setString(2, password);
                stm.setString(3, fullname);
                int re=stm.executeUpdate();
                if (re>0) check=true;
            }
        }finally{
            CloseConnection();
            return check;
        }       
    }
    
    public boolean UpdateRoleUser(int userID,String role) throws SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection1();
            if (conn!=null){
                String sql="UPDATE tblUsers SET Role=? "
                        + "Where UserID=? ";
                stm=conn.prepareStatement(sql);
                stm.setString(1, role);
                stm.setInt(2 , userID);
                int re=stm.executeUpdate();
                if (re>0) check=true;
            }
        }finally{
            CloseConnection();
            return check;
        }       
    }
}
