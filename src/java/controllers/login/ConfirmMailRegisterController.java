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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.user.UserDAO;
import models.user.UserDTO;
import vinh.sendfile.Entry;
import utils.Random;

/**
 *
 * @author Dell
 */
@WebServlet(name = "ConfirmMailRegisterController", urlPatterns = {"/ConfirmMailRegisterController"})
public class ConfirmMailRegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String LOGIN="Login.jsp";
    String REGISTER_SUCCESS_PAGE="login.jsp";
    String CONFIRM_MAIL="ConfirmMailRegister.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=CONFIRM_MAIL;
        try{
            HttpSession session=request.getSession();
            String action=request.getParameter("Action");
            if ("Send Again".equals(action)){
                Entry Mail=new Entry();
                UserDTO user = (UserDTO) session.getAttribute("REGISTER_USER");
                Random random=new Random();
                String code=random.Getcode();
                session.setAttribute("CONFIRM_CODE", code);
                Mail.sendpassword(user.getGmail(), code);
                session.removeAttribute("WRONG_CODE");
            }else if("Confirm".equals(action)){
                String code = request.getParameter("Code");
                String confirm_code = (String) session.getAttribute("CONFIRM_CODE");
                if (code.equals(confirm_code)) {
                    UserDAO dao = new UserDAO();
                    UserDTO user = (UserDTO) session.getAttribute("REGISTER_USER");
                    dao.addUser(user);
                    url = REGISTER_SUCCESS_PAGE;
                    session.removeAttribute("WRONG_CODE");
                    session.removeAttribute("USERNAME");
                    session.removeAttribute("PASSWORD");
                    session.removeAttribute("CONFIRM");
                    session.removeAttribute("EMAIL");
                    session.removeAttribute("FULLNAME");
                }else if("Back".equals(action)){
                    url=LOGIN;
                }else {
                    session.setAttribute("WRONG_CODE", "Wrong confirm Code");
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConfirmMailRegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            response.sendRedirect(url);
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
