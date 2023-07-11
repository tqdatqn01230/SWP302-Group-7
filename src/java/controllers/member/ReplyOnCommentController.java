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
import models.Comments.CommentDAO;
import models.Comments.CommentDTO;
import models.Follows.FollowDAO;
import models.Follows.FollowDTO;
import models.replys.ReplyDAO;
import models.replys.ReplyDTO;
import models.user.UserDAO;
import models.user.UserDTO;

/**
 *
 * @author Dell
 */
@WebServlet(name = "ReplyOnCommentController", urlPatterns = {"/ReplyOnCommentController"})
public class ReplyOnCommentController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String VIEW_PAGE="ViewPostsController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=VIEW_PAGE;
        try{
            HttpSession ses=request.getSession();
            UserDTO user=(UserDTO) ses.getAttribute("USER");
            int commentID=Integer.parseInt(request.getParameter("CommentID"));
            String reply=request.getParameter("Reply");
            int eventID= Integer.parseInt(request.getParameter("EventID"));
            ReplyDAO dao=new ReplyDAO();
            ReplyDTO rep=new ReplyDTO(commentID, user.getUserID(), reply);
            CommentDTO cmt; 
            CommentDAO Cmtdao = new CommentDAO();
            int userCommentID= Cmtdao.getUserIDfromComment(commentID);
            UserDAO userDAO = new UserDAO();
            
            FollowDAO followDAO = new FollowDAO();
            FollowDTO follow = followDAO.GetFollow(userCommentID, eventID);
            if (follow==null){
                follow = new FollowDTO(eventID, userCommentID, user.getFullName()+" replied to your comment");
                followDAO.AddFollow(follow);
            }else{
                boolean a=followDAO.ChangeNotificationWhenReply(user.getFullName()+" replied to your comment", eventID, userCommentID);
                System.out.println(a);
            }
            //followDAO.ChangeNotificationWhenReply(url, commentID, commentID)
            dao.addReplys(rep);
        } catch (SQLException ex) {
            Logger.getLogger(CommentOnPostController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReplyOnCommentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ReplyOnCommentController.class.getName()).log(Level.SEVERE, null, ex);
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
