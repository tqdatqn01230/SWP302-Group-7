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
import models.imageandVideo.ImageAndVideoDAO;
import models.imageandVideo.ImageAndVideoDTO;

/**
 *
 * @author Dell
 */
@WebServlet(name = "AddImageOnPostController", urlPatterns = {"/AddImageOnPostController"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 50, // 50MB
    maxRequestSize = 1024 * 1024 * 50)
public class AddImageOnPostController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String VIEWPAGE="middlePage.jsp";
    private static final long serialVersionUID = 1L;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        String url=VIEWPAGE;
        try{
            ImageAndVideoDAO dao=new ImageAndVideoDAO();
            int b=Integer.parseInt(request.getParameter("EventID"));
            request.setAttribute("EventID",b );
            
            int postID=0;
            postID= Integer.parseInt(request.getParameter("PostID"));
            for (Part part : request.getParts()) {
                   String fileName = extractFileName(part);
                
                if (fileName.equals("")){
//                    Scanner s= new Scanner(part.getInputStream());
//                    String a="";
//                    while (s.hasNext()) a+=s.next();
//                    if (part.getHeader("Content-disposition").contains("EventID")){
//                        request.setAttribute("EventID", a);
//                    }else if (part.getHeader("Content-disposition").contains("PostID")){
//                        postID=Integer.parseInt(a);
//                    }
                }else {     
                ImageAndVideoDTO image= dao.getImage(postID);
                int imageID;
                if (image.getLink().equals(""))imageID= dao.GetImageID()+1; 
                else  imageID=dao.GetImageID(postID);
                String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
                if (fileType.equals("jfif")) fileType="jpg";
                fileName = "Image"+String.valueOf(imageID)+"." + fileType;
                ImageAndVideoDTO dto=new ImageAndVideoDTO(postID, "asset/images/"+fileName);
                
                if (image.getLink().equals("")){
                        dao.AddImage(dto);
                }else{
                    image.setLink(dto.getLink());
                    dao.UPdateImage(image);
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
        System.out.println("----------"+contentDisp);
        int pos=contentDisp.lastIndexOf("filename=");
        if (pos==-1) return "";
        else return contentDisp.substring(pos+1,contentDisp.length()-1);
    }

    public File getFolderUpload() {
        File folderUpload = new File("C:/Users/Dell/OneDrive/Documents/NetBeansProjects/EventManagerWebPage/web/asset/images");
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
