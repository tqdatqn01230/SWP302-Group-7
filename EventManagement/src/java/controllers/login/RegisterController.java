/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import utils.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.AuthenticationFailedException;
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
import dattq.sendfile.*;

/**
 *
 * @author Dell
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String LOGIN_PAGE="Login.jsp";
    String REGISTER_PAGE="RegisterPage.jsp";
    String CONFIRM_MAIL="ConfirmMailRegister.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=REGISTER_PAGE;
        try{
            String username=request.getParameter("UserName");
            String password=request.getParameter("Password");
            String confirm=request.getParameter("Confirm");
            String email=request.getParameter("Email");
            String fullname=request.getParameter("FullName");
            boolean check=true;
            RegisterError error=new RegisterError();
            HttpSession sess=request.getSession();
            sess.setAttribute("USERNAME", username);
            sess.setAttribute("PASSWORD", password);
            sess.setAttribute("CONFIRM", confirm);
            sess.setAttribute("EMAIL", email);
            sess.setAttribute("FULLNAME", fullname);
            if (username.length()<3||username.length()>13){
                check=false;
                error.setUsername("UserName length must be in [3,13]");
            }
            UserDAO dao=new UserDAO();
            UserDTO user=dao.getUser(username);
            if (user!=null){
                check=false;
                error.setUsername("Duplicate UserName");
            }
            if (password.length()<3||password.length()>15){
                check=false;
                error.setPassword("Password length must be in [3,15]");
            }
            if (!password.equals(confirm)){
                check=false;
                error.setConfirmpassword("Confirm password must be the same");
            }
            if (fullname.length()>100){
                check=false;
                error.setFullname("Fullname length must be less than 100 characters");
            }
            String mail[]=email.split("@");
            if (!"fpt.edu.vn".equals(mail[1])){
                check=false;
                error.setGmail("Email must be FPT's Email");
            }
            user=null;user=dao.GetMail(email);
            if (user!=null){
                check=false;
                error.setGmail("This Email already have been used");
            }
            if (!check){
                sess.setAttribute("ERROR", error);
            }else {
                UserDTO user1=new UserDTO(username, password, email, "Member",fullname);
                Entry a=new Entry();
                Random random=new Random();
                String code=random.Getcode();
                a.sendmail(email, code);
                sess.setAttribute("CONFIRM_CODE", code);
                sess.setAttribute("REGISTER_USER",user1);
                url=CONFIRM_MAIL;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
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
