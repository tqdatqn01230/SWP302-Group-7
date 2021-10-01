/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import models.events.EventsDAO;
import models.events.EventsDTO;
import models.user.UserDTO;

/**
 *
 * @author Dell
 */
@WebServlet(name = "FollowEventController", urlPatterns = {"/FollowEventController"})
public class FollowEventController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String VIEW="ViewEventsController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=VIEW;
        try{
            HttpSession sess=request.getSession();
            int eventID=Integer.parseInt(request.getParameter("EventID"));
            int userID=((UserDTO) sess.getAttribute("USER")).getUserID();
            EventsDAO eventdao=new EventsDAO();
            EventsDTO event=eventdao.GetEventByID(eventID);
            String action=request.getParameter("Action");
            if(action.equals("Follow")){
                if (event.getFolowers() == event.getMaxFollowers()) {
                    request.setAttribute("Mess", "Event is FULL of Followers");
                } else {
                    FollowDAO dao = new FollowDAO();
                    FollowDTO follow = new FollowDTO(eventID, userID, "Bạn đã follow 1 Event");
                    dao.AddFollow(follow);
                    eventdao.UpdateFollowers(eventID, event.getFolowers() + 1);
                }
            }else if(action.equals("Unfollow")){
                FollowDAO dao = new FollowDAO();
                dao.DeleteFollow(eventID, userID);
                eventdao.UpdateFollowers(eventID, event.getFolowers() - 1);
            }
            //eventdao.
        } catch (NamingException ex) {
            Logger.getLogger(FollowEventController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FollowEventController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FollowEventController.class.getName()).log(Level.SEVERE, null, ex);
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
