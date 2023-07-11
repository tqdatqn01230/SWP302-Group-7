/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Dell
 */
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<String> Member=new ArrayList<String>();
        List<String> Leader=new ArrayList<String>();
        List<String> Admin=new ArrayList<String>();
        List<String> Register=new ArrayList<String>();
        ServletContext sc=sce.getServletContext();
        String realPath=sc.getRealPath("/");
        String MemberFile=realPath+"/WEB-INF/Authorization/Member.txt";
        String LeaderFile=realPath+"/WEB-INF/Authorization/ClubLeader.txt";
        String AdminFile=realPath+"/WEB-INF/Authorization/Admin.txt";
        String RegisterFile=realPath+"/WEB-INF/Authorization/Register.txt";
        File file=new File(MemberFile);
        try {
            Scanner scan=new Scanner(file);
            while (scan.hasNext()){
                String page= scan.next();
                Member.add(page);
            }
            file = new File(LeaderFile);
            scan=new Scanner(file);
            while (scan.hasNext()){
                String page=scan.next();
                Leader.add(page);
            }
            file = new File(AdminFile);
            scan=new Scanner(file);
            while (scan.hasNext()){
                String page=scan.next();
                Admin.add(page);
            }
            file = new File(RegisterFile);
            scan=new Scanner(file);
            while (scan.hasNext()){
                String page=scan.next();
                Register.add(page);
            }
            Register.add("");
            sc.setAttribute("MemberPages", Member);
            sc.setAttribute("LeaderPages", Leader);
            sc.setAttribute("AdminPages", Admin);
            sc.setAttribute("RegisterPages", Register);
            for(String a:Register){
                System.out.println("=========="+a);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
