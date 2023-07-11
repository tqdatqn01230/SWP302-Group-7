/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import models.Comments.CommentDAO;
import models.Comments.CommentDTO;
import models.Follows.*;
import models.Location.LocationDAO;
import models.Location.LocationDTO;
import models.events.*;
import models.imageandVideo.ImageAndVideoDAO;
import models.posts.PostDAO;
import models.posts.PostDTO;
import models.replys.*;
import models.timetable.TimetableDAO;
import models.timetable.TimetableDTO;

/**
 *
 * @author Dell
 */
public class testALLDAO {
    public static void main(String [] args) throws NamingException, SQLException{
//        EventsDTO event=new EventsDTO(2, "Sự Kiện Thác Loạn FPT", 1000);
//        try{
//            EventsDAO dao=new EventsDAO();
//            //boolean a=dao.AddEvent(event);
//            List <EventsDTO> list=dao.ListEventByUserID(2);
//            //System.out.println(a);
//            System.out.println(list.get(0).getEventContent());
//        } catch (SQLException ex) {
//            Logger.getLogger(testALLDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        FollowDTO follow=new FollowDTO(1, 3, "Bạn có 2 thông báo cần xem");
//        try{
//            FollowDAO dao=new FollowDAO();
//            System.out.println(dao.ChangeNotification(follow));
//        }catch(SQLException | NamingException e){
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(testALLDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        PostDTO post=new PostDTO(1, "Sự kiện 2");
//        try{
//            PostDAO dao=new PostDAO();
//            dao.DeletePost(1);
//            List<PostDTO> list=dao.getListPost(1);
//            for (PostDTO a:list){
//                System.out.println(a.getEventID()+"   "+a.getPostContent());
//            }
//        }catch(SQLException e){
//        }
//        CommentDTO dto=new CommentDTO(1, 3, "Comment 2");
//        
//        try{
//            CommentDAO dao=new CommentDAO();
//            //System.out.println(dao.AddComment(dto));
//            List<CommentDTO> list=dao.getListComment(1);
//            for (CommentDTO a:list){
//                System.out.println(a.getComment());
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(testALLDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        ReplyDTO dto=new ReplyDTO(5, 3, "Reply 1");
//        try{
             ReplyDAO dao=new ReplyDAO();
//            dao.addReplys(dto);
//        }finally{
//            
//        }
           List<ReplyDTO> reps=dao.GetListReplys(4);
           System.out.println(reps.size());
//        LocationDTO dto=new LocationDTO("Khu B1");
//        LocationDAO dao=new LocationDAO();
//        dao.AddLocation(dto);


//          String starttime,endtime;
//          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//            LocalDateTime now = LocalDateTime.now();
//            LocalDateTime end= now.plusDays(10);
//            starttime = now.format(dtf);
//            System.out.println(starttime);
//            endtime=dtf.format(end);
//            System.out.println(endtime);
//            starttime="2021-09-30";
//            endtime="2021-10-10 23:59:00";
//            TimetableDTO dto=new TimetableDTO(4, 3, starttime, endtime);
//            TimetableDAO dao1=new TimetableDAO();
//            //System.out.println(dao1.AddTimeTable(dto));
//            LocationDAO lodao=new LocationDAO();
//            System.out.println(lodao.getLocation("Khu A").getLocationID());

//        EventsDAO dao=new EventsDAO();
//        List<EventsDTO> list=new ArrayList();
//        String date="2021-09-27 21:23:02";
//        list=dao.ViewEvents(date);
//        System.out.println(list.size());
          //ImageAndVideoDAO dao1=new ImageAndVideoDAO();
          //System.out.println(dao1.GetImageID());
    }
}
