/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.user;

/**
 *
 * @author Dell
 */
public class RegisterError {
    public String username="",password="",confirmpassword="",gmail="",fullname="";

    public RegisterError(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public String getGmail() {
        return gmail;
    }

    public String getFullname() {
        return fullname;
    }

    public RegisterError() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
}
