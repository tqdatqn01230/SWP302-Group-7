/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.leader;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Location.LocationDAO;
import models.Location.LocationDTO;
import models.events.EventsDAO;
import models.events.EventsDTO;
import models.timetable.TimetableDAO;
import models.timetable.TimetableDTO;
import models.user.UserDTO;

/**
 *
 * @author Dell
 */
@WebServlet(name = "PostEventController", urlPatterns = {"/PostEventController"})
public class PostEventController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String VIEW_PAGE="PrepareLocationController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=VIEW_PAGE;
        try{
            String eventContent=request.getParameter("Content");
            int maxfollower=Integer.parseInt(request.getParameter("MaxFollower"));
            String startdate=request.getParameter("Startdate");
            String enddate=request.getParameter("Enddate") +" 23:59:59";
            String locationName=request.getParameter("Location");
            HttpSession ses=request.getSession();
            UserDTO user=(UserDTO) ses.getAttribute("USER");
            int userID=user.getUserID();
            EventsDTO event=new EventsDTO(userID, eventContent, maxfollower);
            EventsDAO eventdao=new EventsDAO();
            eventdao.AddEvent(event);
            LocationDAO locationdao=new LocationDAO();
            LocationDTO location=locationdao.getLocation(locationName);
            int eventID=eventdao.GetEventID();
            int locationID=location.getLocationID();
            TimetableDTO Timetable=new TimetableDTO(eventID,locationID, startdate, enddate);
            TimetableDAO timeDAO =new TimetableDAO();
            timeDAO.AddTimeTable(Timetable);
            request.setAttribute("Mess", "You have posted an event, wait for Admin to accept Event");
        } catch (SQLException ex) {
            Logger.getLogger(PostEventController.class.getName()).log(Level.SEVERE, null, ex);
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
