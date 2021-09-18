/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.Follows;

/**
 *
 * @author Dell
 */
public class FollowDTO {
    private int eventID;
    private String UserName,Notification;
    private boolean Ischeck;
    public FollowDTO(String UserName, String Notification) {
        this.UserName = UserName;
        this.Notification = Notification;
    }

    public FollowDTO(int eventID, String UserName, String Notification, boolean Ischeck) {
        this.eventID = eventID;
        this.UserName = UserName;
        this.Notification = Notification;
        this.Ischeck = Ischeck;
    }
    
    public void setIscheck(boolean Ischeck) {
        this.Ischeck = Ischeck;
    }

    public boolean isIscheck() {
        return Ischeck;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setNotification(String Notification) {
        this.Notification = Notification;
    }

    public String getUserName() {
        return UserName;
    }

    public String getNotification() {
        return Notification;
    }

    public FollowDTO(int eventID, String UserName, String Notification) {
        this.eventID = eventID;
        this.UserName = UserName;
        this.Notification = Notification;
        this.Ischeck=false;
    }
    
}
