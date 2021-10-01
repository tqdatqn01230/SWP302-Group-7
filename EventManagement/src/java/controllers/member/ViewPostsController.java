/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Comments.CommentDAO;
import models.Comments.CommentDTO;
import models.events.EventsDAO;
import models.events.EventsDTO;
import models.imageandVideo.ImageAndVideoDAO;
import models.imageandVideo.ImageAndVideoDTO;
import models.posts.PostDAO;
import models.posts.PostDTO;
import models.replys.ReplyDAO;
import models.replys.ReplyDTO;

/**
 *
 * @author Dell
 */
@WebServlet(name = "ViewPostsController", urlPatterns = {"/ViewPostsController"})
public class ViewPostsController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String VIEW_PAGE="ViewPostsPage.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=VIEW_PAGE;
        try{
//            HttpSession session=request.getSession();
//            EventsDTO event= (EventsDTO) session.getAttribute("Event");
//            if (event==null){
                EventsDTO event;
                EventsDAO EventDAO=new EventsDAO();
                int eventID=0;
                String ID=request.getParameter("EventID");
                if (ID!=null)eventID=Integer.parseInt(ID) ;
                else eventID=(int) request.getAttribute("EventID");
                event=EventDAO.GetEventByID(eventID);
                request.setAttribute("Event", event);
//            }
            List<PostDTO> list=new ArrayList();
            PostDAO dao =new PostDAO();
            list=dao.getListPost(event.getEventID());
            request.setAttribute("List_Posts", list);
            ImageAndVideoDAO Idao=new ImageAndVideoDAO();
            
            for (PostDTO post:list){
                List<String> LinkList=Idao.getListImage(post.getPostID());
                String chuoi0="ImagesID:"+String.valueOf(post.getPostID());
                request.setAttribute(chuoi0, LinkList);
                CommentDAO cmtdao=new CommentDAO();
                List<CommentDTO> listcomment=cmtdao.getListComment(post.getPostID());
                String chuoi="PostID:"+String.valueOf(post.getPostID());
                request.setAttribute(chuoi, listcomment);
                for (CommentDTO cmt:listcomment){
                    ReplyDAO repDAO=new ReplyDAO();
                    List<ReplyDTO> listPost=repDAO.GetListReplys(cmt.getCommentID());
                    String chuoi1="CmtID:"+String.valueOf(cmt.getCommentID());
                    request.setAttribute(chuoi1, listPost);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewPostsController.class.getName()).log(Level.SEVERE, null, ex);
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
