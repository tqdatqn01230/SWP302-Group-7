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
import models.user.UserDAO;
import models.user.UserDTO;

/**
 *
 * @author Dell
 */
@WebServlet(name = "ChangeProfileController", urlPatterns = {"/ChangeProfileController"})
public class ChangeProfileController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */String url="ProfileController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session= request.getSession();
        try{
            String username = request.getParameter("UserName");
            String fullName = request.getParameter("FullName");
            String password = request.getParameter("Password");
            String mobile = request.getParameter("Mobile");
            UserDTO user = (UserDTO) session.getAttribute("USER");
            UserDAO dao = new UserDAO();
            UserDTO checkUser = dao.getUser(username);
            dao.UpdateUser(user.getUserID(), username, password, fullName);
            user.setFullName(fullName);
            user.setPassword(password);
            user.setUserName(username);
            session.setAttribute("USER", user);
        } catch (SQLException ex) {
             Logger.getLogger(ChangeProfileController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(ChangeProfileController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (NamingException ex) {
             Logger.getLogger(ChangeProfileController.class.getName()).log(Level.SEVERE, null, ex);
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
