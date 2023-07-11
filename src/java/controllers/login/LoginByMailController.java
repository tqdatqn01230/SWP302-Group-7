/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import google.*;
import java.util.ArrayList;
import java.util.List;
import models.Follows.FollowDAO;
import models.Follows.FollowDTO;
import models.user.UserDAO;
import models.user.UserDTO;
import utils.NameHelper;
/**
 *
 * @author Dell
 */
@WebServlet(name = "LoginByMailController", urlPatterns = {"/LoginByMailController"})
public class LoginByMailController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     String ERROR_PAGE="Login.jsp";
    String MEMBER_PAGE="ViewEventsController";
    String ADMIN_PAGE="ViewUserController";
    String CLUBLEADER_PAGE="ViewEventsController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");       
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
        String url=ERROR_PAGE;    
        String code = request.getParameter("code");
        if (code == null || code.isEmpty()) {
            RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
            dis.forward(request, response);
        } else {
            String accessToken = GoogleUtils.getToken(code);
            GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
            request.setAttribute("id", googlePojo.getId());
            request.setAttribute("name", googlePojo.getName());
            request.setAttribute("email", googlePojo.getEmail());
            UserDAO dao=new UserDAO();
            boolean check=false;
            UserDTO  user=null;
            String mail=googlePojo.getEmail();
     
            try {
                user=dao.GetMail(mail);
            
                
            } catch (SQLException ex) {
                Logger.getLogger(LoginByMailController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NamingException ex) {
                Logger.getLogger(LoginByMailController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginByMailController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (user==null){ 
                String username=NameHelper.GetName();
                user=new UserDTO(username,"123",mail,"Member","Tôi Dại Dột");
                try {
                    dao.addUser(user);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginByMailController.class.getName()).log(Level.WARNING, null, ex);
                }
            }
            HttpSession session=request.getSession();;
            if (user.isStatus()){
                session.setAttribute("USER", user);
            if (user.getRole().equals("Member")) url=MEMBER_PAGE;
            else if (user.getRole().equals("Admin")) url=ADMIN_PAGE;
            else url=CLUBLEADER_PAGE;
            }else{
                session.setAttribute("LOGIN_ERROR", "Your account have been banned");
                url="Login.jsp";
            }            
            response.sendRedirect(url);
        }
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
