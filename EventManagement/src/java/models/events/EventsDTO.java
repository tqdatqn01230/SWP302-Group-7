/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.events;

/**
 *
 * @author Dell
 */
public class EventsDTO {
    private int EventID,userID;
    private String EventContent;
    private int Folowers,MaxFollowers;

    public EventsDTO(int EventID, int UserName, String EventContent, int Folowers, int MaxFollowers) {
        this.EventID = EventID;
        this.userID = UserName;
        this.EventContent = EventContent;
        this.Folowers = Folowers;
        this.MaxFollowers = MaxFollowers;
    }
    
    public EventsDTO( int UserName, String EventContent, int MaxFollowers) {
        this.userID = UserName;
        this.EventContent = EventContent;
        this.MaxFollowers = MaxFollowers;
        this.Folowers=0;
    }

    public int getEventID() {
        return EventID;
    }

    public int getUserID() {
        return userID;
    }

    public String getEventContent() {
        return EventContent;
    }

    public int getFolowers() {
        return Folowers;
    }

    public int getMaxFollowers() {
        return MaxFollowers;
    }

    public void setEventID(int EventID) {
        this.EventID = EventID;
    }

    public void setUserID(int UserName) {
        this.userID = UserName;
    }

    public void setEventContent(String EventContent) {
        this.EventContent = EventContent;
    }

    public void setFolowers(int Folowers) {
        this.Folowers = Folowers;
    }

    public void setMaxFollowers(int MaxFollowers) {
        this.MaxFollowers = MaxFollowers;
    }
    
}
