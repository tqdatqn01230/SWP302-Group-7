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
    private int eventID,userID;
    private String Notification;
    private boolean Ischeck;
    public FollowDTO(int UserName, String Notification) {
        this.userID= UserName;
        this.Notification = Notification;
    }

    public FollowDTO(int eventID, int UserName, String Notification) {
        this.eventID = eventID;
        this.userID = UserName;
        this.Notification = Notification;
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

    public void setUserID(int UserName) {
        this.userID= UserName;
    }

    public void setNotification(String Notification) {
        this.Notification = Notification;
    }

    public int getUserID() {
        return userID;
    }

    public String getNotification() {
        return Notification;
    }
}
