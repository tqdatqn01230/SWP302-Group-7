package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import models.Follows.FollowDTO;
import java.util.List;
import models.events.EventsDTO;
import models.user.UserDTO;
import models.eventimage.EventImageDTO;

public final class MemberPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-16\">\n");
      out.write("    <title>LIST EVENTS</title>\n");
      out.write("    <link rel='stylesheet'\n");
      out.write("        href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'>\n");
      out.write("    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style-home.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style-event.css\">\n");
      out.write("\n");
      out.write("</head>\n");
UserDTO user= (UserDTO)session.getAttribute("USER") ;
    String fullname;
    if (user!=null){
        fullname=user.getFullName();
    }else fullname="";
    List<Integer> listEventFollow=(List<Integer>) request.getAttribute("ListEventsFollowed");
    List<FollowDTO> listFollow=(List<FollowDTO>) session.getAttribute("ListNotifications");
    List<EventsDTO> listEvents=(List<EventsDTO>)request.getAttribute("Events");

      out.write("\n");
      out.write("<body>\n");

      out.write("\n");
      out.write("<div data-component=\"navbar\">\n");
      out.write("    <nav class=\"navbar p-0 fixed-top \">\n");
      out.write("        <div class=\"brand\"><a class=\"navbar-brand px-1 logo\" href=\"#\">MEETUP <span>.</span></a>\n");
      out.write("            <div class=\"right-links float-right mr-4\">\n");
      out.write("\n");
      out.write("                <form class=\"d-inline dropdown mr-3\" action=\"SearchEventsController\">\n");
      out.write("                    <input type=\"text\" name=\"Search\"/>\n");
      out.write("                    <button type=\"submit\" style=\"--blue: \">Search</button>\n");
      out.write("                </form>\n");
      out.write("                <a href=\"#\" class=\"home\"><i class=\"mr-3\"></i></a>\n");
      out.write("                <div class=\"d-inline dropdown rounded-0 mx-3\">\n");
      out.write("                    <a class=\"dropdown-toggle\" id=\"tools\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\n");
      out.write("                       aria-expanded=\"false\" href=\"#\"><i class=\"fa fa-wrench\" aria-hidden=\"true\"></i></a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"d-inline dropdown mr-3\">\n");
      out.write("                    <a class=\"dropdown-toggle\" id=\"notifications\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\n");
      out.write("                       aria-expanded=\"false\" href=\"#\"><span>10</span><i class=\"fa fa-bell\"></i></a>\n");
      out.write("                       <div class=\"dropdown-menu dropdown-menu-right rounded-0 pt-0\" aria-labelledby=\"notifications\"\n");
      out.write("                            style=\"margin: 19px;\">\n");
      out.write("                            <div class=\"list-group\">\n");
      out.write("                                <div class=\"lg\">\n");
      out.write("                                    <a href=\"#\"\n");
      out.write("                                        class=\"list-group-item list-group-item-action flex-column align-items-start active\">\n");
      out.write("                                        <h5 class=\"mb-1\">Real Estate Marketing Automation: 6 Simple Systems</h5>\n");
      out.write("                                        <p class=\"mb-0\">17 October 2016 | 9:32 pm</p>\n");
      out.write("                                    </a>\n");
      out.write("                                </div> <!-- /.lg -->\n");
      out.write("                            </div> <!-- /.list group -->\n");
      out.write("                        </div>\n");
      out.write("                </div> <!-- /.dropdown -->\n");
      out.write("                <div class=\"d-inline dropdown mr-3\">\n");
      out.write("                    <a class=\"dropdown-toggle\" id=\"messages\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\n");
      out.write("                       aria-expanded=\"false\" href=\"#\"><i class=\"fa fa-envelope\"></i></a>\n");
      out.write("                </div> <!-- /.dropdown -->\n");
      out.write("                <div class=\"d-inline dropdown\">\n");
      out.write("                    <a class=\"dropdown-toggle\" id=\"messages\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\n");
      out.write("                       aria-expanded=\"false\" href=\"#\">\n");
      out.write("                        <img src=\"img/avatar.png\">\n");
      out.write("                    </a>\n");
      out.write("                </div> <!-- /.dropdown -->\n");
      out.write("            </div> <!-- /.right-links -->\n");
      out.write("        </div>\n");
      out.write("</div> <!-- END TOP NAVBAR -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div data-component=\"sidebar\">\n");
      out.write("    <div class=\"sidebar\">\n");
      out.write("        <ul class=\"list-group flex-column d-inline-block first-menu\">\n");
      out.write("            <li class=\"list-group-item pl-3 py-2\">\n");
      out.write("                <a href=\"http://localhost:8080/EventManagerWebPage/ViewEventsController\"><i class=\"fa fa-home\" aria-hidden=\"true\"><span\n");
      out.write("                        class=\"ml-2 align-middle\">Home</span></i></a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"list-group-item pl-3 py-2\">\n");
      out.write("                <a href=\"http://localhost:8080/EventManagerWebPage/ProfileController\" ><i class=\"fa fa-user-o\" aria-hidden=\"true\"><span\n");
      out.write("                        class=\"ml-2 align-middle\">Your Profile</span></i></a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"list-group-item pl-3 py-2\">\n");
      out.write("                <a href=\"http://localhost:8080/EventManagerWebPage/PrepareLocationController\"><i class=\"fa fa-etsy\" aria-hidden=\"true\"><span\n");
      out.write("                        class=\"ml-2 align-middle\">Event</span></i></a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"list-group-item pl-3 py-2\">\n");
      out.write("                <a href=\"#\"><i class=\"fa fa-calendar\" aria-hidden=\"true\"><span\n");
      out.write("                        class=\"ml-2 align-middle\">Schedule</span></i></a>\n");
      out.write("            </li> <!-- /.list-group-item -->\n");
      out.write("        </ul> <!-- /.first-menu -->\n");
      out.write("    </div> <!-- /.sidebar -->\n");
      out.write("</div>\n");
      out.write("<div class=\"container\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("        ");
for (EventsDTO event:listEvents){
            String imageLink= (String)request.getAttribute("EventImage"+String.valueOf(event.getEventID())); 
      out.write("\n");
      out.write("        <div class=\"col-md-4\">\n");
      out.write("            <div class=\"card user-card\">\n");
      out.write("                <div class=\"card-block\">\n");
      out.write("                    <div class=\"user-image\">\n");
      out.write("                        <img src=\"");
      out.print(imageLink);
      out.write("\" class=\"img-radius\" alt=\"User-Profile-Image\">\n");
      out.write("                    </div>\n");
      out.write("                    <h6 class=\"f-w-600 m-t-25 m-b-10\">");
      out.print(event.getEventContent() );
      out.write(" </h6>\n");
      out.write("                    <p class=\"text-muted\">");
      out.print(event.getStarttime());
      out.write("</p>\n");
      out.write("                    <p class=\"text-muted\">");
      out.print(event.getLocation() );
      out.write("</p>\n");
      out.write("                    <hr>\n");
      out.write("\n");
      out.write("                    <div class=\"bg-c-gray counter-block m-t-10 p-20\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-4\">\n");
      out.write("                                <i class=\"fa fa-user\"></i>\n");
      out.write("                                <p>");
      out.print(event.getFolowers() );
      out.write("</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <p class=\"m-t-15 text-muted\">");
      out.print(event.getDescription() );
      out.write("</p>\n");
      out.write("                    ");
 String button="Follow";
                    if (listEventFollow.contains(event.getEventID())) button="Unfollow";
      out.write("\n");
      out.write("                    <form action=\"MiddleController\">\n");
      out.write("                        <input type=\"hidden\" name=\"EventID\" value=\"");
      out.print(event.getEventID());
      out.write("\"/> \n");
      out.write("                        ");
 if (user.getRole().equals("Member")
                             ||((user.getRole().equals("Leader"))
                                &&(user.getUserID()!=event.getUserID()))){
                        
      out.write("\n");
      out.write("                        <button type=\"submit\" name=\"Action\" value=\"");
      out.print(button);
      out.write("\" class=\"btn btn-primary\">");
      out.print(button);
      out.write("</button>\n");
      out.write("                        \n");
      out.write("                        ");
 } else {
      out.write("\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        <button type=\"submit\" name=\"Action\" value=\"ViewPost\" class=\"btn btn-outline-primary\">VIEW POST</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        <div class=\"col-md-4\">\n");
      out.write("            <div class=\"card user-card\">\n");
      out.write("                <div class=\"card-block\">\n");
      out.write("                    <div class=\"user-image\">\n");
      out.write("                        <img src=\"img/avatar-fcode.png\" class=\"img-radius\" alt=\"User-Profile-Image\">\n");
      out.write("                    </div>\n");
      out.write("                    <h6 class=\"f-w-600 m-t-25 m-b-10\">CUá»C THI FPTU BEWITCHING LOOK</h6>\n");
      out.write("                    <p class=\"text-muted\">Time-Location</p>\n");
      out.write("                    <hr>\n");
      out.write("                    <div class=\"bg-c-gray counter-block m-t-10 p-20\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-4\">\n");
      out.write("                                <i class=\"fa fa-comment\"></i>\n");
      out.write("                                <p>1256</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-4\">\n");
      out.write("                                <i class=\"fa fa-user\"></i>\n");
      out.write("                                <p>8562</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-4\">\n");
      out.write("                                <i class=\"fa fa-suitcase\"></i>\n");
      out.write("                                <p>189</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <p class=\"m-t-15 text-muted\">Lorem Ipsum is simply dummy text of the printing and typesetting\n");
      out.write("                        industry.</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"col-md-4\">\n");
      out.write("            <div class=\"card user-card\">\n");
      out.write("                <div class=\"card-block\">\n");
      out.write("                    <div class=\"user-image\">\n");
      out.write("                        <img src=\"img/avatar-coc.jpg\" class=\"img-radius\" alt=\"User-Profile-Image\">\n");
      out.write("                    </div>\n");
      out.write("                    <h6 class=\"f-w-600 m-t-25 m-b-10\">FPTU DEBATE TOURNAMENT SEASON 2</h6>\n");
      out.write("                    <p class=\"text-muted\">Time-Location</p>\n");
      out.write("                    <hr>\n");
      out.write("\n");
      out.write("                    <div class=\"bg-c-gray counter-block m-t-10 p-20\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-4\">\n");
      out.write("                                <i class=\"fa fa-comment\"></i>\n");
      out.write("                                <p>1256</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-4\">\n");
      out.write("                                <i class=\"fa fa-user\"></i>\n");
      out.write("                                <p>8562</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-4\">\n");
      out.write("                                <i class=\"fa fa-suitcase\"></i>\n");
      out.write("                                <p>189</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <p class=\"m-t-15 text-muted\">Lorem Ipsum is simply dummy text of the printing and typesetting\n");
      out.write("                        industry.</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-md-4\">\n");
      out.write("            <div class=\"card user-card\">\n");
      out.write("                <div class=\"card-block\">\n");
      out.write("                    <div class=\"user-image\">\n");
      out.write("                        <img src=\"img/avatar-coc.jpg\" class=\"img-radius\" alt=\"User-Profile-Image\">\n");
      out.write("                    </div>\n");
      out.write("                    <h6 class=\"f-w-600 m-t-25 m-b-10\">FPTU DEBATE TOURNAMENT SEASON 2</h6>\n");
      out.write("                    <p class=\"text-muted\">Time-Location</p>\n");
      out.write("                    <hr>\n");
      out.write("\n");
      out.write("                    <div class=\"bg-c-gray counter-block m-t-10 p-20\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-4\">\n");
      out.write("                                <i class=\"fa fa-comment\"></i>\n");
      out.write("                                <p>1256</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-4\">\n");
      out.write("                                <i class=\"fa fa-user\"></i>\n");
      out.write("                                <p>8562</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-4\">\n");
      out.write("                                <i class=\"fa fa-suitcase\"></i>\n");
      out.write("                                <p>189</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <p class=\"m-t-15 text-muted\">Lorem Ipsum is simply dummy text of the printing and typesetting\n");
      out.write("                        industry.</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<!-- partial -->\n");
      out.write("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>\n");
      out.write("<script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js'></script>\n");
      out.write("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css'></script>\n");
      out.write("<script src='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'></script>\n");
      out.write("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>\n");
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
