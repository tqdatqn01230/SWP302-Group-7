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
    private int EventID;
    private String UserName,EventContent;
    private int Folowers,MaxFollowers;

    public EventsDTO(int EventID, String UserName, String EventContent, int Folowers, int MaxFollowers) {
        this.EventID = EventID;
        this.UserName = UserName;
        this.EventContent = EventContent;
        this.Folowers = Folowers;
        this.MaxFollowers = MaxFollowers;
    }
    
    public EventsDTO( String UserName, String EventContent, int MaxFollowers) {
        this.UserName = UserName;
        this.EventContent = EventContent;
        this.MaxFollowers = MaxFollowers;
        this.Folowers=0;
    }

    public int getEventID() {
        return EventID;
    }

    public String getUserName() {
        return UserName;
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

    public void setUserName(String UserName) {
        this.UserName = UserName;
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
