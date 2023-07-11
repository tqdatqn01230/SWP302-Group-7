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
public class UserDTO {
    private int UserID;
    private String UserName,Password,Gmail,Role,FullName;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public UserDTO(int UserID, String UserName, String Password, String Gmail, String Role, String FullName, boolean status) {
        this.UserID = UserID;
        this.UserName = UserName;
        this.Password = Password;
        this.Gmail = Gmail;
        this.Role = Role;
        this.FullName = FullName;
        this.status = status;
    }

    public UserDTO(String UserName, String Password, String Gmail, String Role) {
        this.UserName = UserName;
        this.Password = Password;
        this.Gmail = Gmail;
        this.Role = Role;
    }

    public UserDTO(int UserID) {
        this.UserID = UserID;
    }

    public UserDTO(int UserID, String UserName, String Password, String Gmail, String Role, String FullName) {
        this.UserID = UserID;
        this.UserName = UserName;
        this.Password = Password;
        this.Gmail = Gmail;
        this.Role = Role;
        this.FullName = FullName;
    }

    public UserDTO(String UserName, String Password, String Gmail, String Role, String FullName) {
        this.UserName = UserName;
        this.Password = Password;
        this.Gmail = Gmail;
        this.Role = Role;
        this.FullName = FullName;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setGmail(String Gmail) {
        this.Gmail = Gmail;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public String getGmail() {
        return Gmail;
    }

    public String getRole() {
        return Role;
    }

    public String getFullName() {
        return FullName;
    }
    
}
