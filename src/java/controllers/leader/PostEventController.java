/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.leader;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
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
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50)
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
    private static final long serialVersionUID = 1L;
    String VIEW_PAGE="PrepareLocationController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=VIEW_PAGE;
        try{
            String eventContent=request.getParameter("content");
            int maxfollower=Integer.parseInt(request.getParameter("MaxFollower"));
            String startdate=request.getParameter("startDate");
            String enddate=request.getParameter("endDate");
            
            int locationID=Integer.parseInt(request.getParameter("Location"));
            String Des=request.getParameter("Description");
            
            //Phan xu li sau
            HttpSession ses=request.getSession();
            UserDTO user=(UserDTO) ses.getAttribute("USER");
            int userID=user.getUserID();
            EventsDTO event=new EventsDTO(userID, eventContent,Des, maxfollower);
            EventsDAO eventdao=new EventsDAO();
            eventdao.AddEvent(event);
            LocationDAO locationdao=new LocationDAO();
            int eventID=eventdao.GetEventID();
            //Parse Format date time
            //SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
           // Date start = sdf.parse(startdate);
            //Date end = sdf.parse(enddate);
            //sdf.applyPattern("MM/dd/yyyy");
            startdate =startdate+" 00:00:00";
            enddate=enddate+" 23:59:59";
            TimetableDTO Timetable=new TimetableDTO(eventID,locationID, startdate, enddate);
            TimetableDAO timeDAO =new TimetableDAO();
            timeDAO.AddTimeTable(Timetable);
            request.setAttribute("Mess", "You have posted an event, wait for Admin to accept Event");
        } catch (SQLException ex) {
            Logger.getLogger(PostEventController.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("----------" + contentDisp);
        int pos = contentDisp.lastIndexOf("filename=");
        if (pos == -1) {
            return "";
        } else {
            return contentDisp.substring(pos + 1, contentDisp.length() - 1);
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
