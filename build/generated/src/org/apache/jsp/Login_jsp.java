package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import models.user.RegisterError;
import models.user.UserDTO;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("   <meta charset=\"UTF-8\">\n");
      out.write("   <title>MEETUP - EVENTS SOLUTION</title>\n");
      out.write("   <link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,700|Raleway:300,600\" rel=\"stylesheet\">\n");
      out.write("   <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("   <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>\n");
      out.write("   <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("   <link rel=\"apple-touch-icon\" sizes=\"57x57\" href=\"img/apple-icon-57x57.png\">\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"60x60\" href=\"img/apple-icon-60x60.png\">\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"72x72\" href=\"img/apple-icon-72x72.png\">\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"img/apple-icon-76x76.png\">\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"114x114\" href=\"img/apple-icon-114x114.png\">\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"120x120\" href=\"img/apple-icon-120x120.png\">\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"144x144\" href=\"img/apple-icon-144x144.png\">\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"152x152\" href=\"img/apple-icon-152x152.png\">\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"180x180\" href=\"img/apple-icon-180x180.png\">\n");
      out.write("<link rel=\"icon\" type=\"image/png\" sizes=\"192x192\"  href=\"img/android-icon-192x192.png\">\n");
      out.write("<link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"img/favicon-32x32.png\">\n");
      out.write("<link rel=\"icon\" type=\"image/png\" sizes=\"96x96\" href=\"img/favicon-96x96.png\">\n");
      out.write("<link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"img/favicon-16x16.png\">\n");
      out.write("<link rel=\"manifest\" href=\"/manifest.json\">\n");
      out.write("<meta name=\"msapplication-TileColor\" content=\"#ffffff\">\n");
      out.write("<meta name=\"msapplication-TileImage\" content=\"/ms-icon-144x144.png\">\n");
      out.write("<meta name=\"theme-color\" content=\"#ffffff\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("   <!-- partial:index.partial.html -->\n");
      out.write("   <div class=\"container\">\n");
      out.write("      <section id=\"formHolder\">\n");
      out.write("         <div class=\"row\">\n");
      out.write("            <!-- Brand Box -->\n");
      out.write("            <div class=\"col-sm-6 brand\">\n");
      out.write("               <a href=\"#\" class=\"logo\">MEETUP <span>.</span></a>\n");
      out.write("               <div class=\"heading\">\n");
      out.write("                  <h2>MEETUP</h2>\n");
      out.write("                  <p>Your Right Choice</p>\n");
      out.write("               </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Form Box -->\n");
      out.write("            ");
RegisterError error = (RegisterError)request.getAttribute("Error");
            if (error==null) error =new RegisterError(); 
      out.write("\n");
      out.write("            <div class=\"col-sm-6 form\">\n");
      out.write("               <!-- Login Form -->\n");
      out.write("               <div class=\"login form-peice switched\">\n");
      out.write("               <form class=\"signup-form\" action=\"RegisterController\" method=\"get\">\n");
      out.write("\n");
      out.write("                  <div class=\"form-group\">\n");
      out.write("                     <label for=\"name\">Full Name</label>\n");
      out.write("                     <input type=\"text\" name=\"FullName\" id=\"name\" class=\"name\">           \n");
      out.write("                     <span class=\"error\">");
      out.print(error.fullname);
      out.write("</span>\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"form-group\">\n");
      out.write("                     <label for=\"email\">Email Adderss</label>\n");
      out.write("                     <input type=\"text\" name=\"Email\" id=\"email\" class=\"email\">\n");
      out.write("                     <input type=\"hidden\" value=\"\" id=\"EmailError\">\n");
      out.write("                     <span class=\"error\">");
      out.print(error.gmail );
      out.write("</span>                  \n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"form-group\">\n");
      out.write("                     <label for=\"name\">User Name</label>\n");
      out.write("                     <input type=\"text\" name=\"UserName\" id=\"name\" class=\"name\">\n");
      out.write("                     <input type=\"hidden\" id=\"UserNameError\" value=\"\"/>\n");
      out.write("                     <span class=\"error\">");
      out.print(error.username);
      out.write("</span>\n");
      out.write("                  </div>\n");
      out.write("\n");
      out.write("                  <div class=\"form-group\">\n");
      out.write("                     <label for=\"password\">Password</label>\n");
      out.write("                     <input type=\"password\" name=\"Password\" id=\"password\" class=\"pass\">\n");
      out.write("                     <span class=\"error\">");
      out.print(error.password);
      out.write("</span>\n");
      out.write("                  </div>\n");
      out.write("\n");
      out.write("                  <div class=\"form-group\">\n");
      out.write("                     <label for=\"passwordCon\">Confirm Password</label>\n");
      out.write("                     <input type=\"password\" name=\"Confirm\" id=\"passwordCon\" class=\"passConfirm\">\n");
      out.write("                     <span class=\"error\">");
      out.print(error.confirmpassword);
      out.write("</span>\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"CTA\">\n");
      out.write("                     <button type=\"submit\">Signup</button>\n");
      out.write("                     <a href=\"#\" class=\"switch\">I have an account</a>\n");
      out.write("                  </div>\n");
      out.write("               </form>\n");
      out.write("            </div>\n");
      out.write("               ");
 String error =(String)session.getAttribute("LOGIN_ERROR");
            if (error==null) error="";
      out.write("\n");
      out.write("            <div class=\"signup form-peice\">\n");
      out.write("               <form class=\"login-form\" action=\"LoginController\" method=\"get\">\n");
      out.write("                  <div class=\"form-group\">\n");
      out.write("                     <label for=\"loginemail\">User Name</label>\n");
      out.write("                     <input type=\"text\" name=\"UserName\" id=\"loginemail\" required>\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"form-group\">\n");
      out.write("                     <label for=\"loginPassword\">Password</label>\n");
      out.write("                     <input type=\"password\" name=\"Password\" id=\"loginPassword\" required>\n");
      out.write("                  </div>\n");
      out.write("                   <span style=\"color: red;\">");
      out.print(error);
      out.write("</span>\n");
      out.write("                  <div class=\"CTA\">\n");
      out.write("                     <button type=\"submit\" value=\"Login\">Login</button>\n");
      out.write("                     <a href=\"forget-password.jsp\" class=\"forget\">Forget Password</a>\n");
      out.write("                     <a href=\"\" class=\"switch\">I'm New</a>\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"or-container\">\n");
      out.write("                     <div class=\"line-separator\"></div>\n");
      out.write("                     <div class=\"or-label\">or</div>\n");
      out.write("                     <div class=\"line-separator\"></div>\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"social\">\n");
      out.write("                     <button type=\"button\" class=\"btn btn-danger\"><a href=\"https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/EventManagerWebPage/LoginByMailController&response_type=code&client_id=320372249105-n9lqj4retbe65vf3coa4go6q6e6jca0i.apps.googleusercontent.com&approval_prompt=force\">GOOGLE</a></button>\n");
      out.write("               </form>\n");
      out.write("            </div>\n");
      out.write("         </div>\n");
      out.write("            </div>\n");
      out.write("      </section>\n");
      out.write("      <footer>\n");
      out.write("      </footer>\n");
      out.write("   </div>\n");
      out.write("   <script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js'></script>\n");
      out.write("   <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>\n");
      out.write("   <script src=\"js/script.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
