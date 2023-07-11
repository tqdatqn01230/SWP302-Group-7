/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Follows.FollowDAO;
import models.Follows.FollowDTO;
import models.eventimage.EventImageDAO;
import models.eventimage.EventImageDTO;
import models.events.EventsDAO;
import models.events.EventsDTO;
import models.user.UserDTO;

/**
 *
 * @author Dell
 */
@WebServlet(name = "ViewEventsController", urlPatterns = {"/ViewEventsController"})
public class ViewEventsController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   String VIEW_PAGE="MemberPage.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=VIEW_PAGE;
        try{
            EventsDAO dao=new EventsDAO();
            List<EventsDTO> list=new ArrayList();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String date=now.format(dtf);
            list=dao.ViewEvents(date);
            EventImageDAO imageDAO=new EventImageDAO();
            for (EventsDTO event:list){
                EventImageDTO image= imageDAO.GetImage(event.getEventID());
                String attributeName= "EventImage"+String.valueOf(event.getEventID());
                if (image!=null)request.setAttribute(attributeName, image.getLink());
                else request.setAttribute(attributeName, "");
            }            
            request.setAttribute("Events", list);
            FollowDAO followdao=new FollowDAO();
            HttpSession sess=request.getSession();
            UserDTO user = null;
            if (sess!=null)user=(UserDTO) sess.getAttribute("USER");
            
            List<Integer> listevent=new ArrayList();
            if (user!=null) listevent=followdao.GetEventFollow(user.getUserID());
            request.setAttribute("ListEventsFollowed", listevent);
            List<FollowDTO> list1=new ArrayList();    
            FollowDAO dao1=new FollowDAO();
            if (user!=null) list1 = dao1.GetNotification(user.getUserID());
            if (sess!=null)sess.setAttribute("ListNotifications", list1);
        } catch (NamingException ex) {
           Logger.getLogger(ViewEventsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
           Logger.getLogger(ViewEventsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(ViewEventsController.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
