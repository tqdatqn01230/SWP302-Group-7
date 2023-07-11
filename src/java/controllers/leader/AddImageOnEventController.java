/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.leader;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import models.eventimage.EventImageDAO;
import models.eventimage.EventImageDTO;
import models.imageandVideo.ImageAndVideoDAO;
import models.imageandVideo.ImageAndVideoDTO;

/**
 *
 * @author Dell
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50)
@WebServlet(name = "AddImageOnEventController", urlPatterns = {"/AddImageOnEventController"})
public class AddImageOnEventController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    String VIEWPAGE = "middlePage.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        String url = VIEWPAGE;
        try {
            EventImageDAO dao = new EventImageDAO();
            int eventID = 0;
            eventID = Integer.parseInt(request.getParameter("EventID"));
            request.setAttribute("EventID", eventID);
            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);
                if (fileName.length()!=0){
                String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
                if (fileType.equals("jfif")) fileType="jpg";
                fileName = "Event" + String.valueOf(eventID) + "." + fileType;
                EventImageDTO dto = new EventImageDTO("asset/EventImage/" + fileName, eventID);
                EventImageDTO image = dao.GetImage(eventID);
                if (image==null) dao.AddImage(dto);
                 else {
                    image.setLink(dto.getLink());
                    dao.UpdateImage(image);
                    }
                part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
                }
                

            }
        } catch (SQLException ex) {
            Logger.getLogger(AddImageOnPostController.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher(url).forward(request, response);
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

    public File getFolderUpload() {
        File folderUpload = new File("C:/Users/Dell/OneDrive/Documents/NetBeansProjects/EventManagerWebPage/web/asset/EventImage");
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
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
