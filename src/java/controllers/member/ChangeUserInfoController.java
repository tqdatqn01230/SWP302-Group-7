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
import models.user.RegisterError;
import models.user.UserDAO;
import models.user.UserDTO;

/**
 *
 * @author Dell
 */
@WebServlet(name = "ChangeUserInfoController", urlPatterns = {"/ChangeUserInfoController"})
public class ChangeUserInfoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String CHANGESUCCESS="";
    String url = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String username = request.getParameter("UserName");
            String password = request.getParameter("Password");
            String confirm = request.getParameter("Confirm");
            String fullname = request.getParameter("FullName");
            boolean check = true;
            RegisterError error = new RegisterError();
            UserDAO dao = new UserDAO();
            HttpSession sess = request.getSession();
            UserDTO user = (UserDTO) sess.getAttribute("USER");
            if (username.length() < 3 || username.length() > 13) {
                check = false;
                error.setUsername("UserName length must be in [3,13]");
            }
            UserDTO user1 = dao.getUser(username);
            if (user1 != null) {
                check = false;
                error.setUsername("Duplicate UserName");
            }
            if (password.length() < 3 || password.length() > 15) {
                check = false;
                error.setPassword("Password length must be in [3,15]");
            }
            if (!password.equals(confirm)) {
                check = false;
                error.setConfirmpassword("Confirm password must be the same");
            }
            if (fullname.length() > 100) {
                check = false;
                error.setFullname("Fullname length must be less than 100 characters");
            }
            if (check){
                dao.UpdateUser(user.getUserID(), username, password, fullname);
                url=CHANGESUCCESS;
            }else {
                sess.setAttribute("Error", error);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChangeUserInfoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChangeUserInfoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ChangeUserInfoController.class.getName()).log(Level.SEVERE, null, ex);
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
